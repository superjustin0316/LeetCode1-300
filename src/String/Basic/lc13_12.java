package String.Basic;

public class lc13_12 {
    /**
     * 规律：左边的数字如果小于右边的数字 = 右边 - 左边
     * ...IV IV=V-I
     * res: ...IV -> ...+I+(V-I)-I -> ...(V-I)
     *
     * O(n) O(1)
     */
    public int lc13(String s){
        if (s == null || s.length() == 0) return 0;
        int res = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
             if (toNumber(s.charAt(i)) > toNumber(s.charAt(i-1))){
                 res = res + toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i-1));
             } else {
                 res = res + toNumber(s.charAt(i));
             }
        }
        return res;
    }

    /**
     *  char -> int
     */
    public static int toNumber(char c){
        int res = 0;
        switch (c){
            case 'I':return 1;
            case 'V':return 1;
            case 'X':return 1;
            case 'L':return 1;
            case 'C':return 1;
            case 'D':return 1;
            case 'M':return 1;
        }
        return res;
    }


    public static String lc12(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while ( num >= values[i]){
                num = num - values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(lc12(9723));
    }





}
