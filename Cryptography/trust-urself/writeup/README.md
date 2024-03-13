# Write up: Trust Urself

## Author: Bien

## English

- The encryption structure of this article is `xor -> hash -> hex`.
- Based on the `hash(xor(message,FLAG)).hex()` function, we know that each character of **FLAG** will be xored with each character of the message we enter, then It is hashed using the SHA256 algorithm.
- At this point, I realize that if I xor a long string with its starting substring, the result will be a hex string **\x00** with a length equal to the length of the substring.

  - For example:

  - ```python
     xor("VSL{test}", "VSL") == "\x00\x00\x00"
     ```

- Then our direction is to use option **2) Check Your Signature** to Brute Force each letter of the FLAG to find the correct letter by comparing the hash code calculated by the program with the code. hash of **0x00**, for each correct letter we will receive the message **"Signature validated"** and continue like that to find the next letter and compare it with the hash code when adding a pair of **0x00**.
- Use Python to create a program to find each character and compare it with the **SHA256** code of **0x00**. For each correct character, the program will receive the message **"Signature validated"**, then the program will add that correct character to the FLAG and add a pair of hex codes **0x00** to the hash check string.
- Payload python: [Payload](./solve.py)
- **For example:** With the structure **VSL{**, the program will enter **V** and compare with **\x00**(A \x00 because of the length of the flag at this time when Brute Force is 1) in **SHA256** format. When receiving the message **"Signature validated"**, the program will add the character **V** to the string **FLAG** and add **0x00** to it. comparison string. The program continues to search for each character and finds the letter **S**, then the string **FLAG** is **"VS"** and the comparison string is **\x00\x00**, continuing until When finished with **"}"** we will get a complete Flag.

## Tiếng việt

- Cấu trúc mã hóa của bài này là `xor -> hash -> hex`.
- Dựa vào hàm `hash(xor(message,FLAG)).hex()` ta biết được với mỗi kí tự của **FLAG** sẽ được đem đi xor với mỗi kí tự của message mà ta nhập vào, sau đó nó được đem đi hash bằng thuật toán SHA256.
- Lúc này mình nhận thấy nếu đem xor một chuỗi dài với một chuỗi con bắt đầu của nó thì kết quả thu về sẽ là một chuỗi hex 00 có độ dài bằng với độ dài của chuỗi con.

  - Ví dụ:

  - ```python
    xor("VSL{test}", "VSL") == "\x00\x00\x00"
    ```

- Khi đó hướng đi của ta là sẽ dùng lựa chọn **2) Check Your Signature** để Brute Force từng chữ cái một của FLAG để tìm ra chữ cái đúng bằng cách đem mã hash được chương trình tính toán so sánh với mã hash của **0x00**, với mỗi chữ đúng ta sẽ nhận được thông báo **"Signature validated"** và tiếp tục như vậy tìm chữ cái tiếp theo và so sánh với mã hash khi thêm 1 cặp **0x00**.
- Sử dụng Python để tạo ra một chương trình để tìm từng kí tự và so sánh với mã **SHA256** của **0x00**. Khi với mỗi kí tự đúng chương trình sẽ nhận về thông báo **"Signature validated"**, khi đó chương trình sẽ thêm kí tự đúng đó vào FLAG và thêm 1 cặp mã hex **0x00** vào chuỗi kiểm tra hash.
- Payload python: [Payload](./solve.py)
- **Ví dụ:** Với cấu trúc **VSL{**, chương trình sẽ nhập vào **V** và so sánh với **\x00**(Một \x00 vì độ dài của flag lúc này khi Brute Force là 1) ở dạng **SHA256** khi nhận thông báo **"Signature validated"** chương trình sẽ thêm kí tự **V** vào chuỗi **FLAG** và thêm **0x00** vào chuỗi so sánh. Chương trình tiếp tục tìm từng kí tự và tìm đc chữ **S** khi đó chuối **FLAG** là **"VS"** và chuỗi so sánh là **\x00\x00**  tiếp tục cho tới khi kết thục bằng dấu **"}"** ta sẽ được 1 Flag hoàn chỉnh

## Flag

- `VSL{UNBR3AK4BL3_H4SH3S_4R3_4_L13_FMWIFSF912F8N1}`
