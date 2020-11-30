package DynamicProgramming.OneDemension;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc279 {

    /**
     动态规划
     num[n] = min(num[n],num[n-i*i]+1)
     */
    public static int lc279_1(int n){
        int[] res = new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i-j*j]+1);
             }
        }
        return res[n];
    }

    /**
     * BFS
     */
    public static int lc279_2(int n){
        int[] nums = new int[n+1];
        Arrays.fill(nums,-1);
        nums[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 1; i*i+cur <=n;i++){
                if (nums[i*i+cur] == -1){
                    nums[i*i+cur] = nums[cur] + 1;
                    queue.offer(i*i+cur);
                }
            }
        }
        return nums[n];

    }


    public static void main(String[] args) {
        lc279_2(12);
    }
}
