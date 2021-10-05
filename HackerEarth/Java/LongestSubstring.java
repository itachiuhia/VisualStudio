package Java;

import java.io.*;
import java.util.*;

public class LongestSubstring {

    private static int solve(int k, String s) {
        int ans = 0;
        // int[] cnts  = new int[2];
        // List<int[]> ls = new ArrayList<>();
        // int[] cur = null;
        // for(int i =0; i< s.length(); i++){
        //     int id = Character.getNumericValue(s.charAt(i));
        //     cnts[id]++;
        //     if(i ==0 || s.charAt(i) != s.charAt(i-1)){
        //         cur = new int[] {id, 1};
        //         ls.add(cur);
        //     }else{
        //         cur[1]++;
        //     }

            
        // }
        // int ans = 0;
        // for(int i =0; i< ls.size(); i++){
        //     if(i>0 && i+1< ls.size() && ls.get(i)[1] == 1 && ls.get(i+1)[0] == ls.get(i-1)[0]){
        //         ans = Math.max(ans, Math.min(ls.get(i-1)[1]+ls.get(i+1)[1]+1,cnts[ls.get(i-1)[0]]));
        //     }else{
        //         ans = Math.max(ans, Math.min(ls.get(i)[1]+1 , cnts[ls.get(i)[0]]));
        //     }
        // }

        List<Integer> l = new ArrayList<Integer>();
        int i_0 = 0;
        int i_1 = 0;
        char c = s.charAt(0);
        int x = 1;
        for(int i =1; i<s.length(); i++){
            if(c == s.charAt(i)){
                x++;
            }else{
                l.add(x);
                x = 1;
                c = s.charAt(i);
            }
        }
        l.add(x);
        // for(int y : l){
        //     System.out.print(y+" ");
        // }

        int odd = 0;
        int even = 0;
        int swap = k;
        int max_o= 0;
        int windows[] = new int[l.size()];

        for(int i=1; i<l.size()+1; i++){
            if(i%2 == 1){
                odd += l.get(i-1);
                even += 0;
                max_o = odd;
                windows[i-1] = l.get(i-1);
            }else{
                int ele = l.get(i-1) - swap;
                if(ele < 0){
                    even += swap;
                }
                odd += even;
                
            }
        }
        

        return ans;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int x =solve(k, s);
        System.out.println();
    }    
}
