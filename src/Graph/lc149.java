package Graph;

import java.util.HashMap;

public class lc149 {

    /**
     * 1.以两点确定一条直线，
     * 2.看直线上
     *
     * 斜率不存在的情况：
     * 1.在X轴
     * 2.相同点
     *
     * 3.精度问题
     */
    public static int lc149(int[][] points){
        if (points == null || points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        int res = 0;
        //选取一个点
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                        samePoint++;
                    }
                    if (points[i][0] == points[j][0]){
                        sameXAxis++;
                        continue;
                    }
                    int numerator = points[i][1] - points[j][1];
                    int denominator = points[i][0] - points[j][0];
                    int gcd = gcd(numerator,denominator);
                    String hashStr = (numerator/gcd) +"/"+(denominator/gcd);

                    map.put(hashStr,map.getOrDefault(hashStr,1)+1);

                    res = Math.max(res,map.get(hashStr) +samePoint);
                }
            }
            res = Math.max(res,sameXAxis+1);
        }
        return res;

    }
    private static int gcd(int a, int b){
        if (a==0) return b;
        return gcd(b%a,a);
    }

    public static void main(String[] args) {
        int[][] points={{1,1},{1,1},{1,1},{2,2},{3,3}};
        lc149(points);

    }
    
}
