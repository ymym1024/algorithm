import sys
sys.setrecursionlimit(100000)

mod = 10007
cache = [[0]*1001 for _ in range(1001)]

for i in range(1001):
    cache[i][0] = cache[i][i] = 1

def bino(n,r):
    if cache[n][r] == 0:
        cache[n][r] = (bino(n-1,r-1)+bino(n-1,r))%mod
    return cache[n][r]


n,k = map(int,input().split())
print(bino(n,k))