import sys

n = int(input())
arr = [sys.stdin.readline().strip() for i in range(n)]

cnt = n
for word in arr:
    word_list = {}
    for w in range(len(word)):
        if word[w] in word_list:
            index = word_list.get(word[w])
            if index+1 != w:
                cnt-=1
                break
            else:
                word_list[word[w]] = w
        else:
            word_list[word[w]] = w

print(cnt)