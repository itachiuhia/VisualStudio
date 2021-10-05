package Graph;

public class GraphColoring {

    static int v = 4;

    static boolean isSafe(boolean[][] graph, int[] color){
        for(int i=0; i<v; i++){
            for(int j= i+1; j<v; j++){
                if(graph[i][j] && color[j] == color[i])
                    return false;
            }
        }
        return true;
    }
    static boolean colorGraph(boolean graph[][], int m, int i, int[] color){
        if( i == v){
            if(isSafe(graph, color)){
                printSolution(color);
                return true;
            }
            return false;
        }

        for(int j = 1; j<=m ;j++){
            color[i] = j;
            if(colorGraph(graph, m, i+1, color))    
                return true;
            color[i] = 0;    
        }
        return false;
    }
    
    private static void printSolution(int[] color) {
        System.out.println("Solution Exists:"  + 
                       " Following are the assigned colors ");
    for (int i = 0; i < v; i++)
      System.out.print("  " + color[i]);
    System.out.println();
    }

    public static void main(String[] args) {
        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false },
          };
          int m = 3; 

          int[] color = new int[v];
          for(int i =0; i<v ;i++){
              color[i] = 0;

          }

          if(!colorGraph(graph, m, 0, color)){
              System.out.println("Solution exist");
          }else{
              System.out.println("Not Exist");
          }
    }
}