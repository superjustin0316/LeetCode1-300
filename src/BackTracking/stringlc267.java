package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class stringlc267 {

    public List<String> lc267(String s){
        int odd = 0;
        String mid ="";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();//统计次数

        for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             map.put(c, map.getOrDefault(c, 1)+1);
             odd = odd + map.get(c) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) return res;

        for (HashMap.Entry<Character,Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid= mid + key;
            for (int i = 0; i < val/2; i++){
                list.add(key);

            }
        }
        helper(list,mid,new boolean[list.size()], new StringBuilder(),res);
        return  res;
    }

    private void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res){
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
    }

}
