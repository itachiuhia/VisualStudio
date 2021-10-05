package Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

class TopologicalGraph{
    int var ;
    public LinkedList<Integer>[] adj;
    TopologicalGraph(int ver){
        this.var = var;
        adj = new LinkedList[ver];
        for(int i =0;i< ver; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void topologicalSort(){
        // System.out.print("Something in stack");
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[var];
        // System.out.print("Something in stack");
        Arrays.fill(vis, false);
        // System.out.print("Something in stack");

        for (int i = 0; i < var; i++)
        {
            vis[i] = false;
        }
        // System.out.print("Something in stack");
        for(boolean b: vis){
            System.out.print(b+" hellp");
        }
        System.out.print("Something in stack");
        for(int i =0; i< var; i++){
            if(!vis[i]){
                System.out.print("Something in stack");
                topologicalSortUtil(i, vis, st);
            }
        }
        while(!st.isEmpty()){
            System.out.print("Something in stack");
            System.out.print((char)('a'+st.pop()) +" ");
        }
        System.out.println();
    }

    private void topologicalSortUtil(int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;
        for(int i: adj[curr]){
            // print
            if(!vis[i]){
                topologicalSortUtil(i, vis, st);
            }
        }
        System.out.print("Something in stack");
        st.push(curr);
    }
}


public class AlienLanguage {

    static void printOrder(String[] words, int size){
        TopologicalGraph tg = new TopologicalGraph(size);

        for(int i=0; i<size-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            for(int j =0; j< Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    tg.addEdge(word1.charAt(j) -'a' , word2.charAt(j) -'a');
                    break;

                }
            }
        }
        tg.topologicalSort();
        
    }
    public static void main(String[] args) {
        String[] words ={"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 5);
        
    }
}
