package Array.Basic;

public class lc75 {
    /**
     * 基础题，面试中会出现变形题
     */

    public void lc75(int[] nums){
        if (nums == null || nums.length ==0) return;
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        while (index <= end){
            if (nums[index] == 0) swap(nums,index++,start++);
            else if (nums[index] == 1) index++;
            else swap(nums,index,end--);//末尾可能有0、1-->index保持不动，继续扫描
        }
    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
