
def sumk(i, j):
    if (i+j) %2 == 1:
        return False
    else:
        return (i+j)/2    

def triplets(list, r) :
    l = []
    a, b, c = list
    k1 = sumk(a, b)
    if k1 is not False:
        # a = k1
        l.append(k1)

    k2 = sumk(b, c)
    if k1 is not False:
        # b = k2
        l.append(k2)

    k3 = sumk(c, a)
    if k3 is not False:
        # c = k3 
        l.append(k3)   

    if k1 == False or k2 == False or k3 == False:
        return r

    print(l)
    return triplets(l, r+1)           


def cointTriplets(a, b, c):
    list = [a, b, c]
    res = triplets(list,0)
    return res

A = 4
B = 12
C= 20

print(cointTriplets(A, B, C))