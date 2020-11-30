package Array.Basic;

public class lc88 {
    public void lc81(int[] nums1, int m, int[] nums2, int n ){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {//如果nums2有剩余，就继续复制。如果nums1有剩余，就没有影响
            nums1[k--] = nums2[j--];
        }
    }
}
