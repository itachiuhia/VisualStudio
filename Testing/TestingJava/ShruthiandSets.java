// package TestingJava;

import java.util.*;

public class ShruthiandSets {

    public static void main(String[] args) {
        int n = 4;
        Set<Integer> hs = new TreeSet<Integer>();
        // hs.addAll(2, 6, 10);
        hs.add(2);
        hs.add(6);
        hs.add(10);
        int k = 2;

        findMax(n, hs, k);
        

    }

    private static void findMax(int n, Set<Integer> hs, int k) {        

        while(true){
            int len = hs.size();
            for(int i =0; i< len-1; i++){
                ArrayList<Integer> toAdd = diffElement(len, hs,i+1);
                hs.addAll(toAdd);      
            }

            if( len == hs.size()){
                break;
            }else{
                continue;
            }
        }

        List<Integer> list= new ArrayList<Integer>(hs);
        System.out.println(list);
        System.out.println(list.get(list.size()-2));        
    }

    private static ArrayList<Integer> diffElement(int len, Set<Integer> hs, int skip) {
        ArrayList<Integer> toAdd = new ArrayList<Integer>();
        List<Integer> list= new ArrayList<Integer>(hs);
        for(int i=0; i< len-skip ; i++){
            toAdd.add(Math.abs(list.get(i)-list.get(i+skip)));

        }
        return toAdd;
    }
}
