
def magicl_string(s):
    l = len(s)
    res1= ''
    only_A = False

    for ind in range(l-1,-1,-1):
        if(s[ind] == 'B' and only_A == False):
            res1 = s[ind]+res1

        elif(s[ind] == 'A'):
            res1 = s[ind]+res1
            only_A = True

    if(len(res1) > 0):
        return res1

    return "IMPOSSIBLE"    




res = []
T= int(input())
for _ in range(T):
    ip = input()
    res.append(magicl_string(ip))

for ans in res:
    print(ans)

