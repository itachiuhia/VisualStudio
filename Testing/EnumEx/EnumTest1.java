package EnumEx;

enum Color{
    RED, GREEN, BLUE;

    private Color(){
        System.out.println("Constructer is called for: "+ this.toString());
        this.toString();
    }

    public void colorInfo(){
        System.out.println("Universe Color");
    }
}

public class EnumTest1 {

    public static void main(String[] args) {
        Color c1 = Color.RED;
    System.out.println(c1);
    c1.colorInfo();
    }
    
}
