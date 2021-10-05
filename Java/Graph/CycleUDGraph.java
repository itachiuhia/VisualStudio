package Graph;

import java.util.Iterator;

public class CycleUDGraph {

    static boolean isCyclicUtil(int v, boolean visited[], int parent, Graph g){
        visited[v] = true;
        int i;

        Iterator<Integer> it = g.adj[v].iterator();
        // Iterator<Integer>
        while(it.hasNext()){
            i = it.next();
            if(!visited[i]){
                if((isCyclicUtil(i, visited,v, g)));
            }

            else if(i != parent){
                return true;
            }
        }

        return false;
    }

    static boolean isCyclic(Graph g){
        boolean visited[] = new boolean[g.v];
        for(int i=0; i< g.v;i++){
            if(!visited[i]){
                if(isCyclicUtil(i,visited, -1, g));
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(1, 0);
        g.addedge(0, 2);
        g.addedge(2, 1);
        g.addedge(0, 3);
        g.addedge(3, 4);

        if(isCyclic(g)){
            System.out.println("Cyclic");
        }else{
            System.out.println("no Cyclic");
        }
    }
}