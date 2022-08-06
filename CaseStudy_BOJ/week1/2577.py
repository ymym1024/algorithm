a,b,c = [int(input()) for _ in range(3)]
multi = str(a*b*c)
for i in '0123456789':
    print(multi.count(i))