package Array.BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc35 {

    /**
     * 二分法标准模板
     * while(l <= r) :
     *          r n l
     *  1   3   4   5  6  7  8
     */
    public int solution1(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;

        while (left <= right){
            int mid = (right + left) /  2 ;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //Arrays.binarySearch()
        return left;
    }
}
