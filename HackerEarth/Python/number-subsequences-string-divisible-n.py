def countDivisibleSubseq(str, n):
    l = len(str)

    dp = [[ 0 for x in range(l)]
            for y in range(n)]

    dp[0][(ord(str[0]) - ord('0'))%n] += 1

    for i in range( 1, l):
        dp[i][(ord(str[i])-ord('0')) %n] += 1

        for j in range(n):
            dp[i][j] += dp[i-1][j]

            dp[i][(j*10+(ord(str[i]) - ord('0')))%n] += dp[i-1][j]

    return dp[l-1][0]            

if __name__ == "__main__":
     
    str = "1234"
    n = 4
    print(countDivisibleSubseq(str, n))