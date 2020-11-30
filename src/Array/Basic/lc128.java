package Array.Basic;

import java.util.HashSet;

public class lc128 {
    public int solution1(int[] nums){

        if (nums == null || nums.length == 0) return 0;//数组不存在，数组为空
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int down;
        int up;
        int length =0;
        for(int i = 0; i< nums.length; i++){
            down = up = nums[i];
            while (set.contains(down-1)){
                set.remove(down-1);//提升效率，避免重复访问
                down--;
            }
            while (set.contains(up+1)){
                set.remove(up+1);//提升效率，避免重复访问
                up++;
            }
            length=Math.max(length, up - down +1);
        }
        return length;
    }


}
