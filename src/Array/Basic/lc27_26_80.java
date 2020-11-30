package Array.Basic;

public class lc27_26_80 {

    public int lc27(int[] nums, int val){
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[res]= nums[i];
                res++;
            }
        }
        return res;
    }
    public int lc27(int[] nums){
        int res = 1;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] != nums[res]){
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public int lc80(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count-2]){
                nums[count++]= nums[i];
            }
        }
        return count;
    }
}
