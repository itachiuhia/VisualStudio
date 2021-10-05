import java.util.*;
import java.io.*;



class TestClass  
{ 
    static char maxOccur(String str) 
    { 
        int count[] = new int[256]; 
        int len = str.length(); 
        for (int i=0; i<len; i++) 
            count[str.charAt(i)]++; 
       
        int max = -1;  
        char result = ' ';  
       
        for (int i = 0; i < len; i++) { 
            if (max < count[str.charAt(i)]) { 
                max = count[str.charAt(i)]; 
                result = str.charAt(i); 
            } 
        }        
        return result; 
    } 
    public static void main(String[] args) throws Exception
    { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
      System.out.println(maxOccur(input)); 
    } 
} 