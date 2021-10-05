package Graph;

public class Prim {
    static final int v = 5;

    static int minKey(int[] key, boolean[] mstSet){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i= 0; i<v; i++){
            if(mstSet[i] == false && key[i]< min){
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }

    static void primMST(int[][] graph){
        int[] parent = new int[v];
        int key[] = new int[v];
        boolean mstSet[] = new boolean[v];

        for(int i=0; i< v; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;

        parent[0] = -1;

        for(int count =0; count < v-1; count++){
            int u = minKey(key,mstSet);
            mstSet[u] = true;

            for(int i = 0; i<v ;i++){
                if(graph[u][i] != 0 && mstSet[i] == false && graph[u][i] < key[i]){
                    parent[i] = u;
                    key[i] = graph[u][i];
                }
            }
        }

        printMST(parent, graph);
    }


    public static void main(String[] args) {
        // MST t = new MST(); 
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } }; 
  
        // Print the solution 
        primMST(graph); 
        
    }

    static void printMST(int parent[], int[][] graph){
        System.out.println("Edge\t Weight");
        for(int i= 1; i< v; i++){
            System.out.println(parent[i]+" - "+ i + "\t"+ graph[i][parent[i]]);
        }
    }
}