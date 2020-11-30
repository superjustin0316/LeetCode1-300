package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class lc93 {
    public List<String> lc93(String s){
        List<String> res = new ArrayList<>();
        helper(res,s,0,"",0);
        return res;
    }

    public void helper(List<String> res, String s, int index , String ret,int count){
        if (count >4) return;
        if (count == 4 && index == s.length()){
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++){
            if (index + i > s.length()) break;
            String temp = s.substring(index, index+i);
            //ip不能从0开始
            if ((temp.startsWith("0") && temp.length()>1) || (i == 3 && Integer.parseInt(temp)>=256)) continue;
            ret = ret +temp+(count == 3 ? "":".");
            helper(res,s,index+i,ret,count+1);
        }
    }
}
