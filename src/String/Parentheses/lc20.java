package String.Parentheses;

import java.util.Stack;

public class lc20 {
    /**
     * 使用stack 先进后出
     */
    public boolean lc20(String s){
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()){
            if (ch == '('){
                stack.push(')');
            } else if (ch == '['){
                stack.push(']');
            } else if (ch == '{'){
                stack.push('}');
            } else {
                // 说明 "([{" 已经结束
                if (stack.isEmpty() || stack.pop() != ch){
                    return  false;
                }
            }
        }
        return stack.isEmpty();
    }

}
