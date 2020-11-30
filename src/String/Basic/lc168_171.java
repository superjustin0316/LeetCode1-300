package String.Basic;

public class lc168_171 {
    /**
     * 本质是 26进制计数
     */
    public String lc168(int n){
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            sb.append((char)('A' + n % 26));//末尾
            n = n / 26;
        }
        return sb.reverse().toString();
    }


    public int lc171(String s){
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);

        }
        return res;
    }
}
