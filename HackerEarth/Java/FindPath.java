package Java;

import java.util.*;

class Graph{
    int v;
    LinkedHashMap<Integer, ArrayList<Integer>> g;

    Graph(int v){
        this.v = v;
        g = new LinkedHashMap<Integer, ArrayList<Integer>>();
    }

    void addEdge(int u, int v){
        if(g.containsKey(u)){
            ArrayList<Integer> a = g.get(u);
            a.add(v);
            g.put(u, a);
            addEdge_2(v, u);
        }else{
            ArrayList<Integer> a = new ArrayList<Integer>(v);
            g.put(u,a);
            addEdge_2(v, u);
        }
    }
    void addEdge_2(int u, int v){
        
        if(g.containsKey(u)){
            ArrayList<Integer> a = g.get(u);
            a.add(v);
            g.put(u, a);
            
        }else{
            ArrayList<Integer> a = new ArrayList<Integer>(v);
            g.put(u,a);
            
        }
    }

}
public class FindPath {

    private static int findPath(Graph g, int followeA, int followeB, int[] members, int edges) {

        List<Integer> vis = new ArrayList<Integer>();
        int out_ = findPathUtil(g, followeA, followeB, vis);
        return out_;
    }
    private static int findPathUtil(Graph map, int followeA, int followeB, List<Integer> vis) {

        vis.add(followeA);

        ArrayList<Integer> a = map.g.get(followeA);
        
        for(int ele : a){
            if(ele == followeB){
                return 1;
            }
            if(!vis.contains(followeA)){
                findPathUtil(map, ele, followeB, vis);                  
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] members = new int[n];
        for(int i=0; i< n; i++)
            members[i] =sc.nextInt();        
        int edges = sc.nextInt();
        Graph g = new Graph(edges);
        for(int i=0;i<edges; i++){
            g.addEdge(sc.nextInt(), sc.nextInt());
        }

        int followeA = sc.nextInt();
        int followeB = sc.nextInt();

        int res = findPath(g, followeA,followeB, members, edges);
        System.out.println(res);

        sc.close();        
    }    
}
