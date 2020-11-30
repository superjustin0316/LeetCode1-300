package Design;

import java.util.HashMap;

public class lc288 {

    //首位字母缩写
    HashMap<String,String> map; //缩写 +正常单词
    public lc288(String[] dictionary){
        map = new HashMap<>();
        for (String s : dictionary){
            String key = getKey(s);
            if (map.containsKey(key)){
                if (!map.get(key).equals(s)){
                    map.put(key,"");//deer 与 door抵消
                }
            }else {
                map.put(key,s);
            }
        }

    }

    public boolean isUnique(String word){
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    private String getKey(String s){
        if (s.length() <= 2) return s;
        return s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
    }
}
