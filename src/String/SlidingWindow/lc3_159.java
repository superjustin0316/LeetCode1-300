package String.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class lc3_159 {

    //O(n) O(n)
    public int hashMap_solution(String s){
        if (s==null||s.length()==0) return 0;

        HashMap<Character,Integer> map = new HashMap<>();//字符+字符上一次出现的位置
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
             if (map.containsKey(s.charAt(i))){
                 //更新 新的起点
                 j = Math.max(j, map.get(s.charAt(i))+1);
             }
             map.put(s.charAt(i),i);
             res = Math.max(res, i - j +1);
        }
        return res;
    }

    public int hashSet_solution2(String s){
        if (s==null||s.length()==0) return 0;

        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0,j=0; i < s.length(); i++) {
             if (set.contains(s.charAt(i))){
                 set.remove(s.charAt(j));
                 j++;
                 i--;
             } else {
                 set.add(s.charAt(i));
                 res = Math.max(res,set.size());
              }
        }
        return res;
    }

    //O(n) O(n)
    public int lc159(String s){
        if (s == null || s.length() == 0) return 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;

        while (end < s.length()){
            if (map.size() <= 2) {
                //至多存3项记录    size --> 个数
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2){
                int leftMost = s.length();
                for (int num : map.values()){
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                start= leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
