package Java;

import java.util.Scanner;

public class Segments {

    private static int[] findSegments(int n, int[] ar, int k, int[] query) {
       
        int[] res = new int[k];

        int i = 0;
        for(int index : query){
            int e = ar[index-1];
            int l = leftData(ar ,e, index);
            int r = rightData(ar,e, index);
            res[i++] = l+r+1;
        }

        return res;
    }

    private static int leftData(int[] ar, int e, int index) {
        int total =0;
        
        for(int i = index-2; i>=0 ; i-- ){
            
            if(ar[i] > e){
                break;
            }
            total++;
        }

        return total;
    }

    private static int rightData(int[] ar, int e, int index) {
        int total =0;
        
        for(int i = index; i <ar.length ; i++){
            if(ar[i] > e){
                break;
            }
            total++;
        }

        return total;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];
        for(int i =0; i< n; i++)
            ar[i] = sc.nextInt();
        int query[] = new int[k];
        for(int i =0;i< k;i++)
            query[i] = sc.nextInt();   

        int[] out_ = findSegments(n, ar, k, query); 
        for(int ans: out_){
            System.out.println(ans);
        }  
        
        sc.close();
    }
    
}
