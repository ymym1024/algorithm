s=input()
cro_alpha = ['c=','c-','dz=','d-','lj','nj','s=','z=']
cnt = 0

for c in cro_alpha:
    cnt += s.count(c)

print(len(s)-cnt)