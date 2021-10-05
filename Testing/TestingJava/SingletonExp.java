package TestingJava;

import java.time.*;
import java.util.*;
import java.util.regex.Pattern;

class MySingleton{
    static MySingleton instance = null;
    public int x = 10;

    private MySingleton() {}

    static public MySingleton getInstance() {
        if (instance == null){
            instance = new MySingleton();
        }
        return instance;
    }
}

public class SingletonExp {
    public static void main(String[] args) {
        MySingleton a = MySingleton.getInstance();
        MySingleton b = MySingleton.getInstance();

        a.x = a.x +10;
        System.out.println("a.x ="+ a.x);
        System.out.println("b.x ="+ b.x);

        // isValidName("Something");
        
    }

    boolean isValidSkill(String skill){
        List<String> skills = new ArrayList<String>();
        String[] skill_set = {"Coding","Dancing", "Singing","Drawing","Speech","Acting"};
        for(String s : skill_set){
            skills.add(s);
        }

        if( skills.indexOf(skill) > 0){
            return true;
        }
        return false;
        // skill_set.stream().map(s->s).forEach(s -> skills.add(a) );
    }

     boolean isValidName(String name){
        String[] names = name.split(" ");
        String fname ="", lName ="";
        if(names.length!=2){
            return false;
        }else{
            fname = names[0];
            lName = names[1];
        }
        String r = "^([A-Z][a-z]{1,}\\s[A-Z][a-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)" ;
      
        boolean res = Pattern.matches(r, name);
        // System.out.println(res);

        return res;
    }

    boolean isValidDate(LocalDate dateOfBirth){
        LocalDate dateOftoday = LocalDate.now();

        if ((dateOfBirth != null) && (dateOftoday != null)) {
            int age =  Period.between(dateOfBirth, dateOftoday).getYears();
            if(age > 17){
                return true;
            }else{
                return false;
            }
        } 

        return false;     
        
    }

    // class RegistratingServiceImpl{
    //     public void registerForTalent(Participant participant){
    //         String name = participant.getName();
    //         String skill = participant.getSkill();
    //         Date age = participant.getDateOfBirth();

    //         if( isValidName(name) && isValidDate(age) && isValidSkill(skill)){
    //             Send it to registrationDaoImpl(name, skill, dateOfBirth, LocalDate.now());
    //         }

    //     }

    //     List<Participatn> getParticipantsBySkills(String skill){
    //         List<Participant> participants = registerDAO.getParticipants();

    //         List<Participant> skillsParticipants  = new ArrayList();

    //         for(Participant p: participants){
    //             if( p.getSkill().equals(skill)){
    //                 skillsParticipants.add(p);
    //             }
    //         }
    //         return skillsParticipants;

    //     }
    // }
}
