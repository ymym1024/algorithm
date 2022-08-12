from collections import defaultdict
import sys

while True:
    cd = defaultdict(bool)
    n, m = map(int, sys.stdin.readline().split())
    cnt = 0
    if n == 0 and m == 0:
        break
    for _ in range(n):
        cd[int(sys.stdin.readline())] = True
    for _ in range(m):
        if cd[int(sys.stdin.readline())]:
            cnt += 1

    print(cnt)