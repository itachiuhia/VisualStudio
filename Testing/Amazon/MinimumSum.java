package Amazon;

import java.util.*;

class MinimumSum{
    public static void main(String[] args) {
        
        int number = 6628;

        int[] nArr = Integer.toString(number).chars().map(c -> c-'0').toArray();
        
        // for(int i=0;i<len; i++){
        //     nArr[i] = Integer.valueOf(ch[i]);

        // }
        int len = nArr.length;
        int sum = findMinSum(nArr, len);
        System.out.println(sum);

    }

    private static int findMinSum(int[] a, int n) {

        Arrays.sort(a);
       
        int num1 = 0;
        int num2 = 0;
        for(int i = 0;i<n;i++){
            if(i%2==0)
                num1 = num1*10+a[i];
            else num2 = num2*10+a[i];
        }
        return num2+num1;
        
    }
}