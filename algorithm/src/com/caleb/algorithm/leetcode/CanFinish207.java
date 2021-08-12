package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author：hanzhigang
 * @Date : 2021/5/16 9:31 PM
 * 
 *       课程表
 * 
 *       你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * 
 *       在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites给出，
 * 
 *       其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * 
 *       例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 
 *       请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false
 */
public class CanFinish207 {

    /**
     * 拓扑问题 如果存在环问题，则说明不可以！！ 队列就可以解决
     * 
     * 深度优先遍历
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.set(i, new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            edges.get(i[0]).add(i[1]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int v) {
        // 重点
        visited[v] = 1;
        for (int nv : edges.get(v)) {
            if (visited[nv] == 0) {
                dfs(nv);
                if (!valid) {
                    return;
                }
            } else if (visited[nv] == 1) {
                valid = false;
                return;
            }
        }
        // 重点
        visited[v] = 2;
    }

    /**
     * 广度优先遍历
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> edges = new ArrayList<>();
        // 节点入度
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            edges.get(i[1]).add(i[0]);
            ++indeg[i[0]];
        }
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        int visitedCount = 0;
        while (!q.isEmpty()) {
            visitedCount++;
            int u = q.poll();
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return numCourses == visitedCount;
    }
}
