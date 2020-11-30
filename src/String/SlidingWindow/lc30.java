package String.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc30 {

    public List<Integer> lc30(String s, String[] words){
        if (s== null || words == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        HashMap<String,Integer> map = new HashMap<>();

        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) +1);
        }


        for (int i =0; i<= s.length() - n*m; i++){
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;//单词总数
            int j = i;
            while (k > 0){
                String str = s.substring(j,j + m);
                if (!copy.containsKey(str) || copy.get(str) == 0){
                    break;
                }
                copy.put(str, copy.get(str)-1);
                k--;
                j=j+m;
            }
            if (k == 0) res.add(i);
        }
        return res;

    }
}
