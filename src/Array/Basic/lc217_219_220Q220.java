package Array.Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class lc217_219_220Q220 {
    // n  n
    public boolean lc217(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    //nlogn  1
    public boolean solution2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //相邻两个是否相等
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    //n n
    public boolean lc219(int[] nums,int k){
        //key: nums[i]  value: i
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if ((i-map.get(nums[i])) <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    /**
     *treeset(ceiling返回大于或等于element的最小元素，floor返回小于或等于element的最小元素)
     * 遍历
     * treeset
     * nums[i] <= t <= nums[j]
     * i <= k <= j
     */
    public boolean lc220(int[] nums,int k ,int t){
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i] +t);
            Long ceil = set.ceiling((long) nums[i] - t);

            if ((floor!= null && floor >= nums[i])||(ceil!= null && ceil <= nums[i])){
                return true;
            }

            set.add((long) nums[i]);
            if(i>= k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }

}
