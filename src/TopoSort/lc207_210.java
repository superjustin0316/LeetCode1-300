package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class lc207_210 {

    //数据 -> 图 -> 入度  ->BFS
    public boolean lc207(int numCourses, int[][] prerequisites){

        int[] indegree = new int[numCourses];
        int res = numCourses;

        //入度
        for (int[] pair : prerequisites){
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            res--;//剩余课程的个数
            for (int[] pair : prerequisites){
                if (pair[1] == pre){
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] ==0){
                        queue.offer(pair[0]);
                    }

                }
            }
        }
        return res == 0;//queue为空 --> 没有入度为0的点 --> 有环路
    }


    public int[] lc210(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            if (indegree[i] ==0){
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            for (int[] pair : prerequisites){
                if (pair[1] == pre){
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0){
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return k == numCourses ? res : new int[0];
    }
}
