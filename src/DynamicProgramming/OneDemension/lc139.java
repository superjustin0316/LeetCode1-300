package DynamicProgramming.OneDemension;

import java.util.List;

public class lc139 {

    /**
     * 非常重要
     */

    public boolean lc139(String s, List<String> wordDict){
        // 用substring遍历 --> s.length()+1
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]= true 说明前面含有单词
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
}
