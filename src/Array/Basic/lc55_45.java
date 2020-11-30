package Array.Basic;

public class lc55_45 {
    /**
     * O(n) O(1)
     */
    public boolean lc55solution(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( i > max ) return false;//判断之前是否能到达当前节点
            max = Math.max(nums[i] + i, max );
        }
        return true;
    }

    /**
     *  O(n) O(1)
     */
    public int jump1(int[] nums){
        if (nums == null || nums.length == 1) return 0 ;
        int step = 0 ;
        int left = 0 ;
        int right = 0 ;
        for (int i = 0; i < nums.length - 1 ; i++) {//注意是length-1；最后一个格子不作为起点
            right =Math.max(right, i+nums[i]);
            if (i == left) {
                step++;
                left = right;
            }
        }
        return step;
    }

    //???
    public int jump2(int[] nums){
        if (nums == null || nums.length == 1) return 0 ;
        int step = 0 ;
        int left = 0 ;
        int right = 0 ;
        int i = 0;

        while ( left > i -1){
            step++;
            for (; i <= left; i++){
                right=Math.max(right,nums[i]+1);
                if (right > nums.length-1){
                    return step;
                }
            }
            left = right;
        }
        return 0;
    }
}
