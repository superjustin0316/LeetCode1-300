package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class lc77Combination {
    /**
     Combination  C(n,k)
     */
    public static List<List<Integer>> lc77(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        helper_lc77(res, new ArrayList<>(),n,k,1 );
        return res;
    }
    public static void helper_lc77(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        if (k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++){
            list.add(i);
            helper_lc77(res,list,n,k-1,i+1);
            list.remove(list.size()-1);
        }
    }
}
