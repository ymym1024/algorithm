x,y = [int(input()) for _ in range(2)]

print(1 if x>0 and y>0 else (2 if x<0 and y>0 else (3 if x<0 and y<0 else 4)))