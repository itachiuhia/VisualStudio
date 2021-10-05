package TestingJava;

public class LongestCommonSubstring {
    
 public static void main(String[] args) {
    String X = "OldSite:GeeksforGeeks.org";
    String Y = "NewSite:GeeksQuiz.com";

    int m = X.length();
    int n = Y.length();

    System.out.println(LCSubStr(X.toCharArray(),
                                Y.toCharArray(), m,
                   n));
 }

private static int LCSubStr(char[] x, char[] y, int m, int n) {

    int LCStuff[][] = new int[m+1][n+1];
    int res = 0;

    for(int i=0; i<= m ; i++){
        for(int j =0; j<=n ;j++){
            if(i==0 |j==0){
                LCStuff[i][j] = 0;
            }else if(x[i-1] == y[j-1]){
                LCStuff[i][j] = LCStuff[i-1][j-1]+1;
                res = Integer.max(res, LCStuff[i][j]);
            }
            else
                LCStuff[i][j] = 0;
        }
    }
    return res;
}   
}
