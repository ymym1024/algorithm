n = int(input())
arr = [input() for _ in range(n)]

for i in arr:
    o_cnt = 0
    o_sum = 0
    for j in i:
        if j == "O":
            o_cnt+=1
            o_sum+=o_cnt
        else:
            o_cnt=0
    print(o_sum)
