






















// import java.util.*;
// import java.lang.*;

// class B1{
//     private int a = 10;
//     protected int b= 30;
//     public B1(int a,int b){
//         this.a = a;
//         this.b = b;
//     }
//     protected void sum(int a, int b){
//         new B1(a,b).get();
//     }

//     private void get(){
//         System.out.println(a+b);
//     }


// }
// class B2 extends B1{
//     private B2(int a, int b){
//         super(a, b);
//     }
//     protected int c = 10;
//     protected void add(){
//         sum(10, 20);
//     }
// }


// class hack1{
//     private int hack_method1(int hack){
//         return hack++;
//     }
//     public int hack_method2(int hack){
//         System.out.println(hack);
//         return hack_method1(hack++);
//     }
// }
// class hack extends hack1{
//     int hack_method1(int hack){
//         return hack_method2(++hack);
//     }
// }


public class Test{
    public static void main(String[] args) {
        // Test t = new Test();
    //    new Test().start("Hockey");
    //    new Test().start("Hockey", 1,2,3);

    try
  {
   System.out.println("Executing try block"); 
   return ;
  }
  finally
  {
   System.out.println("Executing finally block"); 
  }
  System.out.println("Hey");

    }

    private void start(String a, int... i) {
        System.out.println(i[0]);
    }

    

       
    
}




// // public class Test {
// //     public static void main(String[] args) {

// //         Scanner sc = new Scanner(System.in);
// //         int n = sc.nextInt();
// //         int lo = sc.nextInt();
// //         int hi = sc.nextInt();

// //         int[] res = solution(n,lo, hi);
// //         System.out.println(res);
// //         sc.close();
        
// //     }

// //     private static int[] solution(int n, int lo, int hi) {
// //         int res[] = new int[n];

// //         Deque<Integer> ex = new LinkedList<>();

// //          ex.add(hi-1);
// //          ex.add(hi);
// //          ex.add(hi-1);

// //          if( ex.size() < n){
// //              for(int i = hi-2; i> lo-1 ; i--){
// //                  ex.add(i);
// //                  if(ex.size() == n){
// //                      break;
// //                  }
// //              }
// //          }
// //          if(ex.size() < n){
// //             for(int i = hi-2; i> lo-1 ; i--){
// //                 ex.addFirst(i);
// //                 if(ex.size() == n){
// //                     break;
// //                 }
// //             }
// //          }
// //          if(ex.size() == n){
// //             // System.out.println(ex);
// //          }else{
// //             System.out.println(-1);
// //          }
         
// //          res = ex.stream().mapToInt(i->i).toArray();

// //        return res;
// //    }
// // }
