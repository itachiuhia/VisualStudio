package Java.JustPay;

import java.util.*;

public class NaggingNewbie {

   public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    
    List<Integer> mem = new ArrayList<Integer>();
    for(int i=0; i< n; i++){
        mem.add(sc.nextInt());
    }
    int max = Collections.max(mem);
    // System.out.println(max+"\n");

    int edge = sc.nextInt();
    Graph_cyclic g = new Graph_cyclic(max+1);
    
    for(int i=0; i< edge; i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        g.addEdge(u, v);
    }
    int src = sc.nextInt();
    int dest = sc.nextInt();

    printVertexCover(g, src,dest);

    
    sc.close();
   }

private static void printVertexCover(Graph_cyclic g, int src, int dest) {

    boolean[] vis = new boolean[g.v];
    LinkedList<Integer> q = new LinkedList<Integer>();
    // List<Integer> res = new ArrayList<Integer>();

    // vis[src] = true;
    q.add(src);

    Iterator<Integer> i;

    while(q.size() != 0 ){
        src = q.poll();
        System.out.println("src - "+ src);
        // res.add(src);

        if(vis[src] == false){
            i = g.adj[src].iterator();

            while(i.hasNext()){
                int v = i.next();
                System.out.println("Next  - "+ v);

                if(vis[v] == false){
                    vis[v] = true;
                    vis[src] = true;
                    q.add(v);
                }
            }

        }
        
    }

    for( int j=0; j<g.v; j++){
        if(vis[j]){
            System.out.print(j+" ");
        }
    }

}
    
}
