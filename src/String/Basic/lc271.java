package String.Basic;

import java.util.ArrayList;
import java.util.List;

public class lc271 {
    //Encode
    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length()).append("/").append(str);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String s){
        List<String> res =new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int slash = s.indexOf('/',i);//indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
            int size = Integer.valueOf(s.substring(i,slash));
            res.add(s.substring(slash+1,size+1+slash));
            i = slash+size+1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
