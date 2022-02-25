n =4


def isSafe(board, r, c):

    for i in range(c):
        if board[r][i] == 1:
            return False

    for i , j in zip(range(r ,-1 -1), range(c, -1, -1)):

        if board[i][j] == 1:
            return False

    for i, j in zip(range(r, n , 1), range(c, -1, -1)):
        if board[i][j] == 1:
            return False

    return True                


def solveNQUtil(board, col):


    if col >= n:
        return True

    for i in range(n):
        if isSafe(board, i , col):
            board[i][col] = 1
            if solveNQUtil(board, col+1) == True:
                return True

            board[i][col] = 0;    

    return False

def printSolution(board):
    for i in range(n):
        for j in range(n):
            print (board[i][j], end = " ")
        print()
        
if __name__ == '__main__':
    board = [ [0, 0, 0, 0],
              [0, 0, 0, 0],
              [0, 0, 0, 0],
              [0, 0, 0, 0] ]
  
    if solveNQUtil(board, 0) == False:
        print ("Solution does not exist")
        
  
    printSolution(board)
    