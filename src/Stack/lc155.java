package Stack;

import java.util.Stack;

public class lc155 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public lc155(){
        stack = new Stack<>();
        minStack = new Stack<>();//保存最小的元素
    }

    public void push(int x){//入栈
        stack.push(x);
        if (!minStack.isEmpty()){
            int min = minStack.peek();
            if (x <= min){
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop(){
        int x = stack.pop();
        if (!minStack.isEmpty()){
            if (x == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    /**
     * 法2
     * 对于一个stack，
     * 对于小值：1.push之前的最小值，2.push加入的元素
     * 对于正常值： 正常加入
     * Integer：在-127-128之间能正常比较，其余不能正常比较
     */
    public class MinStack2{
        Stack<Integer> stack;
        private int min;

        public MinStack2(){
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x){
            if (x <= min){
                stack.push(min);
                min =x;
            }
            stack.push(x);
        }

        public void pop(){
            if (stack.peek() == min){
                stack.pop();
                min = stack.pop();
            }
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return min;
        }
    }
}


