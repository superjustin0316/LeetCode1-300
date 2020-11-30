package String.Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc249 {
    public List<List<String>> lc249(String[] strings){

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            String key = getKey(s);
            List<String > list = map.getOrDefault(key, new ArrayList<>());//?
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s){
        char[] chars = s.toCharArray();
        String key ="";//初始为空值
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            key += diff< 0 ? diff + 26 : diff;
            key +=",";
        }
        return key;
    }
}
