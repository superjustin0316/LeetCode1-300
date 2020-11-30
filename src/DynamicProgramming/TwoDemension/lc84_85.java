package DynamicProgramming.TwoDemension;

import java.util.Arrays;
import java.util.Stack;

public class lc84_85 {

    /**
     leetcode85暴力解法
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

    /**
     LeetCode85 DP ：
     left    从左到右 出现连续"1"的string的第一个坐标
     right   从右到左 出现连续"1"的string的最后一个坐标
     height  从上到下的高度
     res    （right - left）* height
     */
    public int lc85_1(char[][] matrix){
        int m = matrix.length;
        if (matrix == null || m ==0) return 0;
        int n  = matrix[0].length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    left[j] = Math.max(curLeft,left[j]);
                } else {
                    left[j] = 0;
                    curLeft = j+1;
                }
            }
            for (int j  = n-1; j>= 0; j--){
                if (matrix[i][j] == '1'){
                    right[j] = Math.max(curRight,right[j]);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j<n; j++){
                res = Math.max(res, (right[j] - left[j])*height[j]);
            }
        }
        return res;
    }

    //LeetCode85 Stack方法：与lc84题的解法思路类似 cspiration
    public int lc85_cspiration(char[][] matrix){
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n+1];
        height[n] = 0;
        int res = 0;

        for (int row = 0; row <matrix.length;row++){
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i< n+1; i++){
                if (i < n){
                    if (matrix[row][i] == '1'){
                        height[i]++;
                    } else height[i] = 0;
                }
                if (stack.isEmpty() || height[stack.peek()]<= height[i]){
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] < height[stack.peek()]){
                        int cur = height[stack.peek()] * (stack.isEmpty() ? i : (i-stack.peek()-1));
                        res = Math.max(res,cur);
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }

    //LeetCode85 Stack方法：直接调用LeetCode84
    public int lc85_3(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < heights.length) {
            //栈空入栈
            if (stack.isEmpty()) {
                stack.push(p);
                p++;
            } else {
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if (heights[p] >= heights[top]) {
                    stack.push(p);
                    p++;
                } else {
                    //保存栈顶高度
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = p;
                    //计算面积
                    int area = (RightLessMin - leftLessMin - 1) * height;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        while (!stack.isEmpty()) {
            //保存栈顶高度
            int height = heights[stack.pop()];
            //左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
            int RightLessMin = heights.length;
            int area = (RightLessMin - leftLessMin - 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }


    /**
     Leetcode 84
     */
    //暴力解法：
    public int lc84(int[] heights){
        int res = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int left_i = i;
            int right_i = i;
            while (left_i >= 0 && heights[left_i] >= heights[i]){
                left_i--;
            }
            while (right_i < n && heights[right_i] >= heights[i]){
                right_i++;
            }
            res = Math.max(res, (right_i - left_i - 1) * heights[i]);
        }
        return res;
    }

    //stack方法(cspiration):
    public int lc84_1(int[] heights){
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i-start-1);
                res = Math.max(res,area);
            }
            stack.push(i);
        }
        return res;
    }
}
