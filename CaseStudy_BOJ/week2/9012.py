t = int(input())

for i in range(t):
    vps = input()
    stack = []
    flag = 'YES'

    for c in vps:
        if c == '(':
            stack.append(c)
        else:
            if stack:
                stack.pop()
            else:
                flag = 'NO'
                break

    if stack :
        flag = 'NO'
    print(flag)
