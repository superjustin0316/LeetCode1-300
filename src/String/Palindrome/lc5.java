package String.Palindrome;

public class lc5 {
    /**
     * DP
     */
    public String solution1(String s){
        if (s == null || s.length()==0) return  s;

        String res ="";
        boolean[][] dp = new  boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i<=j; i++){
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
     * 中心扩散
     */
    String res = "";
    public String solution2(String s){
        if (s== null || s.length() == 0) return s;
        for (int i  = 0; i < s.length(); i++){
            helper(s,i,i);//奇数回文
            helper(s,i,i+1);//偶数回文
        }
        return res;
    }

    public void helper(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if (cur.length() > res.length()){
            res = cur;
        }
    }
}
