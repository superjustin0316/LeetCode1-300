package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc170 {
    /**
     * 法一
     */
    private HashMap<Integer,Integer> map;//  number__次数
    public lc170(){
        map = new HashMap<>();
    }
    public void add(int number){
        if (!map.containsKey(number)){
            map.put(number,1 );
        } else {
            map.put(number,map.get(number)+1);
        }
    }
    public boolean find(int value){
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int i = entry.getKey();
            int j = value - i ;
            if ((i == j && entry.getValue()>1) || (i != j && map.containsKey(j))){
                //1.和 分为 两个相同元素
                //2.和 分为 两个不同元素
                return true;
            }
        }
        return false;
    }

    /**
     * 法二
     */
    private List<Integer> list;
    public void twoSum(){
        map = new HashMap<>();//key:number  value:出现次数
        list = new ArrayList<>();//出现过的number
    }
    public void add2(int number){
        if (!map.containsKey(number)){
            map.put(number,1);
            list.add(number);
        } else {
            map.put(number,map.get(number)+1);
        }
    }

    public boolean find2(int value){
        for (Integer num1 : list){
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num2) >1)||(num1 != num2 && map.get(num2) >0)){
                return true;
            }
        }
        return false;
    }

}
