
def findPrefixOne(l):

    try:
        ind = l.index(0)
    except ValueError:
        ind = -1

    
    if(ind == -1):
        return len(l)

    return ind    
         
def rotate(a,n):
    l = list()
    l = a[n-1:n]+ a[0:n-1]
    return l


def prefix_queries(n, a, q, query):

    l = a.copy()

    res = list()

    count_2 = query.count(2)

    if(1 not in a):
        res = [0]*count_2
        return res

    if( 0 not in a):
        res = [N]*count_2
        return res


    for e in query:
        if( e == 2):
            res.append(findPrefixOne(l))
        else:
            l = rotate(l,N)
            # print(l)    
    
    return res



out = list()
T_inputs = list()

T = int(input())

for _ in range(T):
    inputs = list()

    N = int(input())
    inputs.append(N)

    A = list(map(int, input().split()))
    inputs.append(A)

    Q = int(input())
    inputs.append(Q)

    queries = list(map(int, input().split()))
    inputs.append(queries)

    T_inputs.append(inputs)

    # out_ = prefix_queries(N, A, Q, queries)
    # out.append(out_)
    # print(out_)
    # print(' '.join(map(str, out_)))

for i in T_inputs:
    out_ = prefix_queries(i[0], i[1], i[2], i[3])
    out.append(out_)


for out_ in out:
    print(' '.join(map(str, out_)))