package DynamicProgramming.summary.backBag;

public class backBag_01 {
    /**
             0、1背包问题

      f(i,c)  -->  第i件物品，容量为c，最大价值为f(i,c)
      状态转移方程：
      1.初始化   2.是否

     */
    //dp[][] 组合后的价值
    public int backBag(int[] weight, int[] value,int C,int N){
        int[][] memo = new int[N][C+1];
        //初始化
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        //dp[][]:
        //不放 f(i,c) = f(i-1,c)
        //放   f(i,c) = v(i) + f(i-1,c-w(i))
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++){//限制条件
                if (j < weight[i]){//不放
                    memo[i][j] = memo[i-1][j];
                } else {//放
                    memo[i][j] = Math.max(memo[i-1][j], value[i]+memo[i-1][j-weight[i]]);
                }
            }
        }
        return memo[N-1][C];
    }

    /**
     * 优化 只用两行 来缩小空间复杂度
     */

    public int backBag2(int[] weight, int[] value,int C,int N){
        int[][] memo = new int[2][C+1];
        //初始化
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        //dp[][]:
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++){//限制条件
                if (j < weight[i]){//不放
                    memo[i % 2][j] = memo[(i-1)%2][j];
                } else {//放
                    memo[i % 2][j] = Math.max(memo[(i-1) % 2][j], value[i]+memo[(i-1)%2][j-weight[i]]);
                }
            }
        }
        return memo[(N-1)%2][C];
    }
    /**
      改变第二个for顺序
     */
    public int backBag3(int[] weight, int[] value,int C,int N){
        int[] memo = new int[C+1];
        //初始化
        for (int i = 0; i <= C; i++) {
            memo[i] = (i >= weight[0]) ? value[0] : 0;
        }
        //dp[][]:
        for (int i = 1; i < N; i++) {
            for (int j = C;j >= weight[i];j--){
                memo[j] = Math.max(memo[j],value[i]+memo[j - weight[i]]);
            }
        }
        return memo[C];
    }
}
