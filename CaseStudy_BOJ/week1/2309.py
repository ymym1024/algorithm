import itertools

data = [int(input()) for _ in range(9)]

com = list(itertools.combinations(data,7))
arr = []

for i in com:
    if sum(i) == 100:
        arr = list(i)
        break

arr.sort()
for i in arr:
    print(i)