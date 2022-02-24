package Clootrack;

import java.util.*;
  

class Node{
    int v;
    int w;
    Node(int v, int w){
        this.v  = v;
        this.w = w;
    }
}

class Graph{
    int v;
    LinkedHashMap<Integer, ArrayList<Node>> g;

    Graph(int v){
        this.v = v;
        g = new LinkedHashMap<Integer, ArrayList<Node>>();
    }

    void addEdge(int u, int v, int w){
        if(g.containsKey(u)){
            ArrayList<Node> a = g.get(u);
            a.add(new Node(v,w));
            g.put(u, a);
            // addEdge_2(v, u,w);
        }else{
            ArrayList<Node> a = new ArrayList<Node>();
            a.add(new Node(v,w));
            g.put(u,a);
            // addEdge_2(v, u,w);
        }
    }
    // void addEdge_2(int u, int v, int w){
        
    //     if(g.containsKey(u)){
    //         ArrayList<Node> a = g.get(u);
    //         a.add(new Node(v,w));
    //         g.put(u, a);
            
    //     }else{
    //         ArrayList<Node> a = new ArrayList<Node>();
    //         a.add(new Node(v,w));
    //         g.put(u,a);
            
    //     }
    // }

}


public class ShortedDistance  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] members = new int[n];
        // for(int i=0; i< n; i++)
        //     members[i] =sc.nextInt();        
        // int edges = sc.nextInt();
        // Graph g = new Graph(edges);
        // for(int i=0;i<edges; i++){
        //     g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        // }

        // int src = sc.nextInt();
        // int dest = sc.nextInt();

        int V = 4;
        Graph g = new Graph(V);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 5);
        g.addEdge(1, 4, 5);
        // g.addEdge(1, 3, 1);
        g.addEdge(3, 1, 5);
        g.addEdge(2, 1, 5);
        g.addEdge(4, 1, 5);
        // g.addEdge(1, 3, 5);

        g.addEdge(2, 4, 1);
        g.addEdge(4, 2, 1);


        dijekstra(g, 3, 4);

        

        sc.close(); 
        
    }

    private static void dijekstra(Graph map, int src, int dest) {

        HashMap<Integer, Integer> dist = new HashMap<>();
        ArrayList<Integer> vis = new ArrayList<>();

        for(int i=1; i< map.v+1; i++){
            dist.put(i, Integer.MAX_VALUE);
        }

        dist.put(src,0);  

        for(int count =0; count< map.v-1; count++){

            int u = minDist(dist, vis);
            // System.out.println(u);
            vis.add(u);

            // for(int mem: members){
                ArrayList<Node> gDist = map.g.get(u);
                int val = 0;
                int v =0;
                for(Node n: gDist){
                    // if(n.v == mem){
                    //     val = n.w;
                    // }
                    // System.out.println(n.v+" - "+ n.w);
                    v = n.v;
                    val = n.w;
                    // System.out.println(dist.get(u));
                    // System.out.println(dist.get(v));
                    
                    if(vis.contains(v) == false && 
                        dist.get(u) != Integer.MAX_VALUE && 
                        dist.get(u) + val < dist.get(v)){

                        dist.put(v, dist.get(u) + val);
                    }

                }
                // if(vis.contains(mem) == false && dist.get(u) != Integer.MAX_VALUE && dist.get(u) + val < dist.get(mem)){
                //     dist.put(mem, dist.get(u) + val);
                // }
            // }
        }

        printSol(dist, src, dest);

    }

    private static void printSol(HashMap<Integer, Integer> dist, int src, int dest) {
        System.out.println(dist.get(dest));
    }

    private static int minDist(HashMap<Integer, Integer> dist, ArrayList<Integer> vis) {

        Set<Integer> keys = dist.keySet();
        int max = Integer.MAX_VALUE, index = -1;

        for(int k : keys){
            if(dist.get(k) <= max && vis.contains(k) == false){
                index = k;
                max = dist.get(k);
            }
        }
        return index;
    }
}