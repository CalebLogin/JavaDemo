package com.caleb.main;
/**
 * @author：hanzhigang
 * @Date : 2021/4/19 7:12 PM
 */
public class Main5 {
    public static void main(String[] args) {
        Main5 m = new Main5();
        System.out.println(m.minimumInitHealth(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } },
                new int[] { 0, 0 }, new int[] { 2, 2 }));
    }

    public int petalsBreak(int[] petals) {
        int count = 0;
        for (int i = 0; i < petals.length; i++) {
            if (petals[i] != 0) {
                count += petals[i] / 2 + petals[i] % 2;
            }
        }
        return count;
    }

    boolean[][] visited;
    int minValue = Integer.MAX_VALUE;
    int[] pos = new int[] { -1, 1 };

    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        if (startPoint[0] == endPoint[0] && startPoint[1] == endPoint[1]) {
            return 1;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        visited = new boolean[row][col];
        visited[startPoint[0]][startPoint[1]] = true;
        int startNum = rooms[startPoint[0]][startPoint[1]] > 0 ? 1 : 1 - rooms[startPoint[0]][startPoint[1]];
        dfs(rooms, startPoint[0], startPoint[1], endPoint, startNum, 1);
        return minValue;
    }

    private void dfs(int[][] rooms, int i, int j, int[] endPoint, int val, int finalval) {
        if (i == endPoint[0] && j == endPoint[1]) {
            minValue = Math.min(minValue, val);
            return;
        }
        for (int m = 0; m < 2; m++) {
            int r = i + pos[m];
            if (r < rooms.length && r >= 0 && !visited[r][j]) {
                visited[r][j] = true;
                if (finalval + rooms[r][j] < 0) {
                    dfs(rooms, r, j, endPoint, val - finalval - rooms[r][j] + 1, 1);
                } else if (finalval + rooms[r][j] > 0) {
                    dfs(rooms, r, j, endPoint, val, finalval + rooms[r][j]);
                } else {
                    dfs(rooms, r, j, endPoint, val + 1, 1);
                }
                visited[r][j] = false;
            }
            int c = j + pos[m];
            if (c < rooms[i].length && c >= 0 && !visited[i][c]) {
                visited[i][c] = true;
                if (finalval + rooms[i][c] < 0) {
                    dfs(rooms, i, c, endPoint, val - finalval - rooms[i][c] + 1, 1);
                } else if (finalval + rooms[i][c] > 0) {
                    dfs(rooms, i, c, endPoint, val, finalval + rooms[i][c]);
                } else {
                    dfs(rooms, i, c, endPoint, val + 1, 1);
                }
                visited[i][c] = false;
            }
        }
    }
}
