n = int(input())

result = 0

for i in range(n):
    a = list(map(int,str(i)))
    s = i + sum(a)

    if s == n:
        result = i
        break

print(result)