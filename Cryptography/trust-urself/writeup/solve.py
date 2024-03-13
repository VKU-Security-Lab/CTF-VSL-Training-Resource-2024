from pwn import *
from hashlib import sha256

# Change the IP and port to the one of your server
r = remote('127.0.0.1', 9000)

flag = ""
checkHash = b"\x00"

while True:
    for i in range(33, 126):
        r.recvuntil(b"$ ")
        r.sendline(b"2")
        r.recvuntil(b"$ ")
        
        checkFlag = flag + chr(i)
        
        r.sendline(checkFlag.encode())
        r.recvuntil(b"$ ")
        
        hashed = sha256(checkHash).digest().hex()
        r.sendline(hashed.encode())
        
        response = r.recvline().decode()
        
        if "Validated" in response:
            flag += chr(i)
            checkHash += b"\x00"
            print("Flag now: " + flag)
            # If the flag is complete, print it and exit
            if "}" in flag:
                print("Flag: " + flag)
                exit()
            break