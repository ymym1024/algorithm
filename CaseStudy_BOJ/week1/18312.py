n,k = input().split()
cnt = 0
time = ""
for hour in range(0,int(n)+1):
    for min in range(0,60):
        for sec in range(0,60):
            time=f"{format(hour,'02')}{format(min,'02')}{format(sec,'02')}"
            if time.count(k) > 0:
                cnt+=1

print(cnt)
