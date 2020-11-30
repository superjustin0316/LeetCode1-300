package Array.Basic;

import java.util.ArrayList;
import java.util.List;

public class lc118_119 {

    public List<List<Integer>> lc118(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
             list.add(0,1);
            for (int j = 1; j < list.size()-1; j++) {
                 list.set(j,list.get(j) + list.get(j+1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public List<Integer> lc119(int rowIndex){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0,1);
            for (int j = 0; j < res.size()-1; j++) {
                res.set(j,res.get(j) + res.get(j+1));
            }
        }
        return res;
    }
}
