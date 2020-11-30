package DynamicProgramming.TwoDemension;

public class lc72 {

    /**
      dp[i][j] 表示是str1[0...i-1] -> str2[0...j-1] 所需要的最少步数

      1.字符串相等 dp[i][j] = dp[i-1][j-1];
      2.字符串不等：
      insert: dp[i][j] = dp[i][j-1]+1;  str
      delete: dp[i][j] = dp[i-1][j]+1;  1 str1[0...i-1]删去str[i-2]  2.str[0...i-2] -> str1[0. ..j]
      replace:dp[i][j] = dp[i-1][j-1]+1;    abc  <-->  abe

     https://blog.csdn.net/qq_17550379/article/details/84198977
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
    /**
     我们通过两个指针i和j分别指向word1和word2。我们定义函数f(i,j)
     f(i,j)表示word1[:i]转换为word2[:j]需要的最少步骤。
     我们首先要比较word1[i-1]和word2[j-1]是不是相同，如果相同的话，我们就不用做任何操作，所以此时f(i,j)=f(i−1,j−1)
     f(i,j)=f(i−1,j−1)（i和j都向前挪一个位置）。

     接着对于不相同的时候我们的情况比较复杂，我们有三种处理手段，分别是insert、replace和remove。我们先看insert操作。我们insert完之后，也就是word1中的元素会保持不变，而j会向前挪一个位置，也就是f(i,j)=f(i,j−1)+1
     f(i,j)=f(i,j−1)+1。接着考虑replace操作，replace会减少word1和word2中一个需要比较的元素（i和j会向前挪一个位置），也就是f(i,j)=f(i−1,j−1)+1
     f(i,j)=f(i−1,j−1)+1。我们接着考虑最后一个remove操作，这个就很容易了，word1中会减少一个需要比较的元素，而我们j的位置不变，也就是f(i,j)=f(i−1,j)+1
     f(i,j)=f(i−1,j)+1。所以我们最后的结果相当三者取最小值即可。
     */


}
