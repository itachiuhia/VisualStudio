package Java;

import java.util.LinkedList;
import java.util.Queue;

public class MinStepsOfKnight {

    static class cell{
        int x, y;
        int dis;
        cell(int x, int y, int dis){
            this.x = x;
            this.y = y ;
            this.dis = dis;
        }
    }

    static int minStep(int[] knight, int[] target, int n){
        int dx[] ={-2, -1, 1, 2, -2, -1, 1, 2 }; 
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 }; 

        Queue<cell> q = new LinkedList<>();
        q.add(new cell(knight[0], knight[1], 0));
        cell t;
        int x, y;
        boolean vis[][] = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= n; j++) 
                vis[i][j] = false; 

        vis[knight[0]][knight[1]] = true;

        while(!q.isEmpty()){
            t = q.poll();

            if(t.x == target[0] && t.y == target[1]){
                return t.dis;
            }

            for(int i =0; i< 8; i++){
                x =t.x + dx[i];
                y = t.y + dy[i];

                if(isSafe(x, y, n) && vis[x][y] == false){
                    vis[x][y] = true;
                    q.add(new cell(x, y, t.dis+1));
                }
            }

        }

        return 0;
    }

    private static boolean isSafe(int x, int y, int n) {

        if(x >1 && x<=n && y>1 && y<= n)
            return true;

        return false;
    }

    public static void main(String[] args) {

        int n = 30;
        int knight[] ={1,1};
        int target[] = {30,30};
        System.out.println(minStep(knight,target, n));

        
    }
}
