import sys
#  ''' DP Solution '''

def minCost(cost, m, n):
    tc = [[0 for x in range(n+1)] for y in range(m+1)]
    tc[0][0] = cost[0][0]
    
    for i in range(1, m+1):
        tc[i][0] = tc[i-1][0] + cost[i][0]

    for j in range(1, n+1):
        tc[0][1] = tc[0][j-1] + cost[0][j]

    for i in range(1, m+1):
        for j in range(1, n+1):
            tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1])

    return tc[m][n]               


# Driver program to test above functions
cost= [ [1, 2, 3],
        [4, 8, 2],
        [1, 5, 3] ]
print(minCost(cost, 2, 2))




''' Naive Solution '''

'''
def minCost(cost,m, n):
    if n < 0 or m <0:
        return sys.maxsize
    elif m == 0 and n ==0:
        return cost[m][n]
    else:
        return cost[m][n]+ min(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1)) 

def min(x, y, z):
    if (x < y):
        return x if x<z else z
    else:
        return y if y<z else z    

# Driver program to test above functions
cost= [ [1, 2, 3],
        [4, 8, 2],
        [1, 5, 3] ]
print(minCost(cost, 2, 2))

'''