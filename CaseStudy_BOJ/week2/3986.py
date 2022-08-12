import sys

n = int(input())
word = ""

cnt = 0

for _ in range(n):
    stack = []
    word = sys.stdin.readline().strip()

    for w in word :
        if stack :
            s = stack[-1]
            if s != w :
                stack.append(w)
            else:
                stack.pop()
        else :
            stack.append(w)

    if len(stack) == 0:
        cnt +=1


print(cnt)



