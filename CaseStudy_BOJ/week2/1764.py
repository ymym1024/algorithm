n,m = map(int,input().split())

hear = set()
eye = set()

for _ in range(n):
    hear.add(input())

for _ in range(m):
    eye.add(input())

data = list(hear&eye)
data.sort()

print(len(data))

for d in data:
    print(d)