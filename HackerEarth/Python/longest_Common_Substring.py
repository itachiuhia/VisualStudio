
def printLCSSubStr(x: str, y: str, m: int, n: int):
    lcs = [[0 for _ in range(n+1)] for _ in range(m+1)]
    length = 0
    row, col = 0,0

    for i in range(m+1):
        for j in range(n+1):
            # lcs[i][j] = 0
            if i == 0 or j==0:
                lcs[i][j] = 0
            elif x[i-1] == y[j-1]:
                lcs[i][j] = lcs[i-1][j-1] +1
                if length < lcs[i][j]:
                    length = lcs[i][j]
                    row = i
                    col = j
            else:
                lcs[i][j] = 0        
    if length ==0 :
        print("No Common Substring")
        return 

    result = ['0']*length

    while lcs[row][col] != 0:
        length -= 1

        result[length] = x[row-1]

        row -= 1
        col -= 1
        
    print(''.join(result))    

    



if __name__ == "__main__":
    X = "OldSite:GeeksforGeeks.org"
    Y = "NewSite:GeeksQuiz.com"
    m = len(X)
    n = len(Y)
 
    printLCSSubStr(X, Y, m, n)