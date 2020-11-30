package DynamicProgramming.summary;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     解决dp问题时，要思考 如何把问题进行拆分
     1.定义状态
     2.状态转移方程的定义 1、初始状态 2、方程
     LIS
     f(k): 第k项结尾的最长递增子序列的长度
     */
    // f(i)=max(1+LIS(j)) nums(i) > nums(j)
    // f(i)=max(LIS(j))   nums(i) <= nums(j)
    public int lc300(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
