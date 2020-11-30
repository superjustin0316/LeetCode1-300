package DynamicProgramming.summary.backBag;

import java.util.Arrays;

public class followup {
    public int backBag(int[] weight, int[] value,int C,int N){
        int[][] memo = new int[N+1][C+1];
        String[][] path = new String[N+1][C+1];
        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++){//限制条件
                if (j < weight[i-1]){//不放
                    memo[i][j] = memo[i-1][j];
                    if (path[i-1][j] != null){
                        path[i][j] = path[i-1][j];
                    }
                } else {//放
                    if (memo[i-1][j] > value[i-1]+memo[i-1][j-weight[i-1]]){
                        memo[i][j] = memo[i-1][j];
                        if (path[i-1][j] != null){
                            path[i][j] = path[i-1][j];
                        }
                    } else {
                        memo[i][j]=value[i-1]+memo[i-1][j-weight[i-1]];
                        if (path[i-1][j-weight[i-1]] == null){
                            path[i][j] = i +"";
                        } else {
                            path[i][j] = path[i-1][j-weight[i-1]]+" "+i;
                        }
                    }
                }
            }
        }
        for (String[] s : path){
            System.out.println(Arrays.toString(s));
        }
        return memo[N][C];
    }
}
