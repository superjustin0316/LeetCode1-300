package Array.Basic;

public class lc283 {
    /**
     * facebook经常出变形题，面试经常出现
     */

    //出现很少个0：num of operation: num.length;
    public void solution1(int[] nums){
        if (nums == null || nums.length == 0) return ;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[start] = nums[i];
                start++;//start 落后于 i
            }
        }
        while (start<nums.length){
            nums[start++] = 0;
        }
    }

    //出现很多个0：num of operation: 2*num of no-zero
    public void solution2(int[] nums){
        if (nums == null || nums.length == 0) return;
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }
}
