n = int(input())
sen = input()
length = [0]*n
string = list()
oper = list()

for i in range(n):
    length[i] = int(input())

for s in sen:
    if s =="+" or s=="-" or s=="*" or s=="/" :
        oper.push(string.pop())
        oper.push(s)
    else:
        if len(oper)!= 0:


        oper.clear()
        string.push(len[ord(s)-ord('A')])

print(list(string))