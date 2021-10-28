package Hackerearth_Multiple;

public class hackereath {
    static int hack_opr(int h1, int h2){
        return h1/h2;
    }

    static int hack_opr2(int h1, int h2){
        int hack =0;

        try{
            hack = hack_opr(h1, h2);
        }catch(ArithmeticException hackerearth){
            System.out.println("hello");
        }
        return hack;
    }

    public static void main(String a[]){
        int h1 = 40;
        int h2 =0;

        try{
            int hack = hack_opr2(h1,h2);

        }
        catch(ArithmeticException ex){
            System.out.println("hi");
        }
    }
    
}
