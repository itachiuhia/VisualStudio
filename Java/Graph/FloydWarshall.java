package Graph;

public class FloydWarshall {
    static int  INF = Integer.MAX_VALUE;
    static final int v = 4;
    
    static boolean negCyclefloydWarshall(int graph[][]){

        int dist[][] = new int[v][v];
        for(int i=0; i< v; i++)
            for(int j= 0; j<v;j++){
                dist[i][j] = graph[i][j];
            }
        
        for(int k=0; k<v; k++){
            for(int i=0; i<v; i++){
                for(int j =0; j< v; j++){
                    if(dist[i][k]+ dist[k][j] < graph[i][j]){
                        dist[i][j] = dist[i][k]+ dist[k][j];
                    }
                }
            }
        }    

        for(int i =0; i< v; i++){
            if(dist[i][i] < 0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int graph[][] = { {0, 1, INF, INF}, 
                          {INF, 0, -1, INF}, 
                          {INF, INF, 0, -1}, 
                          {-1, INF, INF, 0}}; 
          
        if (negCyclefloydWarshall(graph)) 
            System.out.println("Yes"); 
        else
            System.out.println("No");  
    }
}