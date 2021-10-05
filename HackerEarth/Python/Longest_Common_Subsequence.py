


''' DP Solution '''
def lcs(x, y):
    m  = len(x)
    n = len(y)

    l =  [[None]*(n+1) for i in range(m+1)]

    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0:
                l[i][j] = 0
            elif x[i-1] == y[j-1]:
                l[i][j] = l[i-1][j-1]+1
            else:
                l[i][j] = max(l[i-1][j], l[i][j-1]) 

    print(f"Length of LCS is {l[m][n]} \nPrinting LCS")
    
    index = l[m][n]
    lcs = [""]*(index+1)
    lcs[index] = ""

    i = m; j= n

    while(i>0 and j>0):
        if x[i-1] == y[j-1]:
            lcs[index-1] = x[i-1]
            i -= 1
            j -= 1
            index -= 1

        elif l[i-1][j] > l[i][j-1]:
            i = i-1
        else:
            j = j-1

    print(f'{"".join(lcs)}') 

    # return "Completed"                       

#Driver program to test the above function
X = "AGGTAB"
Y = "GXTXAYB"
lcs(X, Y)
# print("Length of LCS is ", lcs(X, Y))
# 



















''' Naive Solution '''
'''
def lcs(X , Y, m, n):

    if m == 0 or n == 0:
        return 0

    elif X[m-1] == Y[n-1]:
        return 1+ lcs(X, Y, m-1, n-1)

    else:
        return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n))


X = "AGGTAB"
Y = "GXTXAYB"
print("Length of LCS is ", lcs(X , Y, len(X), len(Y)))

'''