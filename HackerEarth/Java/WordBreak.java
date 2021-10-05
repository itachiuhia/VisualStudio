package Java;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    private static boolean dictContain(String[] temp_dictionary, String substring) {
        int size = temp_dictionary.length/temp_dictionary[0].length();

        for(int i =0; i< size ; i++){
            if(temp_dictionary[i].equals(substring)){
                return true;
            }
        }

        return false;
    }

    private static boolean WordBreakUtil(String string, String[] temp_dictionary) {
        

        int size = string.length();
        if(size == 0)
            return true;

        boolean[] wb = new boolean[size+1];
        for(int i=0; i< size; i++){
            wb[i]= false;
        }

        for(int i =1; i<= size; i++){
            if(wb[i] == false && dictContain(temp_dictionary, string.substring(0, i))){
                wb[i] = true;
            }

            if(wb[i] == true){
                if(i == size){
                    return true;
                }

                for(int j = i+1; j<= size; j++){
                    if(wb[j] == false && dictContain(temp_dictionary, string.substring(i, j-i)))
                        wb[j] = true;

                    if(j == size && wb[j] == true)
                        return true;    
                }
            }
        }

        return false;


            
    }


    // private static boolean WordBreakUtil(String word, Set<String> dict){
    //     int size = word.length();

    //     if(size == 0)   
    //         return true;
        
    //     for(int i=0 ; i<= size; i++){
    //         if(dict.contains(word.substring(0,i)) && WordBreakUtil(word.substring(i,size), dict)){
    //             return true;
    //         }
    //     }
    //     return false;

    // }
    
    public static void main(String[] args) {
        String temp_dictionary[] = {"mobile","samsung","sam","sung", 
                            "man","mango","icecream","and", 
                            "go","i","like","ice","cream"};

        Set<String> dict = new HashSet<>();
        
        for(String s: temp_dictionary){
            dict.add(s);
        }
                             
        // loop to add all strings in dictionary set 
        // for (String temp :temp_dictionary)
        // {
        //     dictionary.add(temp);
        // }
         
        // sample input cases
        String[] words = {"ilikesamsung","iiiiiiii","iiiiiiii","ilikelikeimangoiii","samsungandmango","samsungandmangok"} ;

        // System.out.println(wordBreak("ilikesamsung"));
        // System.out.println(wordBreak("iiiiiiii"));
        // System.out.println(wordBreak(""));
        // System.out.println(wordBreak());
        // System.out.println(wordBreak());
        // System.out.println(wordBreak());

        for(int i=0;i< words.length; i++){
            // System.out.println(WordBreakUtil(words[i], dict));
            System.out.println(WordBreakUtil(words[i], temp_dictionary));
        }
    }

    
    
}
