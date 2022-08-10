import heapq as hq

n,m=map(int,input().split())
max_heap = []

for i in map(int,input().split()):
    hq.heappush(max_heap,-i)

flag = 1
for i in map(int,input().split()):
    gift = -(hq.heappop(max_heap))
    if i > gift:
        flag = 0
        break
    else:
        hq.heappush(max_heap,-(gift-i))

print(flag)