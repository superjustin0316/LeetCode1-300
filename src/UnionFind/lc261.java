package UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc261 {

    //树 --> 判断是否有环
    public boolean lc261(int n , int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        //初始化起点
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        //无向图
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);//从0开始

        boolean res = helper(graph,visited,0,-1);
        if (res == false) return false;
        return visited.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited,int node, int parent){
        List<Integer> sub = graph.get(node);
        for (int v : sub){
            if (v == parent) continue;//无向图会重复
            if (visited.contains(v)) return false;
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (res == false) return false;
        }
        return true;
    }

    //UnionFind
    public boolean lc261_2(int n , int[][] edges){
        if (n == 1 && edges.length == 0) return true;
        if (n < 1 || edges == null || edges.length != n-1) return false;

        int[] roots = new int[n];
        for (int i = 0; i< n; i++){
            roots[i] = -1;
        }

        for (int[] pair : edges){
            int x = find(roots,pair[0]);
            int y = find(roots,pair[1]);
            if (x == y) return false;
            roots[x] = y;
        }
        return true;
    }

    private int find(int[] roots, int i){
        while (roots[i] != -1){
            i = roots[i];
        }
        return i;
    }




}
