
def canVote(a, n, x):

    dp = [[0]*(x+1) for _ in range(n+1)]
    a = a[:]
    a.append(0)

    sum = 0

    for i in range(n+1):
        sum += a[i]

    for i in range(1, n+1):
        for j in range(1, x+1):
            print(f'{a[i]} <= {j}')
            if a[i] <= j:
                print(f'dp[{i}][{j}] = max( dp[{i-1}][{j}] , a[{i}] + dp[{i-1}][{j}-a[{i}]])')
                dp[i][j] = max( dp[i-1][j] , a[i] + dp[i-1][j-a[i]])
            else:
                print(f'dp[{i}][{j}] = dp[{i-1}][{j}]')
                dp[i][j] = dp[i-1][j]


    return (sum-dp[n][x])<=x                
        


# Driver Code
if __name__ == "__main__":
    n = 3
    x = 4
    a = [2, 4, 2]
    print("YES" if canVote(a, n, x) else "NO")