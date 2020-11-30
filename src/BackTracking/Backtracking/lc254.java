package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc254 {

    public List<List<Integer>> getFactors(int n){
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(),n,2);//因数从2开始
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list,int n,int start){
        if (n == 1){
            if (list.size() > 1){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= n; i++){
            if (n % i == 0){
                list.add(i);
                helper(res,list,n/i,i);
                list.remove(list.size()-1);//因数可以重复，所以从i开始
            }
        }
    }
}
