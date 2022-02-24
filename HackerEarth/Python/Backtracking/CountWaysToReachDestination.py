r,c = 4,4

def countPaths(maze):
    if maze[0][0] == -1:
        return 0

    for i in range(r):

        if maze[i][0] == 0:
            maze[i][0] = 1

        else:
            break

    for i in range(1,c,1):

        if maze[0][i] == 0:
            maze[0][i] = 1

        else:
            break     


    for i in range(1,r,1):
        for j in range(1, c, 1):
            if maze[i][j] == -1:
                continue

            if maze[i-1][j] > 0:
                maze[i][j] += maze[i-1][j]

            if maze[i][j-1] > 0:
                maze[i][j] += maze[i][j-1] 


    if maze[r-1][c-1] > 0:
        return maze[r-1][c-1]

    return 0                               

if __name__ == '__main__':
    maze = [[0, 0, 0, 0],
            [0, -1, 0, 0],
            [-1, 0, 0, 0],
            [0, 0, 0, 0 ]]
    print(countPaths(maze))