package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class lc60 {

    public String lc31(int n,int k){
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        //fact存放的是阶乘
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i-1];
        }
        k = k-1;//程序从0开始
        StringBuilder sb = new StringBuilder();
        for (int i = n; i>0; i--){
            int index = k / fact[i-1];
            k = k % fact[i-1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }
}
