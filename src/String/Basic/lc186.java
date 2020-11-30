package String.Basic;

public class lc186 {

    public void lc86(char[] s){
        reverse(s,0,s.length);
        int r = 0;
        while (r < s.length){
            int l =r;
            while (r<s.length && s[r] != ' '){
                r++;
            }
            reverse(s,l,r-1);
            r++;
        }

    }

    private void reverse(char[] s, int i, int j){
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;j--;
        }
    }
}
