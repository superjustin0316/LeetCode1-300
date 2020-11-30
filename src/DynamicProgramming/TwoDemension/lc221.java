package DynamicProgramming.TwoDemension;

public class lc221 {
    public int lc221(char[][] matrix){
        //dp[i][j]是[i][j]能延伸的最大长度
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j])+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
