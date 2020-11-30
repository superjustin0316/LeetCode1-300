package Array.Basic;

import java.util.Arrays;

public class bucketSort_lc164 {

    /**
     * 典型的bucketSort题目
     * 无序变成有序 + 在线性空间时间复杂度 --> bucketSort(大概率)， quickSort（小概率）
     * https://leetcode-cn.com/problems/maximum-gap/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--39/
     */
    public int  bucketSort_lc164(int[] nums){
        if (nums == null || nums.length <2) return 0;

        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int gap = (int)Math.ceil((double)(max -min)/(len -1));//len-1 间隔数
        int[] bucketsMin = new int[len -1];
        Arrays.fill(bucketsMin,Integer.MAX_VALUE);
        int[] bucketsMax = new int[len -1];
        Arrays.fill(bucketsMax,Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;//过滤掉最大值、最小值
            int bucket = (num - min) / gap;//落在第bucket个区间
            bucketsMin[bucket] = Math.min(num,bucketsMin[bucket]);
            bucketsMax[bucket] = Math.max(num,bucketsMax[bucket]);
            }

        int res = 0;
        int pre = min;
        for (int i = 0; i <len -1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE){
                continue;//过滤掉无效值
            }
            //???
            res = Math.max(res, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
