package Array.Basic;

public class lc42 {
    public int trap(int[] height){
//        int leftIndex = 0;
//        int rightIndex = height.length-1;
//        int res = 0;
//        int leftMax = 0;
//        int rightMax = 0;
//
//        while (leftIndex < rightIndex){
//            if (height[leftIndex] < height[rightIndex]){
//                leftMax = Math.max(height[leftIndex], leftMax);
//                res += leftMax - height[leftIndex];
//                leftIndex ++;
//            } else {
//                rightMax = Math.max(height[rightIndex], rightMax);
//                res += rightMax - height[rightIndex];
//                rightIndex--;
//            }
//        }
//        return res;

        int sum = 0;
        //两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                max_left=Math.max(max_left,height[j]);
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                max_right=Math.max(max_right,height[j]);
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;



    }


}
