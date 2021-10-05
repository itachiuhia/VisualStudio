package Graph;

import java.util.ArrayList;
import java.util.Iterator;

//Has to be working  -> Next Goal Solve it via DP only

public class CountPath {
    static ArrayList<Integer> a = new ArrayList<>();

    static int countPathUtil(int s, int d, Graph g, int path){
        if(d == s){
            System.out.println(1+" ");
            return path++;
        }
        else{
            Iterator<Integer> i = g.adj[s].listIterator();
            a.add(s);
            while(i.hasNext()){
                int n = i.next();
                System.out.println(path);

                path = countPathUtil(n, d, g, path);
            }
        }
        return path;
    }

    static int countPath(int s, int d, Graph g){
        int pathCount = 0;
        pathCount = countPathUtil(s, d, g, pathCount);
        return pathCount;
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge_nc(0, 1);
        g.addedge_nc(0, 2);
        g.addedge_nc(0, 3);
        g.addedge_nc(1, 3);
        g.addedge_nc(2, 3);
        g.addedge_nc(1, 4);
        g.addedge_nc(2, 4);

        int s = 0,  d = 3;

        System.out.println(countPath(s,d, g));
        for (int i: a){
             System.out.print(i+ " ");
        }
    }
}