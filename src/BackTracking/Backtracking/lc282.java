package BackTracking.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class lc282 {

    public List<String> lc282(String num, int target){
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res,"",num,target,0,0,0);
        return res;
    }

    private void helper(List<String> res, String path, String num, int target,int pos, long val,long pre){
        if (pos == num.length()){
            if (target == val){
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++){
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseUnsignedLong(num.substring(pos,i+1));
            if (pos == 0){
                helper(res,path+cur,num,target,i+1,cur,cur);
            } else {
                helper(res,path+"+"+cur,num,target,i+1,val+cur,cur);
                helper(res,path+"-"+cur,num,target,i+1,val-cur,cur);
                helper(res,path+"*"+cur,num,target,i+1,val-pre+pre*cur,pre*cur);
            }
        }
    }
}
