package Stack;

import java.util.Stack;

public class lc150 {

    public int lc150(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if (s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.parseInt(s));//类型转换string->int
            }
        }
        return stack.pop();

    }
}
