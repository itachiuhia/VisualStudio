def maxProfit(prices, n, k):
    profit = [[ 0 for i in range(k+1)] for j in range(n)]

    for i in range(n):

        for j in range(1, k+1):
            maxSoFar = 0

            for l in range(i):
                maxSoFar = max( maxSoFar, prices[i] - prices[l] + profit[l][j-1])

            profit[i][j] = max(profit[i-1][j], maxSoFar)  


    return profit[n-1][k]          


k = 2

prices = [10, 22, 5, 75, 65, 80]

n  = len(prices)
print(f'max profit is {maxProfit(prices, n, k)}')