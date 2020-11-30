package String.CountSort_HashMap;

public class lc242 {

    public boolean lc242(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i - 'a')]--;
        }

        for (int num : count ){
            if (num != 0 ) return false;
        }
        return  true;
    }
}
