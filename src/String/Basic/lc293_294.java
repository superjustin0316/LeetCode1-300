package String.Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc293_294 {
    
    public List<String> lc290_1(String s){
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
             if (s.charAt(i) == '+' && s.charAt(i-1)== '+'){
                 res.add(s.substring(0, i -1)+"--"+s.substring(i+1,s.length() ) );
             }
        }
        return res;
    }

    public List<String> lc290_2(String s){
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' && arr[i+1] =='+'){
                arr[i] = '-';
                arr[i+1] = '-';
                res.add(new String(arr));
                arr[i] ='+';
                arr[i+1]='+';
            }
        }
        return res;
    }

    /**
     * O(2^n)
     * O(2^n)
     */
    public boolean lc294(String s){//s为起始状态
        if (s == null || s.length() == 0) return false;
        if (s == "++") return true;
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s,map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map){
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String player = s.substring(0,i) +"--"+ s.substring(i+2);

                if (!helper(player,map)){//player--false,那么自己就赢了
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}
