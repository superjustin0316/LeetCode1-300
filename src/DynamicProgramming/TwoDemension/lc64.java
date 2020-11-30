package DynamicProgramming.TwoDemension;

public class lc64 {

    public int lc64(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //初始化
                if (i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                if (i != 0 && j == 0) grid[i][j] += grid[i-1][j];
                //主体
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
