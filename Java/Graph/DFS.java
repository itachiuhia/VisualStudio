package Graph;

import java.util.Iterator;

public class DFS {

    static void dfs(int s, Graph g){
        boolean visited[] = new boolean[g.v];
        dfsUtil(s, visited, g);
    }

    private static void dfsUtil(int s, boolean[] visited, Graph g) {

        visited[s] = true;
        System.out.print(s+" ");

        Iterator<Integer> i = g.adj[s].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfsUtil(n, visited, g);
            }
        }
    }

    public static void main(String[] args) {
    Graph g = new Graph(4);
    // g.addedge(0,1);
    
    g.addedge(0, 1);
    g.addedge(0, 2);
    g.addedge(1, 2);
    g.addedge(2, 0);
    g.addedge(2, 3);
    g.addedge(3, 3);
    System.out.println("DFS from source 2");
    dfs(2, g);

   }
}