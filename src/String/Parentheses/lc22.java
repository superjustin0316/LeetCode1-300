package String.Parentheses;

import java.util.ArrayList;
import java.util.List;

public class lc22 {

    public static List<String> lc22(int n){//n个括号对
        List<String> res = new ArrayList<>();//1.return 的结果
        if (n == 0) return null;//2.
        helper(res,"", n,n);//4. 初始情况
        return res;
    }

    public static void helper(List<String> res, String s, int left, int right){//3.
//        System.out.println("s:"+s+" left:" +left +" right：" + right);
        // left -> 剩余的括号数， right -> 剩余的括号数
        if(left > right) return;//确保先加左边
        if (left == 0 && right == 0){//5.结束条件
            res.add(s);
//            System.out.println("add"+s);
//            System.out.println();
            return;
        }
        if (left > 0){
            helper(res,s+"(",left-1,right);
            //System.out.println("s:"+s+" left:" +left +" right：" + right);
        }
        if (right > 0){
            helper(res,s +")",left,right-1);
            //System.out.println("s:"+s+" left:" +left +" right：" + right);
        }
    }

    public static void main(String[] args) {
        List<String> res =  lc22(3);
        System.out.println(res);


    }


}
