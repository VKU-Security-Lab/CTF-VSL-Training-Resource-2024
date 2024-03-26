# Write up: baby-encrypt

## Author: vovanbao.1808

- Khi chúng ta đọc đề sẽ có 2 file, 1 file python và 1 file msg.enc.
- Mã nguồn của file challenge: [Code](/Cryptography/baby-encrypt/challenge/chall.py)

##

1. Giải thích các hoạt động của thuật toán mã hóa trên:

Trong mã nguồn của file challenge, ta thấy có 1 function encode như sau:

```python
        def encryption(msg):
            ct = []
            for char in msg:
                ct.append((123 * char + 18) % 256)
            return bytes(ct)
```

##

> Phân tích cách mã hóa:

1. Hàm Encryption(msg): Nhận một chuỗi msg cần được mã hóa.
2. Mã hóa:

- Mỗi ký tự trong chuỗi msg được mã hóa theo một cách tính toán đặc biệt.
- Duyệt qua từng ký tự char trong chuỗi msg.
- Với mỗi ký tự char:
  - Thực hiện phép tính (123 \* char + 18) % 256:
  - Nhân ký tự char với 123.
  - Cộng thêm 18.
  - Lấy phần dư khi chia cho 256.
  - Kết quả của phép tính được thêm vào mảng ct.

3. Kết quả:

- Mảng ct chứa kết quả của việc mã hóa.
- Kết quả được trả về dưới dạng một đối tượng bytes.

4. File msg.enc:

- Tạo một file msg.enc chứa nội dung đã mã hóa ở function encryption dưới dạng hex.

Lời giải:

1. Chuyển đổi từ Hex sang Byte: Chuyển đổi dữ liệu từ file msg.enc từ dạng hex sang dạng byte.
2. Tìm Nghịch Đảo Nhân: Tìm giá trị nghịch đảo của biểu thức 123 \_ i % 256, trong đó i từ 1 đến 256.
3. Giải Mã Từng Ký Tự: Giải mã từng ký tự trong dữ liệu đã chuyển đổi bằng cách sử dụng phép tính i \_ (char - 18) mod 256, với i là nghịch đảo nhân đã tìm được và char là giá trị của ký tự cần giải mã.
4. Solve
   [Code Solve](/Cryptography/baby-encrypt/writeup/sol.py)

## Flag

- `VSL{H1_Th3r3_1_4m_4_B4bY_3ncrypt10n_4lgor1thm}`
