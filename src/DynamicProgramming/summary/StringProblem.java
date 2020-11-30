package DynamicProgramming.summary;

public class StringProblem {
    /**
      字符串
     * Substring    --> sliding window
     * Palindrome
     * Parentheses  --> stack
     * Subsequence

      for (int i = 1; i <= s.length(); i++) {
                  for (int j = 0; j < i; j++) {
     */
    public String lc5(String s){
        if (s == null || s.length() == 0) return s;
        String res = "";
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i)==s.charAt(j) && ((j-i<=2) || dp[i+1][j-1]);
                if (dp[i][j]){
                    if (j - i +1 > max){
                        max = j - i +1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    /**
     网格问题

     for (int i = 1; i < m; i++){
         for (int j = 1; j < n; j++){
             dp[i-1][j]  dp[i][j-1]  dp[i-1][j-1]这三者之间的关系
         }
     }

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
    /**
     匹配问题

     dp[i][j] 表示是str1[0...i-1] -> str2[0...j-1] 所需要的最少步数

     1.字符串相等 dp[i][j] = dp[i-1][j-1];
     2.字符串不等：
     insert: dp[i][j] = dp[i][j-1]+1;  str
     delete: dp[i][j] = dp[i-1][j]+1;  1 str1[0...i-1]删去str[i-2]  2.str[0...i-2] -> str1[0. ..j]
     replace:dp[i][j] = dp[i-1][j-1]+1;    abc  <-->  abe

     */
    public int lc72(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        //主体
        for (int i =1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j])+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[len1][len2];
    }

}
