package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class FileViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String sessionId = request.getSession().getId();
        String fileName = request.getParameter("fileName");

        String appPath = request.getServletContext().getRealPath("");
        String uploadPath = appPath + File.separator + "uploads" + File.separator + sessionId;

        String filePath = uploadPath + File.separator + fileName;

        try (FileInputStream fis = new FileInputStream(filePath);
             OutputStream os = response.getOutputStream()) {
            Path path = Paths.get(filePath);
            response.setContentType(Files.probeContentType(path));
            response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }
}
