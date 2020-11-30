package Array.BinarySearch;

public class lc153_154 {

    public int lc153(int[] nums){
        int start = 0 ;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] >= nums[end]){
                start = mid + 1 ;
            } else {
                end = mid;
            }
        }
        return nums[start-1];
    }


    public int lc154(int[] nums){
        int start = 0 ;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] > nums[end]){
                start = mid + 1 ;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
