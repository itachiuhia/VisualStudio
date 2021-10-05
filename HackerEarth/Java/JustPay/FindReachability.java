package Java.JustPay;
import java.util.*;

@SuppressWarnings("unchecked")
class Graph_cyclic{
    int v;
    LinkedList<Integer> adj[];
    Graph_cyclic(int v){
        this.v= v;
        adj = new LinkedList[v];
        for(int i=0; i< v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }
}


public class FindReachability {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        // int[] mem = new int[n];
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

        boolean res = isReachable(g, src, dest);
        if(res == false)
            System.out.println("0");
        else
            System.out.println("1"); 

        
        sc.close();
    }

    private static boolean isReachable(Graph_cyclic g, int src, int dest) {
        // LinkedList<Integer> tmp;
        boolean vis[] = new boolean[g.v];
        LinkedList<Integer> q  = new LinkedList<Integer>();

        vis[src] = true;
        q.add(src);

        Iterator<Integer> i;
        while( q.size() != 0){
            src = q.poll();
            int n;
            i = g.adj[src].listIterator();
            while(i.hasNext()){
                n = i.next();
                if(n == dest)
                    return true;
                
                if(!vis[n]){
                    vis[n] = true;
                    q.add(n);
                }    
            }
        }

        return false;

    }
}
