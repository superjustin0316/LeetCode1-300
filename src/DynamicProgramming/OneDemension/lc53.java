package DynamicProgramming.OneDemension;

public class lc53 {
    public int lc53(int[] nums){

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[i] + (dp[i-1] < 0 ? 0 : dp[i-1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * follow up: 按divide & conquer的方法写。
     */

    public int solution2(int[] nums){
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res,sum);
        }
        return res;
    }

}
