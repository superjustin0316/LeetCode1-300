package BinarySearch;

public class lc35 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (end - start) /2 + start;
            if (nums[mid] == target){
                return mid;//查到相同的值
            } else if (nums[mid] > target){
                end = mid -1;
            } else if (nums[mid] < target){
                start = mid +1;
            }
        }
        return start;//查不到相同的值，

    }
}
