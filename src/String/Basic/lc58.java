package String.Basic;

public class lc58 {
    public int lc58(String s){
        String[] strings =s.split(" ");//分割成字符数组
        if (strings.length == 0) return 0;
        return strings[strings.length - 1].length();
    }
}
