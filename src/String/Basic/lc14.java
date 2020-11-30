package String.Basic;

public class lc14 {

    public String solution1(String[] strs){//strs:
         if (strs == null || strs.length == 0){
             return "";
         }
         for (int i = 0; i < strs[0].length();i++){
             char c = strs[0].charAt(i);
             for (int j = 1; j < strs.length; j++) {
                 if (i == strs[j].length() || strs[j].charAt(i) != c){
                     return strs[0].substring(0,i);//判断是否结束：1.string已结束 2.不匹配
                 }
             }
         }
         return strs[0];//返回字符本身
    }

    //Binary Search
    public static String solution2(String[] strs){
        //边界条件
        if (strs == null || strs.length == 0){
            return "";
        }
        int minLen =Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int low = 1;
        int high = minLen;
        while (low <= high){
            int mid = (low + high)/2;
            if (isCommon(strs,mid)){
                low = mid + 1 ;
            } else {
                high = mid -1;
            }
        }
        return strs[0].substring(0,low-1);//想case   low,high 从1开始，表示长度，所以最后应该减一
    }

    private static boolean isCommon(String[] strs, int len){
        String string = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(string)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings= {"flower","flow","flight"};

        System.out.println(solution2(strings));
    }
}
