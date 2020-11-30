package Array.Counter1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class  lc239 {
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int[] nums;

    /**
     *处理前K个元素，初始化双向队列
     * @param i
     * @param k
     */

    public void clean_deque(int i, int k){
        if (!deq.isEmpty() && deq.getFirst() == i-k){
            deq.removeFirst();//检查头部元素的index是否在滑动窗口范围内
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();//???   i++
        }
    }

    public int[] solution1(int[] nums, int k){
        //边界条件
        int n = nums.length;
        if (n*k == 0) return new int[0];
        if (k == 1) return nums;
        //
        this.nums = nums;
        int max_idx = 0;

        for (int i = 0; i < k; i++) {
            clean_deque(i,k);
            deq.addLast(i);
            if (nums[i] > nums[max_idx]) max_idx = i;
        }

        int[] output = new int[n-k+1];
        output[0] = nums[max_idx];

        //output
        for (int i = k; i < n; i++) {
            clean_deque(i,k);
            deq.addLast(i);
            output[i-k+1] = nums[deq.getFirst()];
        }
        return output;
    }
}
