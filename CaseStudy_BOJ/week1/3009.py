arr = [list(map(int, input().split())) for _ in range(3)]
x_list = []
y_list = []

for i in range(3):
    x_list.append(arr[i][0])
    y_list.append(arr[i][1])

for j in range(3):
    if x_list.count(x_list[j]) == 1:
        x = x_list[j]
    if y_list.count(y_list[j]) == 1:
        y = y_list[j]

print(f"{x} {y}")