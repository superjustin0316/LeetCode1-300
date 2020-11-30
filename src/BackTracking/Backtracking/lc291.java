package BackTracking.Backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class lc291 {

    public boolean lc291(String pattern, String str){
        // 单词对应 --> hashmap
        // 判断单词是否出现过
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isMatch(str,0,pattern,0,map,set);
    }


    private boolean isMatch(String str,int i, String pat,int j,HashMap<Character,String> map,HashSet<String> set){
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        /**
         匹配
         */
        char c = pat.charAt(j);
        if (map.containsKey(c)){
            String s = map.get(c);
            if (!str.startsWith(s,i)){
                return false;
            }
            return isMatch(str,i+s.length(),pat,j+1,map,set);
        }

        /**
         分割
         */
        for (int k = i; k < str.length(); k++){
            String p = str.substring(i,k+1);
            if (set.contains(p)){
                continue;
            }
            map.put(c,p);
            set.add(p);
            if (isMatch(str,k+1,pat,j+1,map,set)){
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }
}
