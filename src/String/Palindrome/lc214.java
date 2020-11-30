package String.Palindrome;

public class lc214 {
    /**
     0 1 2 3 4 5 6
     i           j
     a a b c a a a
         i   j
         i     j
               e
     在s的前部加上string， String + s
     判断 [0,end]的字符串是否为回文
     */
    //O(n^2) time
    public static String lc214(String s){
        int i = 0;
        int j = s.length()-1;
        int end = s.length()-1;
        while (i<j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        String res = new StringBuilder(s.substring(end+1)).reverse().toString() +s;
        return res;
    }

    public static void main(String[] args) {
        String s = "aabcaaa";
        System.out.println(lc214(s));
    }
}
