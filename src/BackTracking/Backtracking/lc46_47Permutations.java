package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc46_47Permutations {

    /** lc46
     permutation
     数组无重复元素
     */
    //O(n!*n)  O(n)
    //时间复杂度分析： http://www.1point3acres.com/bbs/thread-117602-1-1.html
    public static List<List<Integer>> lc46_1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length ==0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0 ; i < nums.length; i++){
            if (list.contains(nums[i])) continue;//O(n)
            list.add(nums[i]);
            helper(res,list,nums);
            list.remove(list.size()-1);
        }
    }

    public static List<List<Integer>> lc46_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length ==0) return res;
        helper2(res, 0, nums);
        return res;
    }
    public static void helper2(List<List<Integer>> res, int start, int[] nums){
        if (start == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            res.add(new ArrayList<>());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            swap(nums,start,i);
            helper2(res,start,nums);
            swap(nums,start,i);
        }
    }
    public static  void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] =temp;
    }

    /** lc47
     permutation
     数组有重复元素
     */
    public static List<List<Integer>> lc47(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length ==0) return res;
        Arrays.sort(nums);
        helper3(res, new ArrayList<>(), nums,new boolean[nums.length]);
        return res;
    }
    public static void helper3(List<List<Integer>> res,List<Integer> list, int[] nums, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0 ; i < nums.length; i++){
            /**
             去重：   i >0 && nums[i] == nums[i-1] -->避免结果重复
             used:  是否用过，避免重复使用 --> 添加的元素重复
             */
            if (used[i] || i >0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            used[i] = true;
            list.add(nums[i]);
            helper3(res,list,nums,used);
            used[i] = false;
            list.remove(list.size()-1);
        }

    }
}
