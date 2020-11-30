package DynamicProgramming.Simplified;

public class lc198_213 {

    /**
     n个房屋所能抢到的最大的金额 = max(n-1 个房屋所能抢到的最大金额,
                                   n-2 个房屋所能抢到的最大金额 + 第n个房屋的金额)

     dp[n]=Math.max(dp[n-1],dp[n]+dp[n-2])
     */

    public int lc198_1(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] array = new int[nums.length];//保存每个位置的可以抢到的最大的数
        array[0] = nums[0];
        array[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++)
            array[i] = Math.max(array[i-1], (array[i-2]+nums[i]));
        return array[nums.length-1];
    }


    public int lc198_2(int[] nums){
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums){
            int temp = prevNo;
            prevNo = Math.max(prevNo,prevYes);
            prevYes = num + temp;
        }
        return Math.max(prevNo,prevYes);
    }

    /**
     房屋是圆环
     */
    public int lc213_1(int[] nums) {
        int len = nums.length;
        if (len == 0 ) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        int[] nums1 = new int[len-1];
        int[] nums2 = new int[len-1];
        for (int i = 0; i < len-1; i++) nums1[i] = nums[i];//index[0,len-2]
        for (int i = 1; i < len; i++)  nums2[i-1] = nums[i];//index[1,len-1]

        return Math.max(robSingle(nums1),robSingle(nums2));
    }

    public static int robSingle(int[] nums){
        int len = nums.length;
        int[] arrays = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) arrays[i] = nums[i];
            else if (i == 1) arrays[i] = Math.max(nums[i],nums[0]);
            else arrays[i] = Math.max(arrays[i-1],arrays[i-2]+nums[i]);
        }
        return arrays[len-1];
    }
}
