package TopoSort;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class lc269 {

    //O(V+E)   O(n)->0(26)->O(1)
    //图 --> 入度为0 --> BFS
    public static  String lc269(String[] words){
        if (words == null || words.length == 0) return "";

        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int count = 0;

        //统计出现的字母
        for (String word : words){
            for (char c : word.toCharArray()){
                if (degree[c - 'a'] == 0){
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }

        //构造图+入度  cur--起点，next--终点
        for (int i = 0; i < words.length - 1; i++ ){
            char[] cur = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();
            int len = Math.min(cur.length,next.length);
            for (int j = 0; j < len; j++){
                if (cur[j] != next[j]){
                    if (!map.containsKey(cur[j])){
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])){
                        degree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }

        //统计入度
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1){
                queue.offer((char)('a'+1));
            }
        }
        while (!queue.isEmpty()){
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)){
                for (char ch : map.get(c)){
                    degree[ch-'a']--;
                    if (degree[ch-'a'] == 1){
                        queue.offer(ch);
                    }
                }
            }
        }
        if (res.length() != count) return "";
        return res.toString();


    }
}
