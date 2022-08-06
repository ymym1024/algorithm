a,b = map(int,input().split())
num_a = str(a%100)+str(a%10)+str(a/100)

print(a if int(a) > int(b) else b)
