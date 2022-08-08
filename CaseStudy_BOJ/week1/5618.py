n = int(input())

if n == 2 :
    num1,num2 = list(map(int,input().split()))
    min_num = min(num1,num2)
else:
    num1,num2,num3 = list(map(int,input().split()))
    min_num = min(num1,num2,num3)

division = []


for i in range(1,min_num+1):
    if n ==2 :
        if num1 % i == 0 and num2 % i ==0:
            division.append(i)
    else:
        if num1 % i == 0 and num2 % i == 0 and num3 % i == 0:
            division.append(i)

division.sort()
for d in division:
    print(d)


