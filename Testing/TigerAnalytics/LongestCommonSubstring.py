

def LCSubStr(X,Y, m, n):

    lcsStuff = [[0 for _ in range(n+1)] for l in range(m+1)]

    result = 0
    length = 0
    r, c = 0,0

    for i in range(m+1):
        for j in range(n+1):
            if(i == 0 or j == 0):
                lcsStuff[i][j] = 0
            elif(X[i-1] == Y[j-1]):
                lcsStuff[i][j] = lcsStuff[i-1][j-1]+1
                result = max(result, lcsStuff[i][j])
                if length < lcsStuff[i][j]:
                    length = lcsStuff[i][j]
                    r,c = i, j
            else:
                lcsStuff[i][j] = 0


    if length == 0:
        print("No Substring Found")

    resulrStr = ['0']*length

    while(lcsStuff[r][c]  != 0):
        length -= 1
        resulrStr[length] =  X[r-1]

        r -= 1
        c -= 1 


    print(''.join(resulrStr))   

    return result         



X = 'OldSite:GeeksforGeeks.org'
Y = 'NewSite:GeeksQuiz.com'
 
m = len(X)
n = len(Y)
 
print('Length of Longest Common Substring is',
      LCSubStr(X, Y, m, n))