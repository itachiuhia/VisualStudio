package Java.JustPay;

import java.util.*;

public class MinCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] members = new int[n];
        for(int i=0; i< n; i++)
            members[i] =sc.nextInt();        
        int edges = sc.nextInt();
        Graph g = new Graph(edges);
        for(int i=0;i<edges; i++){
            g.addEdge(sc.nextInt(), sc.nextInt(),1);
        }

        int followeA = sc.nextInt();
        int followeB = sc.nextInt();

        // int res = 
        findPath(g, followeA,followeB,members);
        // System.out.println(res);

        sc.close(); 
        
    }

    private static void findPath(Graph map, int s, int t,int[] members) {

       int u, v;

       LinkedHashMap<Integer, ArrayList<Node>> rG = new LinkedHashMap<Integer, ArrayList<Node>>();
       Set<Integer> keys = map.g.keySet();
       for(int k : keys){
           rG.put(k,map.g.get(k));
       }

    //    ArrayList<Integer> parent = new ArrayList<>();
       HashMap<Integer,Integer> parent = new HashMap<>();

       while(bfs(rG, s, t, parent)){
           int pathFlow = Integer.MAX_VALUE;

           for(v = t; v!=s ; v = parent.get(v)){
               u = parent.get(v);
               ArrayList<Node> nodes = rG.get(u);
               int w =0;
               for(Node n : nodes){
                   if(n.v == v){
                    w = n.w;
                    break;
                   }
               }
               pathFlow = Math.min(pathFlow,w);
           }

           for(v = t; v!=s ; v = parent.get(v)){
               u = parent.get(v);
               addIntoNode(rG,u, v, -pathFlow);
               addIntoNode(rG, v, u, pathFlow);
           }
       }
       List<Integer> vis = new ArrayList<>();
       dfs(rG, s, vis);

       for(int i : members){
           for(int j : members){
               if(vis.contains(i) && !vis.contains(j)){
                   System.out.println(i +" - " + j);
               }
           }
       }
    }

    private static void dfs(LinkedHashMap<Integer, ArrayList<Node>> rG, int s, List<Integer> vis) {
        vis.add(s);
        ArrayList<Node> n = rG.get(s);
        for(Node node: n){
            int v = node.v;
            if(!vis.contains(v)){
                dfs(rG,v, vis);
            }
        }
    }

    private static void addIntoNode(LinkedHashMap<Integer, ArrayList<Node>> rG, int u, int ver, int i) {
        ArrayList<Node> nodes = rG.get(u);

        for(Node n: nodes){
            if(n.v == ver){
                nodes.remove(n);
                Node newNode = new Node(n.v,n.w+i);
                nodes.add(newNode);
                break;
            }           
        }
        rG.put(u,nodes);
    }

    private static boolean bfs(LinkedHashMap<Integer, ArrayList<Node>> rG, int s, int t, HashMap<Integer, Integer> parent) {
        ArrayList<Integer> vis = new ArrayList<>();

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        vis.add(s);
        

        while(!q.isEmpty()){
            int v = q.poll();

            ArrayList<Node> gDist = rG.get(v);
            int val = 0;
            int ind =0;
            for(Node node: gDist){
                ind = node.v;
                val = node.w;

                if(!vis.contains(ind) && val > 0){
                    q.add(ind);
                    vis.add(ind);
                    parent.put(ind, v);
                }
            }
       }
       return (vis.contains(t))?true:false;
    }    
}
