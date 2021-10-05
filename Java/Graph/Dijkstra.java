package Graph;

public class Dijkstra {

    static final int v= 9;

    static int minDist(int[] dist, boolean[] shSet){
        int min_index = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<v; i++){
            if(shSet[i] == false && dist[i] <= min){
                min = dist[i];
                min_index = i;
            }

        }
        return min_index;
    }

    static void dijkstra(int[][] graph, int src){
        int dist[] = new int[v];
        boolean shSet[] = new boolean[v];

        // For displaying the paths
        int[] parent = new int[v];
        
        for(int i= 0; i< v;i++){
            dist[i] = Integer.MAX_VALUE;
            shSet[i] = false;
        }

        dist[0] = 0;
        parent[0] = -1;

        for(int count =0; count <v-1; count++){
            int u = minDist(dist, shSet);

            shSet[u] = true;

            for(int w = 0; w<v; w++){
                if(shSet[w] == false && graph[u][w] != 0 && dist[u]!= Integer.MAX_VALUE && dist[u] + graph[u][w] < dist[w]){
                    dist[w] = dist[u] + graph[u][w];
                    parent[w] = u;
                }
            }
           
        }
        printSolution(dist,parent);
    }

    static void printSolution(int dist[], int [] parent){
        int src= 0;
        System.out.println("Vertex \t Distance from Source\t path"); 
        for (int i = 0; i < v; i++) 
        {
            if(i != src){
                System.out.print("\n"+src+"->");
                System.out.print(i+"\t\t");
                System.out.print(dist[i]+"\t\t");
                printPath(i, parent);
            }
        }
            // System.out.println(i + " \t\t " + dist[i]); 
    }

    static void printPath(int i, int[] parent){
        if(i == -1){
            return;
        }
        printPath(parent[i], parent);
        System.out.print(i + " ");
    }
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
         dijkstra(graph, 0); 
    }
}