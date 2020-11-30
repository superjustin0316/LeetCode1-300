package DynamicProgramming.Simplified;

public class lc44 {
    public boolean isMatch(String s, String p){
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp <s.length()){
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp)=='?')){
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) =='*'){
                ////记录如果之后序列匹配不成功时， sp和pp需要回溯到的位置
                match = sp;//记录星号
                star = pp;
                pp++;//记录星号 并且pp移到下一位 准备下个循环s[sp]和p[pp]的匹配
            } else if (star != -1){
                //发现字符不匹配且没有星号出现 但是istar>0 说明可能是*匹配的字符数量不对 这时回溯
                pp = star +1;//i回溯到istar+1 因为上次从s串istar开始对*的尝试匹配已经被证明是不成功的（不然不会落入此分支） 所以需要从istar+1再开始试 同时inc istar 更新回溯位置
                match ++;
                sp = match;//j回溯到jstar+1 重新使用p串*后的部分开始对s串istar（这个istar在上一行已经inc过了）位置及之后字符的匹配
            } else return false;
        }
        //去除多余星号
        while (pp < p.length() && p.charAt(pp) =='*'){
            pp++;
        }
        return pp == p.length();
    }
}
