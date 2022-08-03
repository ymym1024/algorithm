t = int(input())

arr = [list(map(int, input().split())) for _ in range(t)]
for idx in range(len(arr)):
    n1 = arr[idx][0]
    n2 = arr[idx][1]
    print(f"Case #{idx+1}: {n1} + {n2} = {n1+n2}")
