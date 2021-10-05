package java;

import java.util.*;


public class Solution {
    
    public static void main(String[] args) {
      List<Integer> ll = new ArrayList<Integer>(1, 2, 5, 9);
        System.out.println(printSolution(ll, 6));
    }

    static int printSolution(List<Integer> ll, int t){
        int l = 1;
        int h = Integer.MAX_VALUE;
        while(l < h){
            int m = l + (h-l)/2;
            if(isCorrect(m, ll, t)){
                h = m;
            }else{
                l = m+1;
            }
        }

        return h;
    }

    static boolean isCorrect(int h, List<Integer> ll, int t){
        int sum = 0;
        for(int i=0; i< ll.size(); i++){
            sum += Math.ceil((double) ll.get(i)/(double) h);
        }
        return sum <= t;
    }

}
