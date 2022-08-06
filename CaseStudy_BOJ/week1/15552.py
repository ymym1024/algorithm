import sys

t = int(input())
arr = [sys.stdin.readline().strip() for i in range(t)]

for i in arr:
    a,b= map(int,i.split())
    print(a+b)