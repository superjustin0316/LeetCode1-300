package String.Parentheses;

import java.util.Stack;

public class lc32 {
    //O(n) O(n)
    public int lc32(String s){
        Stack<Integer> stack = new Stack<>();//存放起点
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                if (stack.isEmpty()){
                    start = i;//start为起点前一位
                } else {
                    stack.pop();
                    if (stack.isEmpty()){
                        res = Math.max(res, i - start);
                    }else {
                        res = Math.max(res, i -stack.peek());
                    }
                }
            }
            
        }
        return res;
        
    }
}
