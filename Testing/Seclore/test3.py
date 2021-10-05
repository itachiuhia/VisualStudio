def diffList(a, l, position):

    diffList = []

    for i in range(0,l-position):
        diffList.append(abs(a[i]-a[i+position]))
        diffList.append(abs(a[i]-a[i+position]))
        # abs(a[i] - a[i+pos])

    return diffList    

def solve(n, a, k):
    uniqueList= set(a)
    uLst = a.copy()
    uLst.sort()

    if( k <= n):
        return 0
    else:
        k = k-n

    position = 1 

    for i in range(1,n):
        if k > (n - 1)*2 :
            k = k - ((n - 1)*2)
        else:
            position = i
            k = k 
            break

    finalDiffList = []
    finalDiffList.extend(diffList(a,n,position-1))
    finalDiffList.extend(diffList(a,n,position))
    finalDiffList.extend(diffList(a,n,position+1))
    finalDiffList.sort()

    print(finalDiffList)
    print(k)
    print(position)

    final_k = k + (n-position+1)*2 

    print(final_k)

    ele= finalDiffList[final_k-1]
    return ele 

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    k = int(input())

    out = solve(n, a, k)
    print(out)

def solve (N, val, parent):
    # Write your code here
    pass


# Netcore 2 
# T = int(input())
# for _ in range(T):
#     N = int(input())
#     val = list(map(int, input().split()))
#     parent = list(map(int, input().split()))

#     out_ = solve(N, val, parent)
#     print (' '.join(map(str, out_)))    