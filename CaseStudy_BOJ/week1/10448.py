k = int(input())
data = [int(input()) for _ in range(k)]
data1 = []

for i in range(1,46):
    data1.append(i*(i+1)//2)

for d in data:
    cnt = 0
    for x in data1:
        for y in data1:
            for z in data1:
                if x+y+z == d:
                    cnt = 1
                    break

    print(cnt)
