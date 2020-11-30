package DynamicProgramming.summary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public static List<List<String >>wordBreak(String s, List<String> wordDict){
        List<List<String >> res = new ArrayList<>();
        helper(s,new HashSet<>(wordDict),0,res,new ArrayList<>());
        return res;
    }

    private static void  helper(String s, HashSet<String> wordDict, int index,List<List<String>> res,List<String> list){
        if (index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index+1; i <= s.length(); i++) {
             if (wordDict.contains(s.substring(index,i))){
                 list.add(s.substring(index,i));
                 helper(s,wordDict,i,res,list);
                  list.remove(list.size() - 1);
             }
        }

    }

    public static void main(String[] args) {
        List<String> wordDict = new LinkedList<>();
        wordDict.add("a"); wordDict.add("aa"); wordDict.add("bc");
        System.out.println(wordBreak("aaabc",wordDict));

    }

    /**
      记忆化搜索
      memo[index]  在wordDict中 是否 含有str从index到结尾
     */
    public boolean wordBreak2(String s, List<String> wordDict){
        return helper2(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }

    private boolean helper2(String s, HashSet<String> wordDict, int index, Boolean[] memo){
        if (index == s.length()){
            return true;
        }
        if (memo[index] != null){
            return memo[index];
        }
        for (int i = index+1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index,i))){
                if (helper2(s,wordDict,i,memo)) {
                    memo[index] = true;
                    return true;
                }
            }
        }
        memo[index] = false;
        return false;
    }

    //dp[j]是 str[0 - i]是否有效
    public boolean wordBreak3(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }

        }
        return dp[s.length()];
    }

}
