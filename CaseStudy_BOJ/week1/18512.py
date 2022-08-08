x,y,p1,p2 = map(int,input().split())

p1_list = [p1]
p2_list = [p2]

i = 0
cnt = -1
while True:
    x1 = p1_list[i]+x
    y1 = p2_list[i]+y

    p1_list.append(x1)
    p2_list.append(y1)

    if y1 in p1_list or x1 in p2_list:
        cnt = min(x1,y1)
        break

    if i >= 1000:
        break
    i+=1

print(cnt)