bs = [int(input()) for _ in range(10)]

hab = bs[0]
for i in range(1,len(bs)) :
    hab+=bs[i]
    if hab >= 100:
        if abs(100 - hab) > abs(100 - (hab-bs[i])):
            hab-=bs[i]
            break

print(hab)
