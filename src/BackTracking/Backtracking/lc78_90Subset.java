package BackTracking.Backtracking;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc78_90Subset {
    /** lc78
     数组 无重复元素
     O(2^n)   O(n)
     */
    //1，按照 位置 来选择
    public static List<List<Integer>> lc77_1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(),nums, 0);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
//        System.out.println("index="+index+",list="+list);
        res.add(new ArrayList<>(list));//res.add(list);
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }

    //2，按照 元素有无 来选择
    public static List<List<Integer>> lc77_2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0,path,res,nums);
        return res;
    }
    public static void dfs(int index,List<Integer> path,List<List<Integer>> res,int[] nums){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);//2.有当前元素
        dfs(index+1,path,res,nums);
        path.remove(path.size()-1);
        //path.add(null);//1.无当前元素
        //System.out.println(index+" "+path);
        dfs(index+1,path,res,nums);
        //path.remove(path.size()-1);

    }

    /** lc90
     数组 有重复元素 --> 去重
     O(2^n)   O(n)
     */
    //1. 按照 位置 来选择
    public static List<List<Integer>> lc90_1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        //数组排序
        Arrays.sort(nums);
        helper1(res, new ArrayList<>(),nums, 0);
        return res;
    }
    public static void helper1(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));//res.add(list);
        for (int i = index; i < nums.length; i++){
            //去重
            if (i != index && nums[i] == nums[i-1]) continue;
            //
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }

    //2，按照 元素有无 来选择
    public static List<List<Integer>> lc90_2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs_2(0,path,res,nums);
        return res;
    }
    public static void dfs_2(int index,List<Integer> path,List<List<Integer>> res,int[] nums){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //1.有当前元素
        path.add(nums[index]);
        dfs_2(index+1,path,res,nums);
        path.remove(path.size()-1);

        if (path.size()>0 && path.get(path.size()-1) == nums[index]){
            return;
        }
        //2.无当前元素
        dfs_2(index+1,path,res,nums);

    }

    public static void main(String[] args) {
        int[] nums ={0,1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        res = lc77_2(nums);
        for (List<Integer> list :res){
            System.out.println(list);
        }
    }



}
