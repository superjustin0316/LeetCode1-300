package Array.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc169_229 {
    public int lc169(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public List<Integer> lc229(int[] nums){
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int number1 = 0, number2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1){
                count1++;
            } else if (nums[i] == number2){
                count2++;
            } else if (count1 == 0){
                number1 = nums[i];
                count1 =1;
            } else if (count2 == 0){
                number2 = nums[i];
                count2 =1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1){
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        if (count1 > nums.length/3){
            res.add(number1);
        }
        if (count2 >nums.length/3){
            res.add(number2);
        }
        return res;
    }
}
