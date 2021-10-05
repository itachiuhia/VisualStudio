package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class CoinsCollector_Elear{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr = br.readLine().split(" ");
        // int[] a = new int[n];
        List<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<n ;i++){
           a.add(Integer.parseInt(arr[i]));
        }
        long out_ = maximumCoins(a, n);
        System.out.println(out_);

        br.close();
        wr.close();

    }

    private static long maximumCoins(List<Integer> a, int n) {
        int min = Collections.min(a);
        int index = a.indexOf(min);

        long total = min*n + index;


        return total;
    }
}