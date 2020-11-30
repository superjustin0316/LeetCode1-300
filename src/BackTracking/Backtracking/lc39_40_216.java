package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc39_40_216 {
    //O(2^n)   O(n)
    public List<List<Integer>> lc39(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper_lc39(res, new ArrayList<>(), candidates, target , 0);
        return res;
    }
    private void helper_lc39(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if (target <  0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper_lc39(res,list,candidates,target - candidates[i],i);
            list.remove(list.size()-1);
        }
    }

    //O(2^n)   O(n)
    public List<List<Integer>> lc40(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper_lc40(res, new ArrayList<>(), candidates, target , 0);
        return res;
    }
    private void helper_lc40(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if (target <  0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (i != start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            helper_lc40(res,list,candidates,target - candidates[i],i+1);//不能有重复的 -->i+1
            list.remove(list.size()-1);
        }
    }

    //O(2^n)   O(n)
    public List<List<Integer>> lc216(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        helper_lc216(res, new ArrayList<>(),k,n,1);
        return res;
    }
    public void helper_lc216(List<List<Integer>> res, List<Integer> list,  int k, int n,int start){
        if (k == 0 && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++){
            list.add(i);
            helper_lc216(res,list,k-1,n-i,i+1);
            list.remove(list.size()-1);
        }
    }
}
