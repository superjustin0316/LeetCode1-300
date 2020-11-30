package String.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class lc131_132 {

    /**
     * lc131
     *  O(2^n) O(n)
     */

    public static List<List<String>> lc131(String s){
        List<List<String>> res = new ArrayList<>();
        if(s ==null || s.length() == 0) return res;
        lc131Helper(res, new ArrayList<>(),s);
        return res;
    }

    public static void lc131Helper(List<List<String>> res, List<String> list, String s){
        if (s.length() == 0){
            res.add(new ArrayList<>(list));
            System.out.println("newList");
            return;
        }//结束
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s.substring(0,i+1))){//[0,i+1)
                list.add(s.substring(0,i+1));
                System.out.println(s.substring(0,i+1)+" i:"+i);
                lc131Helper(res,list,s.substring(i+1));//i+1到末尾
                System.out.println("lis.size()-1:  "+list.get(list.size()-1));
                list.remove(list.size()-1);
                System.out.println("------");
            }
        }
    }

    /**
     * 直接遍历判断回文 复杂度较高， 用DP的思想可以减小复杂度  ->二维DP
     * [][] isPalindrome
     * []cuts
     * 状态转移公式：
     * s.charAt(i) == s.charAt(j) && ( i-j<2 || isPalindrome[j+1][i-1])
     *  i  j
     */
    public int lc132(String s){
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = 0 ; j <= i ; j++){
                if (s.charAt(i) == s.charAt(j) && (i-j<2 || isPalindrome[j+1][i-1])){
                    //i-j = 0,1 -> 重合/相隔一个字符
                    isPalindrome[i][j] = true;
                    min = i == 0 ? 0 : Math.min(min,cuts[j-1]+1);
                }
            }
            cuts[i] = min;
        }
        return cuts[len-1];

    }

    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
             if (s.charAt(i) != s.charAt(s.length()-1-i)){
                 return false;
             }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        res = lc131("aabbc");

        System.out.println("result:");
        System.out.println(res);
    }

    /**
     * List<Integer> integerList = new ArrayList<>();
     *
     * 当我们要移除某个Item的时候
     * remove(int position)：移除某个位置的Item
     * remove(object object)：移除某个对象
     *
     * 那么remove(12)到底是移除第12的item，还是移除内容为12的Item。
     *
     * 那就要看12到底是int类型还是Integer类型，如果是int类型那么就是移除第12的item，如果是第Integer类型，那么就是移除内容为12的Item。
     */
}
