package EnumEx;

enum Signal{
    RED("Stop"), GREEN("GO"), ORAGE("SLOW_DOWN"); 

    private String action;

    public String getAction() {
        return this.action;
    }

    private Signal(String action){
        this.action = action;
    }
}

public class EnumTest2 {
    public static void main(String[] args) {
        Signal[] sig = Signal.values();

        for( Signal s: sig){
            System.out.println("name: " + s.name() + " Action :" + s.getAction());
        }
    }
}
