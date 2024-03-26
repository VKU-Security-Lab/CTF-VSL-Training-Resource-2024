# Write up: ancient-crypto

## Author: vovanbao.1808

- Khi chúng ta đọc đề sẽ có 2 file, 1 file python và 1 file output.
- Mã nguồn của file challenge: [Code](/Cryptography/ancient-crypto/challenge/chall.py)

##

Dựa theo vào mã nguồn của challenge, ta có thể hỉểu được thuật toán mã hóa của bài này như sau:

- Base64 : Flag ban đầu được mã hóa sử dụng thuật toán Base64 để chuyển đổi từ dữ liệu nhị phân sang dạng văn bản ASCII. Kết quả là một chuỗi ký tự Base64.

- Chuyển sang dạng hex: Chuỗi Base64 từ bước trước sau đó được chuyển đổi sang dạng hex. Mỗi ký tự trong chuỗi Base64 sẽ được chuyển đổi thành hai ký tự trong hệ thập lục phân.

- Ghi vào file output.txt: Chuỗi hex từ bước trước sau đó được ghi vào một file văn bản có tên là "output.txt".

Từ đó, ta có thể giải mã lại như sau:

- Đọc từ file output.txt và chuyển từ dạng hex sang ASCII: Nội dung của file "output.txt" được đọc và chuyển đổi từ dạng hex sang dạng chuỗi ASCII. Điều này đảm bảo ta có được chuỗi gốc được mã hóa.

- Giải mã Base64: Chuỗi ASCII thu được từ bước trước sau đó được giải mã từ Base64 để lấy ra flag ban đầu.

## Flag

- ` VSL{y0u_4r3_4nc13nt_4nd_4w3s0m3}`
