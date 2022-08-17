from collections import deque

n,m = map(int,input().split())
memo = [input() for _ in range(n)]

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)

def is_valid_coord(y, x):
    return 0 <= y < n and 0 <= x < m

def bfs():
    chk = [[False] * m for _ in range(n)]
    chk[0][0] = True
    q = deque()
    q.append((0, 0, 1))
    while q:
        y, x, d = q.popleft()

        if y == n-1 and x == m-1 :
            return d

        nd = d+1
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]

            if is_valid_coord(ny, nx) and not chk[ny][nx] and memo[ny][nx] == '1':
                chk[ny][nx] = True
                q.append((ny, nx, nd))

print(bfs())