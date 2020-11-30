package BinarySearch;

public class lc162 {
    /**
     * 二分法 / 遍历
     * O(log n) O(1)
     */
    public int lc162(int[] nums){
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            if (start == end){
                return start;
            }
            int mid = (end - start)/2 +start;
            if (nums[mid] >= nums[mid+1]){
                end = mid ;
            } else {
                start = mid +1;
            }
        }
        return start;
    }

}
