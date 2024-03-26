# Write up: ancient-crypto

## Author: vovanbao.1808

- Khi chúng ta đọc đề sẽ có 2 file, 1 file python và 1 file output.
- Mã nguồn của file challenge: [Code](/Cryptography/ancient-crypto/challenge/chall.py)

##

Trong mã nguồn của file challenge, ta thấy có 1 function encode như sau:

```python
    def encode(message):
        return hex(bytes_to_long(b64encode(message)))
```

> Mã hóa của bài này chính là: Mã hóa base64 flag đầu tiên, sau đó là mã hóa tiếp sang dạng hex, sau đó ghi vào file output.txt  
> Muốn giải được thử thách này, ta lấy nội dung file output.txt chuyển từ dạng hex sang chuỗi ASCII, sau đó giải mã base64 sẽ ra được flag

## Flag

- ` VSL{y0u_4r3_4nc13nt_4nd_4w3s0m3}`
