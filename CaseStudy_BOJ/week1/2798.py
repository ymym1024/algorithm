import itertools

n,m = map(int,input().split())
data = map(int,input().split())

com = list(itertools.combinations(data,3))

near = 0
for c in com:
    temp = sum(c)
    if near < temp <= m:
        near = temp

print(near)


