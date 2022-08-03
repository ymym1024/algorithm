h,m = map(int, input().split())

if m < 45:
    if h == 0:
        h = 23
    else:
        h=h-1
    m = m-45+60
else :
    m = m-45

print(f"{h} {m}")