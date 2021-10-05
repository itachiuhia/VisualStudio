import sys

def rotateLeft(l, n):
    return l[n:] + l[:n]

def rotateRight(l, n):
    return l[-n:]+l[:-n]
 
def minDiffSubArray(arr, n):
    total_sum = 0

    for i in range(n):
        total_sum += arr[i]
 
    prefix_sum = 0
    # print(f'total sum {total_sum}')
    minDiff = sys.maxsize
 
    for i in range(n - 1):
        prefix_sum += arr[i]
 
        diff = abs((total_sum -  prefix_sum) - prefix_sum)
        # print(diff)
 
        if (diff < minDiff):
            minDiff = diff
 
    return minDiff

def solve(n, q, a, queries):
    res = []
    for x in queries:
        if x[0] == 1:
            l = rotateRight(a, x[1]%n)
            print(f'for this query {x[0]} and {x[1]}')
            res.append(minDiffSubArray(l, n))
            print(l)
        if x[0] == 2:
            l = rotateLeft(a, x[1]%n)
            # print(f'for this query {x[0]} and {x[1]}')
            res.append(minDiffSubArray(l, n))
            # print(l)    
    
    return res

# t = 2
n, q = 3, 2
# a = [52,88,78,46,95,84,98,55]
a = [2,1,3]
queries = [[1,0],[1,2]]
# queries = [[1,0],[2,35],[2,65],[1,21],[1,26],[1,23],[1,86]]

out_ = solve(n, q, a, queries)

print(out_)