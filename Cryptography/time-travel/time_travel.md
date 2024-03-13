# Write up: Time_Travel

## Author: Bien

## English

- The encoding structure of this article has 2 parts: `encChar = (char + randomNumber) % 256` (char are FLAG characters) and `int(bytes(timeSecret).hex(), 16)` including conversion Encoded string into bytes and bytes into hex and then hex into integer string.
- Based on the `random` function, we think this encryption is random encryption, but when combined with the `seed` function, the random function will return a random result that remains unchanged after many runs.
- At this time, I realized that if we capture the current time that the `time` function passes in, we will be able to decode the FLAG because we can predict the number that appears in the random function.

   - For example:

   - ```python (assume time is constant)
     random.seed(seed)
     randomNumber = random.randint(0, MAX) -> 72, 101, 152
     ``` (no matter how many times you run the program, the value is always 72, 101, 152)
    
- To solve this problem we need to use option **1 Get time proof** to know the current time of the program when continuously randomizing each character of FLAG. After getting the result, we convert it to hex string removes the first 2 characters '0x' then converts to bytes.
- After decoding part 1, I continue to decode part 2 by running the decoding loop. If I decode a string with characters starting with **VSL**, the time I find is correct. When running the program, if the loop is not correct, it will run a second time with a delay of 999 and so on until the result is found and printed on the screen.

- Use Python to create a program that sends requests to the server. For this we need to use the option **1 Get time proof** so we use the command **io.sendlineafter(b':', b'1 ')** to send option **1 Get time proof** after the program encounters the sign **:**

   - Because **Travel_Time** starts with the character string **Evidence of time:** consisting of 17 characters, we use the command **io.recvline().decode("utf-8").strip()[ 17:]** To start getting data after the 17th character, when I get the character string, convert it to a hex string and remove the first 2 characters '0x` then convert it to bytes
    - For example:

   - ```python
     cipher = bytes.fromhex(hex(data)[2:])
     ```
   - After decoding part 1, we continue to decode part 2. To decode part 2, we need to find the running time **Travel_Time** to assign to the seed function to help our random function produce the same results as random part in **Travel_Time**
  - Use the program to capture the current time when running **Travel_Time** by subtracting the delay of 1s from the program's current time, using a loop to delay the time until the running time is found. **Travel_Time**
   - For example:

   - ```python
     temp_t = int(time.time())
     for t in range(temp_t, temp_t-1000, -1):
     ```
   - After finding the seed, I continue to decode by continuously randomizing the length of the FLAG character string to get the same result as the encoding part. Then I decode by reversing the above formula again. Repeat running 2 strings cipher and seq to subtract seq from cipher and divide to get remainder by 256 then convert into 1 byte array if the result contains string starting with `VSL` then print the result FLAG and seed I get
     - For example:

   - ```python
     seq = [random.randint(0, MAX) for _ in range(len(cipher))]
         b = bytes([(c-r)%256 for c, r in zip(cipher, seq)])
     ```
     

## Tiếng việt

- Cấu trúc mã hóa của bài này có 2 phần là `encChar = (char + randomNumber) % 256` (char là các kí tự FLAG) và  `int(bytes(timeSecret).hex(), 16)` gồm chuyển đổi chuỗi đã mã hóa thành bytes và từ bytes thành hex rồi từ hex thành chuỗi số nguyên .
- Dựa vào hàm `random` ta nghĩ mã hóa này là mã hóa ngẫu nhiên nhưng khi đi với hàm `seed` thì hàm random sẽ trả về 1 kết quả ngẫu nhiên không đổi sau nhiều lần chạy
- Lúc này mình nhận thấy nếu bắt được thời điểm hiện tại mà hàm `time` truyền vào thì ta sẽ có thể giải mã được FLAG vì ta có thể dự đoán được số xuất hiện ở hàm random.

  - Ví dụ:

  - ```python (giả sử time không đổi)
    random.seed(seed)
    randomNumber = random.randint(0, MAX) -> 72, 101, 152
    ``` (khi chạy chương trình bao nhiêu lần thì giá trị vẫn luôn là 72, 101, 152)
    
- Để giải bài toán này chúng ta cần sử dụng option **1 Get time proof** để biết được thời điểm hiện tại của chương trình khi random liên tục với từng kí tự của FLAG, sau khi có kết quả mình chuyển đổi thành chuỗi hex loại bỏ 2 kí tự đầu là `0x`sau đó chuyển đổi thành dạng bytes.
- Sau Khi đã giải mã xong 1 phần mình tiếp tục giải mã phần 2 bằng cách cho chạy vòng lặp chạy giải mã nếu giải mã chuỗi có các kí tự bắt đầu bằng **VSL** thì thời gian mình tìm được đã đúng với lúc chạy chương trình nếu không đúng vòng lặp sẽ chạy lần 2 với độ trễ là 999 cứ như vậy cho tới khi tìm ra kết quả và in ra màn hình.

- Sử dụng Python để tạo ra một chương trình gửi request đến cho server, vì này chúng ta cần sử dụng option **1 Get time proof** nên ta dùng lệnh  **io.sendlineafter(b':', b'1')** để gửi option **1 Get time proof** sau khi chương trình gặp dấu **:**

  - vì **Travel_Time** bắt đầu với chuỗi kí tự **Evidence of time:** gồm 17 kí tự nên ta dùng lệnh **io.recvline().decode("utf-8").strip()[17:]** để bắt đầu lấy dữ liệu từ sau kí tự thứ 17, khi lấy được chuỗi kí tự mình chuyển đổi nó thành chuỗi hex và loại bỏ 2 kí tự đầu là `0x` sau đó đổi thành dạng bytes
   - Ví dụ:

  - ```python
    	cipher = bytes.fromhex(hex(data)[2:])
    ```
  - Sau khi giải mã được 1 phần ta tiếp tục giải mã phần 2, để giải mã phần 2 ta cần tìm ra được thời điểm chạy **Travel_Time** để gán vào hàm seed giúp hàm random của mình cho ra kết quả giống với phần random ở  **Travel_Time**
 - Sử dụng chương trình để bắt được thời điểm hiện tại khi chạy **Travel_Time** bằng cách lấy thời điểm hiện tại của chương trình trừ đi độ trễ là 1s sử dụng vòng lặp để lùi thời gian đến khi tìm ra thời điểm chạy **Travel_Time** 
  - Ví dụ:

  - ```python
    	temp_t = int(time.time())
    	for t in range(temp_t, temp_t-1000, -1):
    ```
  - Sau khi tìm được seed mình tiếp tục giải mã bằng cách cho random liên tục bằng với độ dài của chuỗi kí tự FLAG để ra được kết quả giống với phần encode sau đó mình decode bằng cách đảo công thức ở trên lại mình cho vòng lặp chạy 2 chuổi cipher và seq để trừ seq ra khỏi cipher và chia lấy dư cho 256 sau đó chuyển thành 1 mảng byte nếu kết quả có chứa chuỗi bắt đầu bằng `VSL` thì in ra kết quả FLAG và seed mình lấy được
    - Ví dụ:

  - ```python
    	seq = [random.randint(0, MAX) for _ in range(len(cipher))]
        b = bytes([(c-r)%256 for c, r in zip(cipher, seq)])
    ```

## Flag

- `VSL{}`i theo 
