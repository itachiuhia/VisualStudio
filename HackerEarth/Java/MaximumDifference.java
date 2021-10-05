package Java;

import java.util.Arrays;

public class MaximumDifference {

    static int getMinDiff(int[] arr, int n, int k){
        if( n == 1)
            return 0;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];

        int small = arr[0] +k;
        int big = arr[n-1] - k;
        int temp = 0;

        if(small>big){
            temp = small;
            small = big;
            big = temp;
        }

        for(int i=1; i< n-1; i++){
            int sub = arr[i] -k;
            int add = arr[i] + k;

            if(sub >= small || add<= big)
                continue;
            
            if(big - sub <= add- small)
                small = sub;
            else 
                big = add;    
        }

        return Math.min(ans, big-small);
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 10 , 15};
        int n = arr.length;
        int k =3;
        System.out.println("Max Diff is : >"+ getMinDiff(arr, n, k));

    }
}
