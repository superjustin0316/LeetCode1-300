package Tree.Important;

public class lc95_96 {
    /**
     f(n)   =f(0)*f(n-1)+f(1)*f(n-2)
     */
    public int lc95(int n){
        int[] res = new int[n+1];
        res[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j]* res[i-j-1];
            }
        }
        return res[n];
    }
}
