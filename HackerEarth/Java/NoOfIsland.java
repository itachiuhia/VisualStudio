package Java;

public class NoOfIsland {
    static final int ROW = 5, COL = 5; 

    private static boolean isSafe(int[][] m, int r, int c, boolean[][] vis) {

        return ((r >= 0 && r < ROW) && (c >=0 && c < COL) && m[r][c]== 1 && !vis[r][c]);
    }

    static void DFS(int[][] m, int r, int c, boolean[][] vis){
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 

        vis[r][c] = true; 
        for(int i=0; i<8; i++){
            if (isSafe(m, r+rowNbr[i], c+colNbr[i], vis))
                DFS(m, r+rowNbr[i], c+colNbr[i], vis);
        }
    }

    

    static int countIslands(int[][] m) {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;

        for(int i =0; i< ROW; i++){
            for(int j = 0; j<COL; j++){
                if(m[i][j] == 1 && visited[i][j]== false){
                    DFS(m, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
                                  { 0, 1, 0, 0, 1 }, 
                                  { 1, 0, 0, 1, 1 }, 
                                  { 0, 0, 0, 0, 0 }, 
                                  { 1, 0, 1, 0, 1 } }; 
      //  Islands I = new Islands(); 
        System.out.println("Number of islands is: " + countIslands(M)); 
        
    }
}
