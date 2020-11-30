package Matrix;


import java.util.ArrayList;
import java.util.List;

public class lc296 {
    /**
     * 降维： 二维-->一维
     *       先求x方向的，再求y方向的
     *
     * 对于单个方向：奇数点 --> 中心点处
     *             偶数点 --> 中间区间
     *
     *   O(m*n) O(n)
     */
    public int lc296(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();

        for (int i = 0; i < m ; i++){
            for (int j = 0; i <n; j++){
                if (grid[i][j] == 1){
                      I.add(i);//记录横向的坐标
                }
            }
        }

        for (int j = 0; j < n; j++){
            for (int i = 0; i < m;i++){
                if (grid[i][j] == 1){
                    J.add(j);
                }
            }
        }
        return min(I)+min(J);
    }

    private int min(List<Integer> list){
        int i =0, j = list.size();
        int sum = 0;
        while (i < j){
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
