package BinarySearch;

public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums == null || nums.length == 0) return res;

        int a = binarySearch(nums,target - 0.5);
        int b = binarySearch(nums,target+0.5);
        if (a+1 == b) return res;
        res[0]=a; res[1] =b;
        return res;
    }

    public int binarySearch(int[] nums,double target){
        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = (end -start) /2 + start;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return start;
    }
}
