package BinarySearch;

public class lc33_81 {
    public int lc33(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;

        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (end - start) /2 + start;

            if (nums[mid] == target){
                return mid;
            }

            if ( nums[start] <= nums[mid] ){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                } else{
                    start = mid+1;
                }
            } else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                } else{
                    end = mid-1;
                }

            }
        }
        return - 1 ;
    }


    public boolean lc81(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = (end - start)/2 + start;

            if (nums[mid] == target) return true;

            if (nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end =mid -1;
                } else{
                    start =mid+1;
                }

            } else if (nums[start] > nums[mid]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid +1;
                } else{
                    end =mid -1;
                }

            } else {
                start++;
            }
        }
        return false;
    }
}
