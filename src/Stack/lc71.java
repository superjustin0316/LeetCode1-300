package Stack;

import java.util.Stack;

//O(n) O(n)
public class lc71 {
    public String lc71(String path){
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");

        for (String s : paths){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res = "/"+stack.pop()+res;
        }
        if (res.length() == 0){
            return "/";
        }
        return res;
    }
}
