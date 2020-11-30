package BinarySearch;

public class lc153_154 {

    /**
     * 二分法中为啥常用mid=beg+(end-beg)/2 而非mid=(beg+end)/2 ?
     *
     * 第一 前者不会产生溢出，而后者可能会。
     * 第二 前者适用于对迭代器的操作，而后者不行。
     */
    public int lc153(int[] nums){
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = (end - start)/2 + start;

            if (nums[start] <= nums[mid]){
                start = mid + 1;

            }
            if (nums[start] > nums[mid]){
                end = mid ;
            }
        }
        return nums[end];
    }

    public int lc154(int[] nums){

        /**
         * 因为可能翻转，所以前部分可能有，后部分一定有
         */

//        if (nums == null || nums.length == 0) return false;
//        int start = 0;
//        int end = nums.length -1;
//        while (start <= end){
//            int mid = (end - start)/2 + start;
//
//            if (nums[start] < nums[mid]){
//                start = mid+1;
//            } else if (nums[start] > nums[mid]){
//                end = mid;
//            } else {
//                start++;
//            }
//        }
//        return nums[start];

        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = (end -start)/2 +start;
            if (nums[mid] < nums[end]){
                end = mid;
            } else if (nums[mid] > nums[end]){
                start =mid +1;
            } else {
                end--;
            }
        }
        return nums[start];

    }

}
