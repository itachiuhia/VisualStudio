// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Scanner;

import java.util.*;

// class DataMatrix{
//     int n ;
//     ArrayList[] mat;

//     DataMatrix(int n){
//         this.n = n;
//         mat = new ArrayList[n];
//         for(int i=0;i<n;i++){
//             mat[i] = new ArrayList<>();
//         }

//     }
// }

public class DegreeOfFreedom {
    static int stop[];

    static void findFreedom_2(int n ,int[] arr){

        stop = new int[n];

        int[] mx = new int[n];
        int[] mn = new int[n];
       

        int k =0, c =0;
        int max = arr[0], min = arr[0];
        mx[0] = 0; mn[0] = 0;
        int p_mix = 0, p_min = 0;
        boolean replaceFlag = true;

        for(int i=1 ;i< n;i++){
          //  System.out.println(1);
            if(arr[i] < min){
                mn[k] = i;
                min = arr[i];
                System.out.println(1);

                if(arr[i] < arr[mn[k-1]]){


                    //Checks Requires
                    if(arr[mx[k]] < arr[mx[k-1]]){
                        // mx[k] = mx[k-1];
                        // modify(arr, stop, mx, mn, k);
                        if(findDifference(arr, mx, mn, k)){

                        }
                    }
                }
            }
            else if ( arr[i] > max){
                System.out.println(2);
                max = arr[i];
                mx[k] = i;
            }
            else{
            if(arr[i] == max){
                mx[k] = i;
            }
            if(arr[i] >= min && arr[i] < max){
                
                stop[c] = i-1;
                c++;
                k++;
                max = arr[i]; min=arr[i];
            }
            // if(arr[i] < max && arr[i] != min){
            //     c++;
            //     stop[c] = i-1;
            //     k++;
            //     max = arr[i]; min=arr[i];
            // }
          }
        }

        // for(int p: mx){
        //     System.out.println(p);
        // }

        calcFreedom(arr, mx, mn, k);
    }

    private static void calcFreedom(int[] arr, int[] mx, int[] mn, int k) {
        int total =0;
        for(int i =0; i< k;i++){
            total += arr[mx[i]] - arr[mn[i]];
        }

        System.out.println(total);

    }

    private static void modify(int[] arr, int[] stop, int[] mx, int[] mn, int k) {
        int max = 0;

        for(int i= stop[k-2] ; i< stop[k-1]; i++){
            if(arr[i] > max){
                max = arr[i];
                mx[k-1] = i;
            }
        }

    }
    //Find Difference
    static boolean findDifference(int[] arr, int[] mx, int[] mn, int k){
        int i = k-1;
        int totalDiff = arr[mx[k]] - arr[mn[k]];
        while(i != 0){
            if(arr[mx[i]] > arr[mx[k]]){
                totalDiff += arr[mx[i]] - arr[mn[i]];
            }else{
                break;
            }
            i--;
        }
        if(totalDiff <  arr[mx[i]] - arr[mn[k]]){
            modify(arr, stop, mx, mn, i);
        }

        return false;
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        
        // for(int i=0; i<t; i++){           

                
        // }
        int n = sc.nextInt();
        int arr[] =  new int[n];
        for(int j =0; j<n; j++)
            arr[j] = sc.nextInt();
 

        findFreedom_2(n, arr);

    }
}
    
