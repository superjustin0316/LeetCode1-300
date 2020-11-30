package DynamicProgramming.OneDemension;

public class lc62_63 {

    /** 2D :
     res[i][j]  从（0，0）到（i，j）的路线数目
     */
    public int lc62_1(int m, int n){
        int[][] res = new int[m][n];
        //行列初始化
        for (int i = 0; i < m; i++){
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            res[0][i] = 1;
        }
        //主体
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }

    /** 1D :
     res[j]  本质和2D一样
     */
    public static int lc62_2(int m, int n){
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j-1];
            }
        }
        return res[n-1];
    }

    public int lc63(int[][] obstacleGrid){
        int length = obstacleGrid[0].length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    res[j] = 0;
                } else if (j >0){
                    res [j] += res[j-1];
                }
            }
        }
        return res[length -1];
    }

    public static void main(String[] args) {
        int res=lc62_2(4,3);
        System.out.println(res);
    }
}
