import collections

def countOccur(str):
    l = collections.Counter(str).most_common()
    most = l[0][1]

    count =0
    for tp in l:
        count += tp[1]

    count = count - most

    return (most, count)

def findRes(n, str):
    tp = countOccur(str)
    i = tp[1] - n
    if(not(i < 0)):
        return tp[0]+n
    else:
        if(abs(i)%2 == 1):
            return tp[0]+tp[1]-1
        else:
            return tp[0]+tp[1]

def solve(n, m, p, q, r):
    resP = findRes(n,p)
    resQ = findRes(n, q)
    resR = findRes(n, r)

    l = [resP, resQ, resR]

    if(max(l) == resP and max(l) != resQ and max(l) != resR):
        return str("Bob")
    if(max(l) == resQ and max(l) != resP and max(l) != resR):
        return "Ben"
    if(max(l) == resR and max(l) != resQ and max(l) != resP):
        return "Mike"   

    return "Draw"    



N = int(input())
M = int(input())
P = input()
Q = input()
R = input()

out_ = solve(N, M, P, Q, R)
print(out_)


# str = "abceAfeAbcde"

# l= collections.Counter(str).most_common()
# i =0

# count = 0
# for tp in l:
#     count += tp[1]

# print(count - l[0][1])

# print((l[2][1]))
# for ele in l:
#     print(ele[0], end= ", ")
#     i += 1

# print()
# print(collections.Counter(str).most_common())

# def solve(n, m, p, q, r):


#     pass



# N = int(input())
# M = int(input())
# P = input()
# Q = input()
# R = input()

# out_ = solve(N, M, P, Q, R)
# print(out_)




       