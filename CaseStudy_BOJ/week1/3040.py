import itertools
arr_list = [int(input()) for _ in range(9)]
arr_sum = sum(arr_list)

for i in itertools.combinations(arr_list, 2) :
    com_list = list(i)
    if (arr_sum - sum(com_list)) == 100:
        break

for k in arr_list:
    if k in com_list:
        continue
    print(k)

