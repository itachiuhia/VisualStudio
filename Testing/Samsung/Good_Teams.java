package Samsung;

import java.util.*;


public class Good_Teams {

    public static void main(String[] args)
    {
        Integer[] height = { 2, 6, 7, 5 };
        Integer[] good = {1,3,2,6} ;
        int k = 6;

        // System.out.println(find(height, good, 4, k));

        List<List<Integer>> subsets = subsetsK(good,height, k);
        System.out.println(r);
        for (List<Integer> subset : subsets)
        {
            System.out.println(subset);
        }
        
    }

    static List<List<Integer>> subsetsK(Integer[] arr, Integer[] height, int k)
    {
        int t = 0;
        for (int n : arr) t += n;

        List<List<Integer>> subsets = new ArrayList<>();
        LinkedList<Integer> arrList = new LinkedList<>();
        allSubsets(subsets, arr,height, new BitSet(arr.length), 0, 0, t - k,arrList);

        return subsets;
    }
    static int r =0;
    public static void allSubsets(List<List<Integer>> subsets, Integer[] arr, Integer[] height,BitSet off, int pos, int sum, int lim, LinkedList<Integer> arrList)
    {   
        r++;
        if(sum > lim) return;

        if(pos == arr.length)
        {
            subsets.add(toSubset(arr, off));
            return;
        }
        // System.out.println(arrList);

        if (arrList.size() == 0){
            // arrList.add(pos)
            off.set(pos);
            arrList.add(pos);
            allSubsets(subsets, arr, height, off, pos+1, sum+arr[pos], lim, arrList);  

        }

        if(arrList.size() >0 && height[arrList.getLast()] <= height[pos]){
            off.set(pos);
            arrList.add(pos);
            System.out.println("Adding to LL");
            allSubsets(subsets, arr, height, off, pos+1, sum+arr[pos], lim, arrList); 
        }
      

        off.clear(pos);
        if(arrList.size() != 0) arrList.removeLast();
        allSubsets(subsets, arr,height, off, pos + 1, sum, lim, arrList);
    }

    static List<Integer> toSubset(Integer[] arr, BitSet off)
    {
        List<Integer> ss = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (!off.get(i))
                ss.add(arr[i]);
        }
        return ss;
    } 
    
    static int[][] dp;
    static int process(int[] height, int[] good, int n, int k, int currSum, LinkedList<Integer> arr){
        if (n ==0 ){
            return 0;

        }
        int count =0;
        if(currSum > k){
            return 0;
        }

        if(dp[n][currSum] != -1)
            return dp[n][currSum];
        int inc =0; 
        if(arr.size() >0 && height[(int)arr.getLast()]<= height[n-1]){
            // System.out.println(currSum);
           inc = currSum + good[n-1];
           System.out.println(inc);
        }    
        int exc = currSum;

        int x = process(height, good, n-1, k, exc, arr);
        arr.add(n-1);

        int y = process(height, good, n-1, k, inc,arr );
        count += x+y;
        return count;
    }

    static int find(int[] height,int[] good, int n, int k){
        dp = new int[n+1][k+1];

        for(int i = 0;i <= n;i++){
            for(int j = 0; j <= k;j++){
                dp[i][j] = -1;
            }
        }

        int currSum = 0;
        LinkedList<Integer> arr = new LinkedList<>();
        return process(height,good, n, k, currSum,arr);
    }


}

