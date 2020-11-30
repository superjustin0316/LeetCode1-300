package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class stringlc241 {

    public List<Integer> diffwaysToCompute(String input){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
             char c= input.charAt(i);
             if (c == '-'|| c =='+'|| c=='*'){
                 String a = input.substring(0,i);//存c之前的数字
                 String b = input.substring(i+1);//存 c之后 + 结尾 的数字
                 List<Integer> al = diffwaysToCompute(a);
                 List<Integer> bl = diffwaysToCompute(b);
                 for(int x : al){
                     for (int y : bl){
                         if (c == '-'){
                             res.add(x - y);
                         } else if (c == '+'){
                             res.add(x + y);
                         } else if (c == '*'){
                             res.add(x * y);
                         }
                     }
                 }
             }
        }
        if (res.size() == 0){//说明式子只有一个数，无符号
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
