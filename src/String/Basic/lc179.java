package String.Basic;

import java.lang.reflect.Array;
import java.util.*;

public class lc179 {

    public String lc179(int[] nums){
        if (nums == null || nums.length == 0){
            return "";
        }
        String[]  res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res,new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2 ;
                String s2 = str2 + str1;
                return  s2.compareTo(s1);
            }
        });


        if (res[0].charAt(0) == '0'){
            return "0";
        }
        StringBuilder sb= new StringBuilder();
        for (String s: res){
            sb.append(s);
        }
        return sb.toString();
    }
}
