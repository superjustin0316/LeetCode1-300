package Math;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class lc29 {
    /**
     * 1.符号
     * 2.幅值：被除数为0，被除数 < 除数
     *
     */

    public int divide(int dividend, int divisor){
        int sign = 1;
        if ((dividend > 0 && divisor <0) || (dividend <0 && divisor >0)) sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldividend < ldivisor || ldividend == 0) return 0;
        long lres = divide(ldividend, ldivisor);

        return (int)lres;
    }

    public long divide(long ldvidend, long ldivisor){
        if (ldvidend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum +sum) <= ldvidend){
            sum += sum;
            multiple += multiple;
        }
        return multiple+divide(ldvidend-sum,ldivisor);
    }



    public int solu1(int dividend, int divisor){
        if (divisor == 0) return 0;
        if (dividend == Integer.MIN_VALUE){
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == 1) return Integer.MIN_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor <0) || (dividend <0 && divisor >0)) sign = -1;
        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);
        int res = 0;

        while (divd >= divs){
            int shift = 0;
            while (divd >= divs<<shift){
                shift++;
            }
            res +=(1 << (shift-1));
            divd -=(divs << (shift-1));
        }
        return sign * res;
    }
}
