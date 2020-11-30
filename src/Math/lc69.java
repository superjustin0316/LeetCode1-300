package Math;

public class lc69 {
    /**
     * 与lc367 题目一模一样
     */

    public int solu1(int x){
        if (x <=0) return 0;
        int start = 1;
        int end = x;
        while(start <= end){
            long mid = (start+end)/2;
            if (mid * mid <x){
                start = (int) mid+1;
            } else if (mid*mid == x){
                return (int) mid;
            }else {
                end = (int) mid -1;
            }
        }
        if (end * end < x) {
            return (int) end;
        } else {
            return (int) start;
        }
    }
}
