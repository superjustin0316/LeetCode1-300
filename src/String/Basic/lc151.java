package String.Basic;

public class lc151 {

    public String lc151(String s){
        if (s == null || s.length() <2){
            return s;
        }
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}
