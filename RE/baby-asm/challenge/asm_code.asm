0x0000118d <mysteryFunc>:
   0x0000118d <+0>:     55                      push   ebp
   0x0000118e <+1>:     89 e5                   mov    ebp,esp
   0x00001190 <+3>:     53                      push   ebx
   0x00001191 <+4>:     83 ec 24                sub    esp,0x24
   0x00001194 <+7>:     e8 19 01 00 00          call   0x12b2 <__x86.get_pc_thunk.ax>
   0x00001199 <+12>:    05 5b 2e 00 00          add    eax,0x2e5b
   0x0000119e <+17>:    c7 45 e6 56 53 4c 52    mov    DWORD PTR [ebp-0x1a],0x524c5356
   0x000011a5 <+24>:    66 c7 45 ea 45 00       mov    WORD PTR [ebp-0x16],0x45
   0x000011ab <+30>:    c7 45 f0 00 00 00 00    mov    DWORD PTR [ebp-0x10],0x0
   0x000011b2 <+37>:    c7 45 f4 00 00 00 00    mov    DWORD PTR [ebp-0xc],0x0
   0x000011b9 <+44>:    c7 45 ec 00 00 00 00    mov    DWORD PTR [ebp-0x14],0x0
   0x000011c0 <+51>:    eb 49                   jmp    0x120b <mysteryFunc+126>
   0x000011c2 <+53>:    8b 55 ec                mov    edx,DWORD PTR [ebp-0x14]
   0x000011c5 <+56>:    8b 45 08                mov    eax,DWORD PTR [ebp+0x8]
   0x000011c8 <+59>:    01 d0                   add    eax,edx
   0x000011ca <+61>:    0f b6 00                movzx  eax,BYTE PTR [eax]
   0x000011cd <+64>:    0f b6 d8                movzx  ebx,al
   0x000011d0 <+67>:    8b 4d ec                mov    ecx,DWORD PTR [ebp-0x14]
   0x000011d3 <+70>:    ba 67 66 66 66          mov    edx,0x66666667
   0x000011d8 <+75>:    89 c8                   mov    eax,ecx
   0x000011da <+77>:    f7 ea                   imul   edx
   0x000011dc <+79>:    d1 fa                   sar    edx,1
   0x000011de <+81>:    89 c8                   mov    eax,ecx
   0x000011e0 <+83>:    c1 f8 1f                sar    eax,0x1f
   0x000011e3 <+86>:    29 c2                   sub    edx,eax
   0x000011e5 <+88>:    89 d0                   mov    eax,edx
   0x000011e7 <+90>:    c1 e0 02                shl    eax,0x2
   0x000011ea <+93>:    01 d0                   add    eax,edx
   0x000011ec <+95>:    29 c1                   sub    ecx,eax
   0x000011ee <+97>:    89 ca                   mov    edx,ecx
   0x000011f0 <+99>:    0f b6 44 15 e6          movzx  eax,BYTE PTR [ebp+edx*1-0x1a]
   0x000011f5 <+104>:   0f be c0                movsx  eax,al
   0x000011f8 <+107>:   31 d8                   xor    eax,ebx
   0x000011fa <+109>:   69 c0 37 33 01 00       imul   eax,eax,0x13337
   0x00001200 <+115>:   99                      cdq
   0x00001201 <+116>:   01 45 f0                add    DWORD PTR [ebp-0x10],eax
   0x00001204 <+119>:   11 55 f4                adc    DWORD PTR [ebp-0xc],edx
   0x00001207 <+122>:   83 45 ec 01             add    DWORD PTR [ebp-0x14],0x1
   0x0000120b <+126>:   8b 55 ec                mov    edx,DWORD PTR [ebp-0x14]
   0x0000120e <+129>:   8b 45 08                mov    eax,DWORD PTR [ebp+0x8]
   0x00001211 <+132>:   01 d0                   add    eax,edx
   0x00001213 <+134>:   0f b6 00                movzx  eax,BYTE PTR [eax]
   0x00001216 <+137>:   84 c0                   test   al,al
   0x00001218 <+139>:   75 a8                   jne    0x11c2 <mysteryFunc+53>
   0x0000121a <+141>:   8b 45 f0                mov    eax,DWORD PTR [ebp-0x10]
   0x0000121d <+144>:   8b 55 f4                mov    edx,DWORD PTR [ebp-0xc]
   0x00001220 <+147>:   8b 5d fc                mov    ebx,DWORD PTR [ebp-0x4]
   0x00001223 <+150>:   c9                      leave
   0x00001224 <+151>:   c3                      ret