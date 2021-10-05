def binomialCoff(n, k):
    if(k> n-k):
        k = n-k

    res = 1

    for i in range(k):
        res = res*(n-i)
        res = res / (i+1)

    return res        

n = 8
k = 2

print("value of c(%d ,%d) is %d" %(n, k, binomialCoff(n,k)))
