package Java;


// Given a text txt[0..n-1] and a pattern pat[0..m-1], 
// write a function search(char pat[], char txt[]) 
// that prints all occurrences of pat[] in txt[]. 
// You may assume that n > m.

public class KMP {

    static void KMPSearching(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        int lps[] = new int[M];
        int j =0;
        
        computerLPSArray(pat,M, lps);
        int i =0;
        while(i<N){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if(j==M){
                System.out.println("Pattern Found at "+ (i -j));

                j = lps[j-1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)){
                if(j != 0)
                    j = lps[j-1];
                else 
                    i = i+1;    
            }
        }
        

    }
        
    private static void computerLPSArray(String pat, int m, int[] lps) {
        int l =0;
        int i =1;
        lps[0] = 0;

        while(i< m){
            if(pat.charAt(i) == pat.charAt(l)){
                l++;
                lps[i] = l;
                i++;
            }
            else{
                if(l!= 0){
                    l = lps[l-1];
                }else{
                    lps[i] =l;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
            String txt = "ABABDABACDABABCABAB"; 
            String pat = "ABABCABAB"; 

            KMPSearching(pat, txt);
        }
}
