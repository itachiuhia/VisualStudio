package Java;

import java.util.*;
import java.io.*;

public class SpecialSequence {
    private static String solve(int n, int m, int x, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> res = new ArrayList<>();

        res.add(a[0]);
        int i_a =0,i_b =0;
        boolean add_a = false, add_b = false;
        add_a = true;
        i_a = 1;

        for(int i=1;i<x;i++){
            if(add_a == false){
                while(i_a != n){
                    if(a[i_a] > res.get(res.size()-1)){
                        res.add(a[i_a]);
                        i_a++;
                        add_a = true;
                        add_b = false;
                        break;
                    }
                    i_a++;
                }
                add_a = true;
            }else 
            if(add_b == false){
                while(i_b != m){
                    if(b[i_b] > res.get(res.size()-1)){
                        res.add(b[i_b]);

                        i_b++;
                        add_b = true;
                        add_a = false;
                        break;
                    }
                    i_b++;
                }
                add_b= true;
            }
        }
        for(int k : res){
            System.out.print(k+", ");
        }
        System.out.println();

        if(res.size() == x)
            return "YES";

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);
        int x = Integer.parseInt(ip[2]);
        String[] arrA = br.readLine().split(" ");
         int[] A = new int[n];
        // List<Integer> A = new ArrayList<>();
        for(int i=0; i< n; i++){
            A[i] = Integer.parseInt(arrA[i]);
            // A.add(Integer.parseInt(arrA[i]));

        } 
        String[] arrB = br.readLine().split(" ");
        int[] B = new int[m];
        for(int i=0; i< m; i++){
            B[i] = Integer.parseInt(arrB[i]);
            
        } 

        String out_ = solve(n,m,x,A,B);
        System.out.print(out_);

        // for(int out: out_){
        //     System.out.print(out+" ");
        // }
        System.out.println();
        wr.close();
        br.close();
    }

    
}
