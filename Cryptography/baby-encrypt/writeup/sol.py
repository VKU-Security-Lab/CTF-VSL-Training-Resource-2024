def decryp(ct):
    #Nghịch đảo nhân a^-1
    inv = 0
    for i in range(256):
        if (123*i) % 256 == 1:
            inv = i
            break
    pt = []
    # print(inv,ct)
    #Tìm kí tự bị mã hóa:
    for char in ct:
        pt.append((inv * (char-18))%256)
        
    return bytes(pt)
f = open('msg.enc','r')
ct= bytes.fromhex(f.read())
flag= decryp(ct)
print(flag)