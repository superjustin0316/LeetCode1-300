package Math;

public class lc66 {

    /**
     * O(n) O(n)
     * 1 0 1 1 -> 1 0 1 2
     * 1 0 9 9 -> 1 1 0 0
     *
     * 9 9 9 9 -> 1 0 0 0 0
     */
    public int[] lc66(int[] digits){
        if (digits == null || digits.length == 0) return digits;

        for (int i = digits.length - 1; i >= 0; i-- ){
            if (digits[i] <= 8){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
