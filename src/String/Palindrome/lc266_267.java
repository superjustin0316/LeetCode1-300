package String.Palindrome;

import java.util.HashSet;

public class lc266_267 {

    public boolean solution1(String s){
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        return set.size() <= 1;//回文中只有一个元素 次数为奇数

    }

    public boolean solution2(String s){
        char[] count = new char[26];
        int res = 0;
        for (char c : s.toCharArray()){
            if (count[c] > 0){
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length;i++){
            if (count[i] != 0) res++;
        }
        return res <=1;
    }
}
