package Loconov;

import java.util.*;

public class Tree_Sum {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    Tree_Sum(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int u,int v)
    {
        adj[u].add(v);
        adj[u].add(v);

    }


    public static void main(String[] args) {

        Tree_Sum g = new Tree_Sum(6);

        g.addEdge(1, 5);
        g.addEdge(1, 2);
         g.addEdge(3, 2);
        g.addEdge(2, 4);
        // g.addEdge(2, 3);
        // g.addEdge(3, 3);

        calc_sum(g, 5);
        
    }

    private static void calc_sum(Tree_Sum g, int v) {

        List<Integer> par = new ArrayList<Integer>();
        int len_par = 0;

        if (g.adj[1].size() > 1){
            len_par++;
            par.add(1);
        }
        
        for(int i=2; i<=v; i++){
            if (g.adj[i].size() >2)
            { len_par++;
              par.add(i);
            }
        }
        
        //Create the hash map of hash map for storing the distance
        HashMap<Integer, HashMap<Integer, Integer>> dist = new HashMap<>();

        for(int i=len_par-1; i>=0; i--){
            findDist(g, dist,i);
        }

    }

    private static void findDist(Tree_Sum g, HashMap<Integer, HashMap<Integer, Integer>> dist, int i) {
        
        LinkedList<Integer> c = g.adj[i];
        long finalSum = 0;

        long div = 998244353L;

        

        

        for(int x: c){
            for(int y: c){
                if (x == y){
                    continue;
                }
                LinkedList<Integer> z_list = g.adj[y];
                int x_dist = dist(g, i, x);
                
                int y_dist = dist(i,y);

                finalSum = ((x_dist*x_dist)*y_dist)/ div;

            }
        }
        System.out.println(finalSum);
    }

    private static int dist(Tree_Sum g, int i, int x) {




        return 0;
    }

    private static void findALlDesendents(Tree_Sum g, int node, int parent, List<Integer> l ){
        
        // = new ArrayList<Integer>();
        
        for(Integer i: g.adj[node]){
            if(i == parent){
                continue;
            }
            l.add(i);

            LinkedList<Integer> i_list = g.adj[i];

            for(Integer i: g.adj[node]){
                if(i == parent){
                    continue;
                }
            }    


            // 
            // for(Integer j : g.adj[i]){
            //     
            // }
            
        }
    }

    
}
