package DynamicProgramming.TwoDemension;

public class lc256_265 {

    public int lc256(int[][] costs){
        if (costs == null || costs[0].length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(costs[n][0],costs[n][1]),costs[n][2]);
    }

    public static int lc265(int[][] costs){
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        // min1 min2 是颜色标签
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int last1 = min1; int last2 = min2;
            for (int j = 0; j < k; j++) {
                if (j != last1){
                    costs[i][j] += last1 <0 ? 0 : costs[i-1][last1];
                } else {
                    costs[i][j] += last2 <0 ? 0 : costs[i-1][last2];
                }


                if (min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                } else {
                    min2 = j;
                }
            }
        }
        return costs[n-1][min1];
    }

    public static void main(String[] args) {
        int[][] costs ={{1,0,3,4,5}};
        lc265(costs);
    }
}
