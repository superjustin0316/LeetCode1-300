package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class lc286 {

    public void lc286_1(int[][] rooms){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0){
                    dfs(rooms,i,j,0);
                }
            }
        }
    }
    //利用栈空间
    private void dfs(int[][] rooms, int i,int j, int dis){
        if (i<0||i>=rooms.length||j<0||j>=rooms[0].length||rooms[i][j] <dis) return;
        rooms[i][j] = dis;
        dfs(rooms,i-1,j,dis+1);
        dfs(rooms,i-1,j,dis+1);
        dfs(rooms,i-1,j,dis+1);
        dfs(rooms,i-1,j,dis+1);
    }

    public void lc286_2(int[][] rooms){
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j]  == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        //利用队列空间
        while (!queue.isEmpty()){
            int[] top = queue.remove();
            int row = top[0],col =top[1];
            if (row >0 && rooms[row -1][col] == Integer.MAX_VALUE){
                rooms[row-1][col] = rooms[row][col]+1;
                queue.add(new int[]{row-1,col});
            }
            if (row < rooms.length - 1 && rooms[row +1][col] == Integer.MAX_VALUE){
                rooms[row+1][col] = rooms[row][col]+1;
                queue.add(new int[]{row+1,col});
            }
            if (col >0 && rooms[row][col-1] == Integer.MAX_VALUE){
                rooms[row][col-1] = rooms[row][col]+1;
                queue.add(new int[]{row,col-1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = rooms[row][col]+1;
                queue.add(new int[]{row,col+1});
            }
        }
    }



}
