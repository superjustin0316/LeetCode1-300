package BitManipulation;

public class lc136 {

    public int lc136(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    /**
     * 连续的数 尾部按位与之后都是'0' ，保留了前面相似的部分
     */
    public int lc207(int m, int n){
        int offset =0;
        while ( m != n){
            m >>=1;
            n >>=1;
            offset++;
        }
        return m << offset;
    }

    /**
     * 将一个数的二进制进行翻转, 二进制只有32位
     * &1:  ①判断奇偶数 ②判断最低位是否为1
     */
    public int lc190(int n){
        if (n == 0) return  0;
        int res = 0;
        for (int i= 0;i < 32; i++){
             res <<= 1;
             if ((n & i) == 1) res++;//判断末尾是否为1
             n >>= 1;
        }
        return res;
    }

    /**
     * 位运算的基础题
     * 判断32位中有几个'1'
     * 法1： &1
     * 法2： n &=(n-1); 把最后的1变为0
     */
    public int lc191_1(int n){
        int res =0;
        for (int i = 0; i < 32; i++) {
             res = res+ n & 1;
             n >>=1;
        }
        return res;
    }
    public int lc191_2(int n){
        int res = 0;
        while (n!=0){
            n &=(n-1);
            res++;
        }
        return res;
    }

    /**
     * 判断从0开始的数列中丢失的数
     * i^i =0 一个数和本身 异或 --> 0
     */
    public int lc268(int[] nums){
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

}
