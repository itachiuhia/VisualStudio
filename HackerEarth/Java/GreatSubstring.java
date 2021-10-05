package Java;

import java.util.Scanner;

class GreatSubstring{

    static void findGreatSubstring(int n, String str){
        char[] cArr = str.toCharArray();
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        int len[] = new int[t];
        String[] str = new String[t];
        for(int i=0;i< t; i++){
            len[i] = sc.nextInt();
            str[i] = sc.nextLine();
        }
        for(int i=0; i< t; i++){
            findGreatSubstring(len[i], str[i]);
        }
    }
}