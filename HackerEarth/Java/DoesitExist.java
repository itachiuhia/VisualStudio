package Java;

import java.io.*;


public class DoesitExist {
    private static String solve(int n, int[] p, int m, int[] q) {
        int y =0;

        for(int i =0; i< n-m; i++){
            if(p[i] < q[y]){
                continue;
            }else{
                int k = p[i]/q[y] ;
                if(p[i+1]/k == q[y+1] && p[i+m-1]/k == q[m-1]){
                    boolean res = compare(p, i+2, q, m,k,y+2);
                    if(res == true)
                        return "YES";
                }
            }
           
        }

        return "NO";
    }
    private static boolean compare(int[] p, int i, int[] q, int m, int k, int y) {

        if(i == y){
            return true;
        }

        if(p[i]/k == q[y] && p[i+m-y-1]/k == q[m-y-1]){
            return compare(p, i+1, q, m, k, y+1);
        }


        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        // int t = Integer.parseInt(br.readLine().trim());
        // for(int i=0; i< t; i++)
        // {
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().split(" ");
            int[] p = new int[n];
            for(int j=0; j<n; j++){
                p[j] = Integer.parseInt(arr[j]);   
            }
            int m = Integer.parseInt(br.readLine().trim());
            String[] arr2 = br.readLine().split(" ");
            int[] q = new int[m];
            for(int j=0; j<m; j++){
                q[j] = Integer.parseInt(arr2[j]);   
            }

            System.out.println(solve(n,p,m,q));

        // 4}
    }

}
