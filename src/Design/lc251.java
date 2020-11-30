package Design;

import java.util.List;

public class lc251 {
    int indexList,indexElemet;
    List<List<Integer>> list;

    public lc251(List<List<Integer>> vec2d){
        indexElemet =0;
        indexList = 0;
        list= vec2d;
    }

    public Integer next(){
        return list.get(indexList).get(indexElemet++);
    }

    public boolean hasNext(){
        while (indexList < list.size()){
            if (indexElemet < list.get(indexList).size()){
                return true;
            }else {
                indexList++;
                indexElemet = 0;
            }
        }
        return false;
    }
}
