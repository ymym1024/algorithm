x,y,w,h = map(int,input().split())

n1 = w-x
n2 = h-y

print(min(x,y,n1,n2))