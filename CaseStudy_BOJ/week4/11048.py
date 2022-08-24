n,m = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(n)]
memo = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if i:
            memo[i][j] = max(memo[i][j],memo[i-1][j])
        if j:
            memo[i][j] = max(memo[i][j],memo[i][j-1])
        memo[i][j]+=board[i][j]

print(memo[n-1][m-1])
