package Matrix;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class lc54 {

    public static List<Integer> lc54(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        //纵向 == null，横向 == null
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix.length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd){
            //1.向右 row不变，col变化
            for (int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //2.向下 row变化，col不变
            for (int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            //3.向左 row不变，col变化
            for (int i = colEnd; i >= colBegin;i--){
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            //4.向上 row变化，col不变
            for (int i= rowEnd; i>= rowBegin; i--){
                res.add(matrix[i][colBegin]);
            }
            colBegin++;

//            //3.向左 row不变，col变化
//            // 但是rowBegin,colEnd的值变化了，不一定满足while的条件
//            if (rowBegin <= rowEnd){
//                for (int i = colEnd;i >= colBegin;i--){
//                    res.add(matrix[rowEnd][i]);
//                }
//                rowEnd--;
//            }
//            //4.向上 row变化，col不变
//            if (colBegin <= colEnd){
//                for (int i= rowEnd;i>= rowBegin; i--){
//                    res.add(matrix[i][colBegin]);
//                }
//                colBegin++;
//            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(lc54(matrix).toString());
    }

}
