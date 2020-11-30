package DynamicProgramming.summary.backBag;

public class backbag {
    public int backBag(int[] weight, int[] value,int C,int N){
        int[][] memo = new int[N][C+1];
        String[][] path = new String[N][C+1];
        //初始化
        for (int i = 0; i <= C; i++) {
            memo[0][i] = 0;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++){//限制条件
                if (j < weight[i]){//不放
                    memo[i][j] = memo[i-1][j];
                    if (path[i-1][j] != null){
                        path[i][j] = path[i-1][j];
                    }
                } else {//放
                    if (memo[i-1][j]>value[i]+memo[i-1][j-weight[i]]){
                        memo[i][j] = memo[i-1][j];
                        if (path[i-1][j] != null){
                            path[i][j] = path[i-1][j];
                        }
                    } else {
                        memo[i][j] = value[i]+memo[i-1][j-weight[i]];
                        if (path[i-1][j-weight[i]] == null){
                            path[i][j] = i +"";
                        } else {
                            path[i][j] = path[i-1][j-weight[i]]+" "+i;
                        }
                    }
                }
            }
        }
        return memo[N-1][C];
    }
}
