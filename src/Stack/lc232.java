package Stack;

import java.util.Stack;

public class lc232 {
    /**
     * s1 没有进行处理的stack（queue的反方向）
     * s2 处理过的stack，和queue的方向是一样的
     */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public lc232(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x){
        s1.push(x);
    }

    //O(n)
    public int pop(){
        if (!s2.isEmpty()) return s2.pop();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
    }
    //O(n)
    public int peek(){
        if (!s2.isEmpty()) return s2.peek();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        }
    }

    public boolean empty(){
        return s1.isEmpty()&&s2.isEmpty();
    }

    /**
     * 法2
     * s1 没有进行处理的stack（queue的反方向）
     * s2 处理过的stack，和queue的方向是一样的
     */

    public class lc232_2{
        Stack<Integer> s1;
        Stack<Integer> s2;
        private int front;
        public lc232_2(){
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x){
            if (s1.isEmpty()){
                front =x;
            }
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s2.push(x);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int pop(){
            int res = s1.pop();
            if (!s1.isEmpty()){
                front = s1.peek();
            }
            return res;
        }

        public int peek(){
            return front;
        }

        public boolean empty(){
            return s1.isEmpty();
        }
    }

}
