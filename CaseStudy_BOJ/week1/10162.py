t= int(input())

second = [300,60,10]

for s in second:
    if t % 10 >0:
        print(-1)
        break
    else:
        c = t // s
        t = t % s
        print(c,end=' ')