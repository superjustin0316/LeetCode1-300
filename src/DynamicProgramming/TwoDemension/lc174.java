package DynamicProgramming.TwoDemension;

public class lc174 {

    public int lc97(int[][] dungeon){
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        //health + harm >= 1
        //health >= 1 - harm Math.max
        dp[m-1][n-1] = Math.max(1- dungeon[m-1][n-1],1);
        for (int i = m-2 ; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1],1);
        }
        for (int i = n-2; i >= 0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1]- dungeon[m-1][i],1);
        }
        for (int i = m-2 ; i >= 0; i--){
            for (int j = n-2; j >= 0; j--) {
                int down = Math.max(dp[i+1][j] - dungeon[i][j],1);
                int right = Math.max(dp[i][j+1] - dungeon[i][j],1);
                dp[i][j] = Math.min(down,right);
            }
        }
        return dp[0][0];
    }
}
