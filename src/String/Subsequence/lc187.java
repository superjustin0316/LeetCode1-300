package String.Subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc187 {

    public List<String> lc187(String s){
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
             String temp = s.substring(i,i+10);
             if (!seen.add(temp)){// repeated -> 加入失败 -> false
                 repeated.add(temp);
             }
        }
        return new ArrayList<>(repeated);
    }
}
