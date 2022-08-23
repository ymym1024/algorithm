n = int(input())
cache = [0]*(100)

def f(i):
    if i == 0:
        return 0
    elif i == 1:
        return 1

    if cache[i] != 0:
        return cache[i]

    cache[i] = f(i-1)+f(i-2)
    return cache[i]


print(f(n))