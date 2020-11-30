package String.CountSort_HashMap;

import java.util.HashMap;

public class lc205 {

    //对应关系：hashMap / countSort

    //O(n^2) O(1)
    public  boolean solution1(String s, String t){
        if (s ==null || t== null){
            return true;
        }
        HashMap<Character,Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)){
                if (map.get(a).equals(b)) continue;
                else return false;
            }else {
                if (!map.containsValue(b)){
                    map.put(a,b);
                } else return false;
            }
        }
        return true;
    }


    //O(n) O(1)
    public  boolean solution2(String s, String t){
        int[] sChars = new int[256];
        int[] tChars = new int[256];//有256个字符,字母：tChars.[t.charAt(i)-'a']

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]){
                return false;
            } else {
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }
}
