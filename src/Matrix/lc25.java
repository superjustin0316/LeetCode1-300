package Matrix;

public class lc25 {
    public void rotate(int[][] matrix){
        //O(n*m)  O(1)
        // 对角线交换
        for (int i = 0; i < matrix.length;i++){
            for (int j =0; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix [j][i];
                matrix[j][i] = temp;
            }
        }
        //水平轴翻转
        for (int i = 0; i<matrix.length;i++){
            for (int j =0; j < matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 -j];
                matrix[i][matrix.length - 1 -j] = temp;
            }

        }
    }
}
