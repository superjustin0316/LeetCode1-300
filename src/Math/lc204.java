package Math;

public class lc204 {

    public int lc204(int n){
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false){//是质数
                res++;
                for(int j = 2; i*j < n; j++){
                    // 2*2 2*3 2*4
                    notPrime[i*j] = true;
                }
            }
        }
        return res;
    }
}
