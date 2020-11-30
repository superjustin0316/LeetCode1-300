package String.Basic;

public class lc28 {
    public int lc28(String haystack, String needle){
        if (needle == null || needle.length() == 0){
            return 0;
        }

        for (int i = 0; i < haystack.length();i++){
            if(i + needle.length() > haystack.length()){
                break;// 优化剩下字符长度不一致
            }
            for (int j = 0; j <needle.length(); j++){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                if (j == needle.length() - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}
