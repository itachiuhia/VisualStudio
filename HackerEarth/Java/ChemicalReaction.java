package Java;

import java.util.Arrays;
import java.util.Scanner;

public class ChemicalReaction {
    private static int findValue(int dr, int n, int[] powers) {

        // HashTable
        int i =0, j=1;
        int sum_min = Integer.MAX_VALUE, min_diff = Integer.MAX_VALUE;
        int sum_f = -1;

        Arrays.sort(powers);

        while(i<n && j< n){
            if(i==j)
                continue;
            if( i!= j && powers[j] - powers[i] == dr){
                min_diff = 0;
                if(sum_f == -1){
                    sum_min = powers[j]+powers[i];
                    sum_f = sum_min;
                }else{
                    if(sum_f >  powers[j]+powers[i]){
                        sum_f = powers[j]+powers[i] ;
                        sum_min = sum_f;
                    }
                }
                if(i > j)
                    j++;
                else
                    i++;   
            }
            else if(powers[j] - powers[i] < dr){
                int diff = Math.abs(powers[j] - powers[i] - dr) ;
                if(diff < min_diff){
                    min_diff = diff; 
                    sum_min = powers[j] + powers[i] ;
                }else if(diff == min_diff && powers[j] + powers[i] < sum_min){
                    sum_min = powers[j] + powers[i];
                }
                j++;
            }else {
                int diff =Math.abs(powers[j] - powers[i] - dr)  ;
                if(diff < min_diff){
                    min_diff = diff;
                    sum_min = powers[j] + powers[i] ;
                }else if(diff == min_diff && powers[j] + powers[i] < sum_min){
                    sum_min = powers[j] + powers[i];
                }
                i++;
            }
        }

        return sum_min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int n = sc.nextInt();
       
        int[] powers = new int[n];
        for(int i=0; i< n; i++){
            powers[i] = sc.nextInt();          

        }
        int out_ = findValue(dr, n, powers);
        System.out.println(out_);

        sc.close();
    }

   
}
