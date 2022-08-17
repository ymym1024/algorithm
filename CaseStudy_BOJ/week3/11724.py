import sys
sys.setrecursionlimit(10000)

def dfs(now):
    chk[now] = 1
    for node, l in enumerate(adj[now]):
        if chk[node] or not l:
            continue
        dfs(node)

n, m = map(int, input().split())
adj = [[0]*n for _ in range(n)]

cnt = 0
chk = [0 for _ in range(n)]

for _ in range(m):
    u, v = map(lambda x: x-1, map(int, input().split()))
    adj[u][v] = 1
    adj[v][u] = 1

for i in range(n):
    if not chk[i]:
        dfs(i)
        cnt+=1


print(cnt)