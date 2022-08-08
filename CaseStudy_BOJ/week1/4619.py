data = []

a = 0
while True:
    l = list(map(int, input().split()))
    if l == [0,0]:
        break
    b= l[0]
    n= l[1]

    a = int(b**(1/n))
    if abs(b - a**n) < abs(b-(a+1)**n):
        data.append(a)
    else:
        data.append(a+1)

for d in data:
    print(d)
