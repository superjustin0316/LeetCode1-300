package DynamicProgramming.summary.backBag;

public class backBag_multiple {
    /**
     *   多重背包问题  ABC的数量有限个
     * 1.转化为0，1背包
     * 2.进行个数限制：for (int k=0; k <= nums[i]; k++)
     */

    /**
     *   混合背包问题
     * for i  1 to N
     *      if 第i件物品 属于01背包
     *         zeroPack（C,N,Vi,Wi）
     * else if 第i件物品 属于完全背包
     *         completePack(C,N,Vi,Wi)
     * else if 第i件物品 属于多重背包
     *         multiplePack(C,N,Vi,Wi)
     */

    public int multipleBackBag(int[] weight, int[] value,int nums[],int C,int N){
        int[] memo = new int[C+1];
        for (int i = 0; i <= C; i++) {
            memo[i] = (i >= weight[0]) ? value[0] : 0;
        }
        for (int i = 1; i < N; i++) {
            //重量限制
            for (int j = C;j >= weight[i];j--){
                //个数限制
                for (int k  =0 ;k<=nums[i];k++){
                    if (j - k*weight[i] >= 0){
                        memo[j] = Math.max(memo[j],k*value[i]+memo[j-k*weight[i]]);
                    }
                }
            }
        }
        return memo[C];
    }
}
