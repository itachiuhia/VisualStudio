import java.lang.reflect.*;

public class ClassUsingNewInstance {

    private String name;
    ClassUsingNewInstance(){

    }
    public void setName(String  name){
        this.name = name;
    }

    public static void main(String[] args) {
        try{
            Constructor<ClassUsingNewInstance> constructor = ClassUsingNewInstance.class.getDeclaredConstructor();
            ClassUsingNewInstance r = constructor.newInstance();
            r.setName("Tango Shri");
            System.out.println(r.name);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
