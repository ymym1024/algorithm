t = int(input())
arr = [list(map(int, input().split())) for _ in range(t)]

for i in range(t):
    h = arr[i][0]
    w = arr[i][1]
    n = arr[i][2]

    if n % h == 0:
        x = h
        y = n // h
    else:
        x = n % h
        y = n // h + 1

    print((x*100)+y)