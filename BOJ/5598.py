s_arr = input()
result = ""

for s in s_arr:
    a = ord(s)-3
    if 62 <= a <= 64:
        a+=26
    result +=chr(a)
print(result)

