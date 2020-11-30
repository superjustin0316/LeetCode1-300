package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class lc200 {
    private int m;
    private int n;

    public int lc200_1(char[][] grid){
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int i ,int j){
        //越界或者为0
        if (i<0 ||j<0|| i>= m|| j>= n || grid[i][j] == '0') return;
        grid[i][j] ='0';
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        }

    public int lc200_2(char[][] grid){
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] =='1'){
                    bfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y){
        grid[x][y] ='0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = x * m +y;
        queue.offer(code);
        while (!queue.isEmpty()){
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i-1][j] == '1'){
                queue.offer((i-1)*m+j);
                grid[i-1][j] = '0';
            }
            if (i < n-1 && grid[i+1][j] =='1'){
                queue.offer((i+1)*m+j);
                grid[i+1][j] = '0';
            }
            if (j>0 && grid[i][j-1] =='1'){
                queue.offer(i*m+j-1);
                grid[i][j-1] = '0';
            }
            if (i < m-1 && grid[i][j+1] =='1'){
                queue.offer(i*m+j+1);
                grid[i][j+1] = '0';
            }
        }
    }


}
