package keepTrucking;

import java.util.*;

public class MexValue {
    static int k ;
    public static void main(String[] args) {
        int[] n= new int[]{5,5,5,5,5,5,5,5};
        int a[][] = new int[][] {{9,7,5,1,6},
                                  {5,4,1,5,1},
                                  {6,8,1,9,5},
                                  {10,3,10,9,5},
                                  {5,6,2,6,1},
                                  {5,10,7,3,10},
                                  {8,10,3,5,7},
                                  {7,3,9,6,1}      
                                        };
        for(int i=0;i< 8;i++){
            int x = n[i];
            int[] b = a[i];
            int out_ = maximise(x,b);
          System.out.println(out_);

        }                                
        
    }

    private static int maximise(int n, int[] a) {

        int max =-1;        
        boolean repeat = true;
        int i =1;
        int count = 0;
        int pSet =0;
        while(repeat){
            int k = findMex(a,n, i);
            // System.out.println(k);

            if (max< k){
                max = k;
                count = 0;
            }
            if(max >= k){
                count++;
            }
            if(count> 3){
                if(pSet == 0)
                   { 
                       i = power(i);                   
                       int tmp =  findMax(a, n, i);
                       if( tmp > max){
                           return tmp;
                       }else{
                           return max;
                       }
                       
                    }
                }        
            i++;       

        }

        return max;
    }
    private static int findMax(int[] a, int n, int i) {

        int m = -1;
        int k =1;
        while(k<4){
            int x = findMex(a,n, i);
            if(x > m){
                m = x;
            }
            i++;
            k++;
        }
        return m;
    }

    private static int power(int x){
        k = 1;

        for(int i = k ; true; i++){
            int z = (int)Math.pow(2, i) ;
            if( z > x){
                k = i;
                return z-1; 
            }
        }
    }

    private static int findMex(int[] a, int n, int c) {
        SortedSet<Integer> s = new TreeSet<Integer>();
        for(int i=0;i<n ; i++){
            s.add(a[i]^c);
        }
        int i =-1;

        Iterator<Integer> it=s.iterator();  
        while(it.hasNext())  
        {  
           if( ++i != it.next())
            {  
               return i;
           }     
        }

        return i+1;
    }
}
