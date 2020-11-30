package String.SlidingWindow;

public class lc76 {
    //O(n) O(1)
    public static String lc76(String s, String t){
        int[] cnt = new int[128];//128个字符（数字+ 字母）
        for( char c : t.toCharArray()){
            cnt[c]++;
            //charAt(index);这个方法返回的是char类型，char类型可以隐式的转换成int类型
        }

        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < s.length(); i++) {
            /**
             * cnt[t.charAt(i)]++   t的字符++
             * cnt[s.charAt(i)]>0   s.charAt(i) 在 t 中出现过
             * i 从前向后  j 记录起点
             * t出现的字符 = 0；t未出现的字符 < 0
             */
            if (cnt[s.charAt(i)] > 0) total--;
            cnt[s.charAt(i)]-- ;
            while (total == 0){
                if (i - j + 1 < min){
                    //更新最小值min
                    min = i - j + 1;
                    from = j;
                }
                /**
                 * cnt[s.charAt(j)]>0 是t中的字符先大于0
                 * 往后遍历，看是否有t中的字符出现
                 */
                cnt[s.charAt(j)]++;
                if (cnt[s.charAt(j)] > 0) total++;
                j++;
            }
        }
        return (min == Integer.MAX_VALUE)? "":s.substring(from,from+min);
    }
}
