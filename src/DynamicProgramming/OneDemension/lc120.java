package DynamicProgramming.OneDemension;

import java.util.List;

public class lc120{
    /**
     DP: 起点 -> 终点
     以最上层的点为终点
     
     当前元素（i，j），则 下一层相邻的元素是（i+1,j）（i+1,j+1）
     */
    public int lc120(List<List<Integer>> triangle){
        //triangle.size()+1 --> 防止越界，元素需要两两比较
        int[] res = new int[triangle.size()+1];
        //从下到上扫描
        for (int i = triangle.size() -1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j],res[j+1])+triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
