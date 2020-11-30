package DynamicProgramming.Simplified;

public class lc91 {

    /**
     dp[i] 是前i个数有的方案数
     dp[i] = dp[i-1] + dp[i-2]


     初始状态：
     dp[1] = s.charAt(0) != '0' ? 1:0;
     dp[2] = dp[1] + dp[0]; dp[0] = 1;
     */
    public int lc174_1(String s){
        if (s == null || s.length()== 0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1:0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i-1,i));//从[1,2)开始
            int second = Integer.valueOf(s.substring(i-2,i));//从[0,2)开始
            if (first>=1 && first<=9){
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

    public int lc174_2(String s){
        if (s == null || s.length()== 0||(s.charAt(0)=='0'&&s.length()==1)) return 0;
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
             if (s.charAt(i) == '0'){
                 c1 = 0;
             }
             if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <='6'){
                 c1 = c1 + c2;
                 c2 = c1 - c2;
             } else {
                 c2 = c1;
             }
        }
        return c1;
    }
}
