package String.Palindrome;

public class lc9 {

    /**
     * 整数的数位分解
     */

    public boolean lc9(int x){
        if (x<0 || (x != 0 && x % 10 == 0)) return false;
        int palind = x;
        int rev = 0;
        while (x >0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;

    }


}
