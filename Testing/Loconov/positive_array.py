
def findSol(numDict, a, m):
    totalCount = 0
    compArr = [i for i in range(1, m+1)]

    resulant = [] 

    for num, i in enumerate(a,1):
        interSet = list(set(compArr) - set(i))
        # print(interSet)
        if not interSet:
            continue

        first = numDict[interSet[0]]
        

        for x in interSet[1:]:
            try:

                first = list(set(first).intersection(numDict[x]))
            except KeyError:
                first = []    


        # print(first)
        # totalCount += len(first) 

        for ele in  first:
            if ele > num:
                if (num, ele) not in resulant:
                    resulant.append((num, ele))
            elif (ele, num) not in resulant:
                    resulant.append((ele, num))
        
    print(resulant)
    totalCount += len(resulant) 

    return totalCount       

def nCr(n, r):
        def gcd(a,b): # function to find gcd of two numbers in O(log(min(a,b)))
            if b==0: # base case
                return a
            return gcd(b,a%b)
        if r>n:
            return 0
        if r>n-r: # C(n,r) = C(n,n-r) better time complexity for lesser r value
            r = n-r
        mod = 10**9 + 7
        arr = list(range(n-r+1,n+1)) # array of elements from n-r+1 to n
        ans = 1
        for i in range(1,r+1): # for numbers from 1 to r find arr[j] such that gcd(i,arr[j])>1
            j=0
            while j<len(arr):
                x = gcd(i,arr[j])
                if x>1:
                    arr[j] //= x # if gcd>1, divide both by gcd
                    i //= x
                if arr[j]==1: # if element becomes 1, its of no use anymore so delete from arr
                    del arr[j]
                    j -= 1
                if i==1:
                    break # if i becomes 1, no need to search arr
                j += 1
        for i in arr: # single pass to multiply the numerator
            ans = (ans*i)%mod
        return ans


def updateToDict(numDict,rank, i):

    if( i in numDict):
        x = numDict[i]
        x.append(rank)
        numDict[i] = x
    else:
        numDict[i] = [rank]   

def solve(n, m, a):
    new_a = []
    numDict = {}
    all_0 = 0
    all_GreT_0 = 0
    for rank, x in enumerate(a,1):
        if 0 not in x:
            all_GreT_0 += 1
            # continue
        if all(v == 0 for v in x):
            all_0 += 1
            continue

        y = []
        for i in range(1,m+1):
            if(x[i-1] > 0):
                y.append(i)
                updateToDict(numDict,rank, i)
        new_a.append(y) 

    print(new_a)
    print(numDict)



    out_ = findSol(numDict, new_a,m)  

    if all_GreT_0 > 0:
        print(nCr(3,2))
        out_ += nCr(all_GreT_0,2)

    if all_0 > 0 and all_GreT_0 >0:
        out_ += all_0*all_GreT_0

            
    return out_ 

# a = [[1,2,0],[0,3,0],[4,0,1],[0,0,0]]

n= 3
m=3
a = [[2,5,6],[5,2,1],[7,9,7]]

print(solve(n, m, a))