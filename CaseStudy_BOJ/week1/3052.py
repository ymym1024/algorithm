arr = [int(input()) for _ in range(10)]
num = set()

for i in range(10):
    num.add(arr[i]%42)

print(len(num))