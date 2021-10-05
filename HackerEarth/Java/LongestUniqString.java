package Java;

import java.util.Arrays;

public class LongestUniqString {
    public static void main(String[] args) {
        String str = "KaramChanduGandhi";
        int len = str.length();

        // System.out.println("--"+lengthOfUniqSubstring(str, len));
        System.out.println("--"+longestUniqueSubsttr(str, len));
    }

    private static int longestUniqueSubsttr(String str, int len){
        int res = 0;

        int[] lastInd = new int[256];
        Arrays.fill(lastInd, -1);
        int i =0;
        for(int j =0; j<len; j++){
            i = Math.max(i,lastInd[str.charAt(j)] +1);
            res = Math.max(res,j-i+1);

            lastInd[str.charAt(j)] = j;
        }


        return res;
    }

    private static int lengthOfUniqSubstring(String str, int len) {

        int res = 0;
     
        for(int i = 0; i < len; i++)
        {
            boolean[] visited = new boolean[256];
             
            for(int j = i; j < len; j++)
            {
                 
                if (visited[str.charAt(j)] == true)
                    break;
     
                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
     
            visited[str.charAt(i)] = false;
        }
        return res;

        // int res = 0;
        // for(int i =0; i<len;i++){
        //     boolean[] visited = new boolean[256];

        //     for(int j =i; i<len; i++){
        //         if(visited[str.charAt(j)] == true)
        //             break;
        //         else{
        //             res = Math.max(res, j-i+1);
        //             visited[str.charAt(j)] = true;

        //         }    
        //     }
        //     visited[str.charAt(i)] = false;
        // }
        // return res;
    }
    
}
