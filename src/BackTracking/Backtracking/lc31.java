package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class lc31 {
    public void lc31(int[] nums){
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            if (i==0){
                Arrays.sort(nums);
                return;
            } else {
                if (nums[i] > nums[i-1]){
                    Arrays.sort(nums,i,n);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j]>nums[i-1]){
                            int tmp = nums[i-1];
                            nums[i-1] = nums[j];
                            nums[j] = tmp;
                            return;
                        }

                    }
                }
            }
        }
    }
}
