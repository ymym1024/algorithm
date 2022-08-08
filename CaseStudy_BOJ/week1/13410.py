n,k = map(int,input().split())
data = list(map(lambda x:int(str(n*x)[::-1]), range(1,k+1)))

max_cnt = max(data)
print(max_cnt)