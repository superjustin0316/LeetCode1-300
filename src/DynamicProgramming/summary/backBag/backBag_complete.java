package DynamicProgramming.summary.backBag;

public class backBag_complete {
    /**
     * 法1 转换为0、1背包问题
     * 3个A 2个B  --> A A A B B 改变输入
     */
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
     * 法二 正向判断
     */
    public int backBag3(int[] weight, int[] value,int C,int N){
        int[][] memo = new int[N][C+1];
        //初始化
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        //dp[][]:
        //不放 f(i,c) = f(i-1,c)
        //放   f(i,c) = v(i) + f(i-1,c-w(i))
        for (int i = 1; i < N; i++) {
            for (int j = weight[i]; j <= C; j++){//限制条件
                    memo[i][j] = Math.max(memo[i-1][j], value[i]+memo[i-1][j-weight[i]]);
            }
        }
        return memo[N-1][C];
    }

}
