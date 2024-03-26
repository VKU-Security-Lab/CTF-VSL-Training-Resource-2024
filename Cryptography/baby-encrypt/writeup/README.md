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

> Dưới đây là một phân tích về cách mã hóa hoạt động:

- Hàm encryption(msg) nhận vào một chuỗi msg cần được mã hóa.
- Mã hóa được thực hiện theo cách tính toán mới cho từng ký tự trong chuỗi msg.
- Vòng lặp duyệt qua từng ký tự char trong chuỗi msg.
- Đối với mỗi ký tự char, nó sẽ thực hiện phép tính (123 \* char + 18) % 256:
  - Đầu tiên, nó nhân ký tự char với 123.
  - Sau đó, cộng thêm 18.
  - Kết quả của phép tính này sau đó được chia lấy phần dư cho 256.
  - Kết quả của phép tính này được thêm vào mảng ct.
- Kết quả của mảng ct sau đó được trả về dưới dạng một đối tượng bytes.
  Tiếp theo, trong file chall có tạo ra một file msg.enc với nhiệm vụ là ghi nội dung đã được mã hóa ở `function encryption` dưới dạng hex 2.

##

> Lời giải:

Bước 1: Chuyển đổi từ Hex sang Byte  
Trước tiên, chúng ta cần chuyển đổi dữ liệu từ tệp msg.enc từ dạng hex sang dạng byte.  
Bước 2: Tìm Nghịch Đảo Nhân  
Tiếp theo, chúng ta cần tìm giá trị nghịch đảo của biểu thức 123 \* i % 256, trong đó i là số từ 1 đến 256. Để làm điều này, chúng ta sẽ thực hiện một vòng lặp từ 1 đến 256 và kiểm tra điều kiện đã cho.  
Bước 3: Giải Mã Từng Ký Tự  
Cuối cùng, chúng ta sẽ giải mã từng ký tự trong dữ liệu đã chuyển đổi bằng cách sử dụng phép tính i \* (char−18) mod 256, trong đó i là nghịch đảo nhân đã tìm được ở bước trước và char là giá trị của ký tự cần giải mã.

[Code Solve](/Cryptography/baby-encrypt/writeup/sol.py)

## Flag

- `VSL{H1_Th3r3_1_4m_4_B4bY_3ncrypt10n_4lgor1thm}`
