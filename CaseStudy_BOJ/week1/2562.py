m = 0
index = 0
for i in range(9):
    n = int(input())
    if i == 0:
        m = n

    if m<n:
        m = n
        index = i

print(f"{m}\n{index+1}")
