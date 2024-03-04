import string
from flag import FLAG

def encryption(msg):
    ct = []
    for char in msg:
        ct.append((123 * char + 18) % 256)
    return bytes(ct)

ct = encryption(FLAG)
f = open('./msg.enc','w')
f.write(ct.hex())
f.close()
