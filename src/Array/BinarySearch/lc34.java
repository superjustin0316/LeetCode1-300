package Array.BinarySearch;

public class lc34 {

    // logn 1
    public int[] solution1(int[] nums, int target){
        int[] res = {-1,-1};
        if (nums == null || nums.length<1) return res;

        int left = binarySearch(nums,target-0.5);
        int right = binarySearch(nums, target+0.5);
        if (right == left){
            return res;//
        }
        res[0] = left;
        res[1] = right - 1;
        return res;
    }
    /**
     *二分法模板
     * while(l <= r) :
     *          r  n  L        r  n  L
     *  1   3   4 4.5 5  5  5  5 5.5 6  7  8
     */
    private int binarySearch(int[] nums, double target){
        int start = 0 ;
        int end = nums.length -1 ;
        while (start <= end) {
            int mid = (end+ start)/2;
            if (target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        return start;
    }

}
