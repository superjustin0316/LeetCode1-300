package DynamicProgramming;

public class lc115 {

    /**
     * 将S的subsequence与T比较
     * [S: 0null->1,2,3 ,
     *  T: 0null->1,2,3]
     *
     *  状态转移公式
     *  S[i] != T[j] -> dp[i][j] = dp[i-1][j]
     *  S[i] == T[j] -> dp[i][j] = dp[i-1][j]+dp[i-1][j-1]
     */
    public int lc115(String S, String T){
        int[][] dp =new int[S.length()][T.length()];
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;//S只有一个字符，T为空
        }

        for (int i = 1; i < S.length(); i++) {
            for (int j = 1; j < dp.length; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}
