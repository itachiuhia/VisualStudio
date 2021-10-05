package keepTrucking ;
import java.util.*;
// import java.io.*;


class CountingPairs{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = 3;
        int k = 1;
        int[] a   = new int[]{5, 7, 1};

        long out_ = solve(n, k, a);
        System.out.println(out_);

        sc.close();

    }

    private static long solve(int n, int k, int[] a) {

        long res = 0;

        int maxEle = 0;
        Arrays.sort(a);
        maxEle = a[n-1];

        int m = (1 << (int)(Math.log(maxEle) / Math.log(2) + 1) ) - 1;
        System.out.println("max --"+m);

        int dp[][]= new int[n+1][m+1];
        dp[0][0] = 1;
        dp[0][a[0]] = 1;

        for(int i=1; i<n; i++){
            for(int j=0; j<m ; j++){
                dp[i][j] = dp[i - 1][j] +
                       dp[i - 1][j ^ a[i - 1]];

                       System.out.println(dp[i - 1][j] +" () "+dp[i - 1][j ^ a[i - 1]]+"-"+dp[i][j]);
                // dp[i][j] += dp[i-1][j];
                // int x = j^a[i];
                // dp[i][j] +=dp[i-1][x];

                int v = dp[i][j]^k;

                if(v == 0){
                    res++;
                }
            }
        }
        return res;
    

        // int dp[][] = new int[n+1][n+1];
        // for(int i=1; i<=n; i++){
        //     dp[0][i] = a[i-1];
        //     dp[i][0] = a[i-1];
        // }

        // long count =0;
        // for(int i=1; i<=n; i++){
        //     for(int j = 1; j<=n; j++){
        //         if(j==0 || j-1 == i || i-1 == j){
        //             dp[i][j] = 1;
        //         }
        //         else
        //         {
        //             dp[i][j] = (dp[i][j-1]^dp[i-1][j]^k);

        //             if(dp[i][j] == 0){
        //                 count++;
        //             }
        //         }                
                
        //     }
        // }


        // return 0;
    }
}
