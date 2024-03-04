# ASM Machine

## Author: [Shr3wd](https://github.com/shr3wcl)

## Description

- I have created an environment to practice writing and running ASM - 32bit code. I left a secret in the system, can you get it?
Note: You need to type **end** at the end to end the program
For example: (You can copy and paste it to test)

```asm
section .data
    hello db 'Hello, world!', 0    
    len equ $ - hello

section .text
    global _start                   

_start:
    mov eax, 4                 
    mov ebx, 1         
    mov ecx, hello          
    mov edx, len   
    int 0x80

    mov eax, 1                   
    xor ebx, ebx  
    int 0x80 

end
```
