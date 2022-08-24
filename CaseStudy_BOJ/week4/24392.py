mod = 1000000007

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
memo = [[0]*m for _ in range(n)]

for j in range(m):
    memo[n-1][j] = board[n-1][j]

for i in range(n-2,-1,-1):
    for j in range(m):
        if board[i][j]:
            memo[i][j] += memo[i+1][j]

            if j>0:
                memo[i][j] += memo[i+1][j-1]
                memo[i][j]%=mod
            if j<m-1:
                memo[i][j] += memo[i+1][j+1]
                memo[i][j]%=mod

answer = 0
for j in range(m):
    answer+=memo[0][j]
    answer%=mod

print(answer)