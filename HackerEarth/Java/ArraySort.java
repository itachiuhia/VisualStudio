package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ArraySort {

    private static List<Integer> solve(int n, int m, List<Integer> a, int[] b) {
        
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        // LinkedHashMap<Integer, Integer> noOfElement = new LinkedHashMap<>();
        for(int i: a){
            int j ;
            for(j=0; j<m;j++){
                // int k =0;
                 if(i%b[j] != 0){                    
                    break;
                }
                
            }
            hm.put(i,(j));
        }

        int[] arr= sortBy(hm,n);
        // int finArr[] = new int[n];
        List<Integer> finArr = new ArrayList<>();

        for(int i=0;i< n; i++){
            int item = arr[i];
            if(item == 0)
                break;
            int freq = Collections.frequency(a, item);
            if(freq>1){
                while(freq !=0){
                    finArr.add(item);
                    freq--;
                }
            }else{
                finArr.add(item);
            }
        }
        return finArr;
    }

    

    private static int[] sortBy(LinkedHashMap<Integer, Integer> hm, int n) {
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){

            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
            
        });

        int[] arr = new int[n];
        int i=0;
        for(Map.Entry<Integer,Integer> a: list){
            arr[i++] = a.getKey();
        }


        return arr;
    }



    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);
        String[] arrA = br.readLine().split(" ");
        // int[] A = new int[n];
        List<Integer> A = new ArrayList<>();
        for(int i=0; i< n; i++){
            // A[i] = Integer.parseInt(arrA[i]);
            A.add(Integer.parseInt(arrA[i]));

        } 
        String[] arrB = br.readLine().split(" ");
        int[] B = new int[m];
        for(int i=0; i< m; i++){
            B[i] = Integer.parseInt(arrB[i]);
            
        } 
        List<Integer> out_ = solve(n,m,A,B);

        for(int out: out_){
            System.out.print(out+" ");
        }
        System.out.println();
        wr.close();
        br.close();
    }
}
