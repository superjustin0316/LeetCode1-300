package Math;

public class lc8 {
    /**
     * String -> Integer
     * 1. +/-
     * 2. 字母->valid
     * 3. 越界
     *
     * O(n) O(1)
     */
    public int lc8(String str){
        str = str.trim();//确保是个string
        if (str == null || str.length() == 0) return 0;
        //判断符号
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;

        if (firstChar == '+'){
            sign = 1;
            start++;
        } else if (firstChar == '-'){
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';

            //越界
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
