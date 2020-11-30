package Array.Basic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc243_244_245 {

    /**
     暴力解法
     1. 两个for循环 分开找
     2. 一个for循环 同时找
     */

    public int lc243(String[] words, String word1, String word2){
        int res = words.length;
        int a = -1;
        int b =-1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)){
                a = i;
            } else  if (words[i].equals(word2)){
                b = i;
            }
            if (a != -1 && b != -1){
                res = Math.min(res, Math.abs(a-b));
            }
        }
        return res;
    }

    private HashMap<String, List<Integer>> map;
    public void lc244(String[] words){
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }
    }
    public int shortest(String word1, String word2){
        List<Integer> l1 =map.get(word1);
        List<Integer> l2 =map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0; int j = 0;
        while (i < l1.size() && j <l2.size()){
            res = Math.min(res,Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) <l2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public int lc245(String[] words, String word1, String word2){
        int res = words.length;
        int a = -1;
        int b = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)){
                a = i;
            }
            if (words[i].equals(word2)){
                if (words[i].equals(word2)){
                    a = b;//
                }
                b = i;
            }
            if (a != -1 && b != -1){
                res = Math.min(res, Math.abs(a-b));
            }
        }
        return res;
    }

}
