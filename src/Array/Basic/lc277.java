package Array.Basic;

public class lc277 {
    public int lc277(int n){
        if ( n<2) return  -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
             if (knows(possible,i)){
                 possible = i;
             }
        }
        for (int i = 0; i < n; i++) {
             if (possible != i && ((knows(possible,i))||!knows(i,possible))){
                 return -1;
             }
        }

        return possible;
    }
    public boolean knows(int a, int b){
        return true;
    }
}
