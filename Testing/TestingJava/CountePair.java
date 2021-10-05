// import .GFG.*;
import java.util.*;

class CountePair{

     
  static int MAX = 100005;
 
  // Segment tree implemented as an array
  static int tree[] = new int[MAX << 2];

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        int n = 7;
        int[] a = {3,3,3,2,3,2,2};
        int x = 2;

        findCount(n, a, x);

    }

    static void findCount(int n, int[] a, int x){
        HashMap<Integer, ArrayList<Integer>> seq = new HashMap<>();

        for(int i =0; i< n; i++){
            if(seq.containsKey(a[i])){
                ArrayList<Integer> k = seq.get(a[i]);
                k.add(i+1);
                seq.put(a[i], k);
            }else{
                ArrayList<Integer> k = new ArrayList<Integer>();
                k.add(i+1);
                seq.put(a[i], k);
            }
        }
        long sum = 0;
        for ( ArrayList<Integer> list: seq.values())
        { System.out.println(list);
                // sum += findPairs(list,x);
                sum += count(list, list.size(), x);
        }
        System.out.println(sum);
    } 

    
    static int count(ArrayList<Integer> list, int n , int k){
        int sum = 0;

        for(int i =0; i<n ;i++){
            for (int j =i+1; j< n; j++){
                if( (list.get(i)*list.get(j))%k == 0)
                    sum += 1;

            }
        }

        return sum;
    }


}