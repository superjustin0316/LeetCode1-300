package DynamicProgramming.Simplified;

public class lc276 {

    //当前面俩色相同，第三个和第二个就需要不相同，如果前面两个不相同，第二个和第三个就可以重复，
    // 以此类推，可以根据第二个和第三个是不是相同的来决定第四个的颜色
    public int numWays_1(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }


    // DFS, timeout
    public int NumWays_2(int n,int k) {
        if (n < 1 || k < 1) return 0;
        return DFS(n, k, 1, k, false);
    }

    private int DFS(int n, int k, int start, int cur, boolean sameColor){
        if (start >= n) return cur;

        if (sameColor) return DFS(n, k, start + 1, cur * (k - 1), false);

        else return DFS(n, k, start + 1, cur, true) +
                DFS(n, k, start + 1, cur * (k - 1), false);
    }

}
