package Java;

import java.util.*;


class Frequency{
    public static void main(String[] args) {
        String a = "abcdabcdaa";

        System.out.println(freq(a));
    }

    private static String freq(String input1) {
        TreeMap<Character, Integer> d = new TreeMap<Character, Integer>();

        for(int i=0; i<input1.length(); i++){
            if(d.containsKey(input1.charAt(i))){
                d.put(input1.charAt(i), d.get(input1.charAt(i))+1);
            }else{
                d.put(input1.charAt(i), 1);
            }
        }
        
        String res = "" ;
        for(Map.Entry<Character, Integer> entry : d.entrySet()){
            res += entry.getKey()+""+String.valueOf(entry.getValue());
        }
        
        return res;

    }
}