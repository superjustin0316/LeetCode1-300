package DynamicProgramming.summary;

public class Flabnaci {

    public int fib(int N){
        if (N <= 1){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }

    private int[] memo = new int[15464691];
    public int fib2(int N){
        if (N <= 1){
            return N;
        }
        if (memo[N] == 0){
            memo[N] = fib2(N-1)+fib2(N-2);
        }
        return memo[N];
    }

    public int fib3(int N){
        if (N <= 1){
            return N;
        }
        int[] dp = new int[N+1];
        dp[0] = 0; dp[1] =1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
    }
}
