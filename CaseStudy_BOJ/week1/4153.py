arr = []
while True:
    l = list(map(int, input().split()))
    if l == [0,0,0]:
        break
    arr.append(l)

for i in arr:
    i.sort()
    if (i[0]*i[0]) + (i[1]*i[1]) == (i[2]*i[2]) :
        print("right")
    else:
        print("wrong")