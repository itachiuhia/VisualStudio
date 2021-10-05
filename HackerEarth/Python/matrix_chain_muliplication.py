import sys

def MatrixChainOrder(p, n):
    # For simplicity of the program,
    # one extra row and one
    # extra column are allocated in m[][]. 
    # 0th row and 0th
    # column of m[][] are not used
    m = [[0 for x in range(n)] for x in range(n)]
 
    # m[i, j] = Minimum number of scalar
    # multiplications needed
    # to compute the matrix A[i]A[i + 1]...A[j] =
    # A[i..j] where
    # dimension of A[i] is p[i-1] x p[i]
 
    # cost is zero when multiplying one matrix.
    for i in range(1, n):
        m[i][i] = 0
 
    # L is chain length.
    for L in range(2, n):
        for i in range(1, n-L + 1):
            j = i + L-1
            m[i][j] = sys.maxsize
            for k in range(i, j):
 
                # q = cost / scalar multiplications
                q = m[i][k] + m[k + 1][j] + p[i-1]*p[k]*p[j]
                if q < m[i][j]:
                    m[i][j] = q
 
    return m[1][n-1]
 
 
# Driver code
arr = [1, 2, 3, 4]
size = len(arr)
 
print("Minimum number of multiplications is " +
      str(MatrixChainOrder(arr, size)))













# import sys

# def matrixChainOrder(p, n):

#     m = [[0 for x in range(n)] for x in range(n)]

#     for i in range(1, n):
#         m[i][i] = 0

#     for l in range(2, n):
#         for i in range(1, n-l+1):
#             j = i + l-1
#             m[i][j] = sys.maxsize 

#             for k in range(i, j):
#                 q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]

#                 if q < m[i][j]:
#                     m[i][j]  = q


#     return m[1][n-1]                  




# arr = [40, 20, 30, 10, 30]
# n = len(arr)
# print(f'Multiplications is : {0}'.format(matrixChainOrder(arr, n)))