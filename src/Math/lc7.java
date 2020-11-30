package Math;

public class lc7 {
    /**
     * int的范围：
     * - 2147483648 ~ 2147483647
     *
     * 用long 防止越界
     */

    public int lc7(int x){
        long res = 0;
        //不需要注意符号
        while (x!=0){
            res = x * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
}
