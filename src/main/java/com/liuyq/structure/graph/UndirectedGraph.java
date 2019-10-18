package com.liuyq.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liuyq on 2019/10/15.
 * 无向图
 * 图的存储通常有两种方式存储： 邻接矩阵   邻接表
 */
public class UndirectedGraph {

    private int n; //顶点个数
    private LinkedList<Integer> abj[]; //邻接表

    public UndirectedGraph(Integer n) {
        this.n = n;
        abj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            abj[i] = new LinkedList<>();
        }
    }

    /**
     * a -- b  存储两个顶点链接
     *
     * @param a
     * @param b
     */
    public void add(Integer a, Integer b) {
        abj[a].add(b);
        abj[b].add(a);
    }


    //广度优先算法
    //s 为起始顶点 t为终止顶点
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[n]; //标记被访问的顶点
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[n];
        for (int i = 0; i < n; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < abj[w].size(); ++i) {
                int q = abj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


}
