package Matrix;

public class lc74_240 {

    public boolean lc74(int[][] matrix, int target){
        /**
         * 二维数组的中间值定位坐标：
         * row = mid / col
         * col = mid % col
         */
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0, end = row * col - 1;
        while (begin <= end){
            int mid = (end+begin)/2;
            int value = matrix[mid / col][mid % col];
            if (value == target){
                return true;
            } else  if (value > target){
                begin = mid +1;
            } else if (value < target){
                end = mid -1;
            }
        }
        return false;
    }

    public boolean lc240(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        while (col >= 0 && row <= matrix.length - 1){
            if (target == matrix[row][col]){
                return  true;
            } else if (target < matrix[row][col]){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
