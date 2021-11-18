package Amazon;

import java.util.*;

public class MinimumOperation {
    public static void main(String[] args) {
        int[] arr = {13,12,12,10,11,5,15,6};
        int k = 2;
        int n = 8;

        int out = minOperation(arr, k, n);
        System.out.print(out);
    }

    private static int minOperation(int[] arr, int k, int n) {

        int c = 0;

        for (int i=0;i<k; i++){
            // Deque<Integer> dq = new ArrayDeque<Integer>();
            ArrayList<Integer> aL = new ArrayList();
            
            for(int j=i; j<n; j+= k){
                // dq.addLast(arr[j]);
                aL.add(arr[j]);
            }

            c += aL.size() - lis(aL);
        }
        return 0;
    }

    private static int lis(ArrayList<Integer> aL) {

        if(aL.size()  == 0) return 0;

        Deque<Integer> b = new ArrayDeque<Integer>();

        b.addLast(aL.get(0));

        for(int i=1; i<aL.size(); i++){
            if(b.getLast() == aL.get(i))
                b.addLast(aL.get(i));
            else{
                int idx = 
            }    
        }


        return 0;
    }
}
