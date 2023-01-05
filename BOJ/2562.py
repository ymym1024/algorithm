num_arr = []

index = 0
for i in range(9):
    data = int(input())
    num_arr.append(data)

    if i == 0:
        max_num = data
    else :
        if max_num < num_arr[i]:
            max_num = num_arr[i]
            index = i

print(max_num)
print(index+1)