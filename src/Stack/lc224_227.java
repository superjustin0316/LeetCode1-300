package Stack;

import java.util.Stack;

public class lc224_227 {

    public int lc224(String s){
        /**
         * '+'  '-'  '(' ')'
         */
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i <s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) -'0';
                while (i+1 <s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                res = res + num * sign;
             } else if (s.charAt(i) == '+'){
                sign = 1;
            } else  if (s.charAt(i) == '-'){
                sign = -1;
            } else if (s.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) ==')'){
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

    /**
     * '+' '-' '*' '/'
     */
    public int lc227(String s){
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            //顺序 非-->与&&-->或||   消除 空格
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '|| i == s.length() - 1){
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int i : stack){
            res += i;
        }
        return res;
    }

    /**
     *法二
     */
    public int lc227_2(String s){
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" +","");
        int res = 0;
        int preVal = 0;
        int i = 0;
        char sign = '+';
        while (i < s.length()){
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))){
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+'){
                res += preVal;
                preVal = curVal;
            } else  if (sign == '-'){
                res += preVal;
                preVal = -curVal;
            } else if (sign =='*'){
                preVal = preVal*curVal;
            }else if (sign=='/'){
                preVal = preVal/curVal;
            }
            if (i<s.length()){
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }


}
