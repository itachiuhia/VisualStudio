package Clootrack;

import java.util.*;

public class Disconnect {
    public static void main(String[] args) {
        int n = 9;
        int m = 5;
        Integer[][] q = new Integer[][] {{1,8},
                            {2,7},{3,5},{4,6},{7,9}
                            };

        System.out.println(solve(n, m, q));
    }

    public static int solve(int N, int M, Integer[][] c) {
        int minCuts = 0;
        if(M == 0) return 0;
        // sorting based on the start city in increasing order.
        Arrays.sort(c, (Integer[] a, Integer[] b) -> {
            return a[0] - b[0];
        });
    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // as soon as I finds any end city in my minHeap which is less than equal to my current start city, I increment mincuts and remove all elements from the minHeap. 
        for(int i = 0; i < M ; i++) {
            int start = c[i][0];
            int end = c[i][1];
    
            if(!minHeap.isEmpty() && minHeap.peek() <= start) {
                minCuts += 1;
                while(!minHeap.isEmpty()) {
                    minHeap.poll();
                }
            }
            minHeap.add(end);
        }
    
        return minCuts + 1;
    }
}
