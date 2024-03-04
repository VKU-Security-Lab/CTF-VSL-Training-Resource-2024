package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/zip-upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 5 * 1024 * 1024)
public class FileUploadZipServlet extends HttpServlet {
    private static final String UPLOAD_PATH = "/uploads";
    private static final String UNZIP_PATH = "/tmp/unzip/";
    private static final String TEMP_PATH = "/tmp/";
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Get the session ID
        String sessionId = session.getId();

        String uploadPath = getServletContext().getRealPath("/uploads" + File.separator + sessionId);

        File[] files = new File(uploadPath).listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                fileNames.add(file.getName());
            }
        }

        request.setAttribute("uploadedFiles", fileNames);

        request.getRequestDispatcher("/WEB-INF/view/zip-upload.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String sessionId = session.getId();

        String appPath = request.getServletContext().getRealPath("/");

        String tempDirectory = TEMP_PATH;
        String uploadDirectory = appPath + File.separator + UPLOAD_PATH + File.separator + sessionId;

        createDirectoryIfNotExists(tempDirectory);
        createDirectoryIfNotExists(uploadDirectory);
        String msg = "Success";
        for (Part part : request.getParts()) {
            String fileName = getSubmittedFileName(part);

            Path filePath = Paths.get(tempDirectory, fileName);
            try (InputStream input = part.getInputStream()) {
                Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            if (!checkZip(filePath)){
                msg = "Not zip";
            }
            unzip(filePath.toString());
            saveImage(new File(UNZIP_PATH), uploadDirectory);
            Files.delete(filePath);
        }

        response.getWriter().println(msg);
    }
    private boolean checkZip(Path filePath) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filePath.toFile()))) {
            return zipInputStream.getNextEntry() != null;
        } catch (IOException e) {
            return false;
        }
    }
    private void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (!directory.mkdirs()){
                throw new RuntimeException("Cannot create directory: " + directoryPath);
            }
        }
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public static void unzip(String zipFilePath) throws IOException {
        File destDir = new File(UNZIP_PATH);
        if (!destDir.exists()) {
            if (!destDir.mkdirs()) {
                throw new IOException("Cannot create directory: " + destDir);
            }
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();

            while (entry != null) {
                String filePath = UNZIP_PATH + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                }else{
                    File dir = new File(filePath);
                    if (!dir.exists() && !dir.mkdir()){
                        throw new IOException("Cannot create directory1: " + dir);
                    }
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zipIn.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private void saveImage(File folder, String uploadPath) throws IOException {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if(file.isDirectory()){
                        saveImage(file, uploadPath);
                        if ( !file.delete() ){
                            throw new IOException("Cannot delete directory: " + file);
                        }
                    }
                    else{
                        String fileName = file.getName();
                        if (!fileName.toLowerCase().endsWith(".png")) {
                            if(!file.delete()){
                                throw new IOException("Cannot delete file: " + file);
                            }
                        }
                    }
                }
            }
        }

        File destinationFolder = new File(uploadPath);

        if (!destinationFolder.exists()) {
            if(!destinationFolder.mkdirs()){
                throw new IOException("Cannot create directory: " + destinationFolder);
            }
        }

        File[] allFiles = folder.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                    String newFileName = timeStamp + "-" + file.getName();
                    Files.move(file.toPath(), destinationFolder.toPath().resolve(newFileName), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
