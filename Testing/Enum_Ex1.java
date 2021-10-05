import java.util.*;

class Enum_Ex1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lo = sc.nextInt();
        int hi = sc.nextInt();

        int[] res = solution(n,lo, hi);
    }

    private static int[] solution(int n, int lo, int hi) {
         int res[] = new int[n];

          ArrayList<Integer> ex = new ArrayList<>();

          ex.add(hi-1);
          ex.add(hi);
          ex.add(hi-1);

          if( ex.size() < n){
              for(int i = hi-2; i> lo-1 ; i--){
                  ex.add(i);
                  if(ex.size() == n){
                      break;
                  }
              }
          }

          System.out.println(ex);

        return res;
    }
}