package Array.BinarySearch;

public class lc33_81 {

    //没有重复的数
    public int lc33(int[] nums, int target){
        int start = 0;  int end = nums.length-1;
        while (start <= end){
            int mid = (start+end)/2;

            if (nums[mid] == target){
                return mid;
            }

            if (nums[start] < nums[mid]){//说明mid前面的数组 是有序数组
                if(nums[start] <= target && target < nums[mid]){
                    end = mid -1;
                } else {
                    start = mid +1;
                    }
                }
            else if (nums[start] >= nums[mid]){//说明mid后面的数组 是有序数组
                if(nums[mid] < target && target <= nums[end]){
                    end = mid + 1;
                } else {
                    start = mid  -1;
                }
            }
        }
        return -1;
    }

    //有重复的数
    //logn n(worse) 1
    public boolean lc81(int[] nums, int target){
        int start = 0;  int end = nums.length-1;
        while (start <= end){
            int mid = (start+end) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target < nums[mid]){
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
            else if (nums[start] > nums[mid]){//说明mid后面的数组 是有序数组
                if (nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            else if (nums[start] == nums[mid]){
                start++;
            }

        }
        return false;
    }
}
