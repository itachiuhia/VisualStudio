package Java;

import java.io.*;

public class LongestCommonSubarray {

    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
 
        int m = X.length();
        int n = Y.length();
 
        printLCSubStr(X, Y, m, n);
    }

    private static void printLCSubStr(String x, String y, int m, int n) {

        int[][] LCSuff = new int[m+1][n+1];
        int len =0;
        int row = 0, col =0;

        for(int i=0; i<= m ; i++){
            for(int j =0; j<=n; j++){
                if(i ==0 || j == 0){
                    LCSuff[i][j] = 0;
                }else {
                    if (x.charAt(i-1) == y.charAt(j-1)){
                        LCSuff[i][j] = LCSuff[i-1][j-1]+1;
                        if( len < LCSuff[i][j]){
                            len = LCSuff[i][j];
                            row = i;
                            col =j;
                        }
                    }else{
                        LCSuff[i][j] = 0;
                    }
                }
            }
        }
        if (len == 0){
            System.out.println("No Common Substring");
            return ;
        }

        String res = "";

        while(LCSuff[row][col] != 0){
            res = x.charAt(row-1)+ res;
            --len;
            row--;
            col--;
        }
        System.out.println(res);
        
    }
}















// public class LongestCommonSubarray {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter wr = new PrintWriter(System.out);
//         int m = Integer.parseInt(br.readLine().trim());
//         int n = Integer.parseInt(br.readLine().trim());
//         String[] arr = new String[m];

//         for(int i=0;i<m; i++){
//             String[] strArr = br.readLine().split(" ");

//             StringBuffer sb = new StringBuffer();
//             for(int j = 0; j<n ; j++){
//                 sb.append(strArr[j]);
//             }
//             // System.out.println(strArr);
//             // String str = strArr.toString();

//             String str = sb.toString();
//             // System.out.println(str);
//             arr[i] = str;
//         }
        
//         int out_ = solve(m, n, arr);
//         System.out.println(out_);

//         wr.close();
//         br.close();
//     }

//     private static int solve(int m, int n,String[] arr) {

// 		// Take first word from array as reference
// 		String s = arr[0];
// 		int len = n;

// 		String res = "";

// 		for (int i = 0; i < len; i++) {
// 			for (int j = i + 1; j <= len; j++) {

// 				// generating all possible substrings
// 				// of our reference string arr[0] i.e s
// 				String stem = s.substring(i, j);
// 				int k = 1;
// 				for (k = 1; k < m; k++)

// 					// Check if the generated stem is
// 					// common to all words
// 					if (!arr[k].contains(stem))
// 						break;

// 				// If current substring is present in
// 				// all strings and its length is greater
// 				// than current result
// 				if (k == m && res.length() < stem.length())
// 					res = stem;
// 			}
// 		}

// 		return res.length();
       
//         // String s = arr[0];
//         // int len = n;
 
//         // String res = "";
 
//         // for (int i = 0; i < len; i++) {
//         //     for (int j = i + 1; j <= len; j++) {
 
//         //         // generating all possible substrings
//         //         // of our reference string arr[0] i.e s
//         //         String stem = s.substring(i, j);
//         //         int k = 1;
//         //         for (k = 1; k < n; k++)
 
//         //             // Check if the generated stem is
//         //             // common to all words
//         //             if (!arr[k].contains(stem))
//         //                 break;
 
//         //         // If current substring is present in
//         //         // all strings and its length is greater
//         //         // than current result
//         //         if (k == n && res.length() < stem.length())
//         //             res = stem;
//         //     }
//         // }
 
//         // return res.length();
        
//     }
// }
