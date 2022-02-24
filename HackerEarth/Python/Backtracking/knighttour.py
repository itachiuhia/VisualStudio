from importlib.machinery import EXTENSION_SUFFIXES


n = 8

def printSolution(n, boards):
    for i in range(n):
        for j in range(n):
            print(boards[i][j], end = " ")
        print()    

def isSafe(x, y, boards):

    if x>=0 and y>=0 and x<n and y< n and boards[x][y] == -1:
        return True

    return False       

def solveKT(n):

    board = [[-1 for i in range(n)] for i in range(n)]

    move_x = [2,1,-1,-2,-2,-1, 1,2]
    move_y = [1,2,2, 1,-1, -2, -2, -1]

    board[0][5] = 0
    pos = 1

    if not solveUtil(n, board, 0,0, move_x, move_y, pos):
        print("Solution does not exist")
    else:
        printSolution(n, board)


def solveUtil(n , board, curr_x, curr_y, move_x, move_y, pos):

    if pos == n*n:
        return True

    else:
        for i in range(8):
            new_x = curr_x + move_x[i]
            new_y = curr_y + move_y[i]    

            if isSafe(new_x, new_y, board):
                board[new_x][new_y] = pos

                if(solveUtil(n, board, new_x, new_y, move_x, move_y, pos+1)):
                    return True 


                board[new_x][new_y] = -1

    return False            


if __name__ == "__main__":
     
    # Function Call
    solveKT(n)