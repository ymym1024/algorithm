t = int(input())
arr = [input().split() for _ in range(t)]

for i in range(t):
    r = int(arr[i][0])
    s = arr[i][1]
    for string in s:
        print(string*r,end='')
    print()

