package Graph;

import java.util.Iterator;
import java.util.LinkedList;



class Graph{
    int v ;
    LinkedList<Integer> adj[];
    
    @SuppressWarnings("unchecked")
    Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i =0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addedge_nc(int v, int u){
        adj[v].add(u);
    }

    void addedge(int v, int u){
        adj[v].add(u);
        adj[u].add(v);
    }
}

public class BFS {

    static void printBFS(int s, Graph g){
        boolean visited[] = new boolean[g.v];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[s] = true;
        queue.add(s);

        while(queue.size()!= 0){
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = g.adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addedge_nc(0, 1);
        g.addedge_nc(0, 2);
        g.addedge_nc(1, 2);
        g.addedge_nc(2, 0);
        g.addedge_nc(2, 3);
        g.addedge_nc(3, 3);

        System.out.println("Following is the BFS");

        printBFS(2,g);
        System.out.println();
        
    }
}