package numberOfIslands0200;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author shaoqiangyan
 */
public class Solution {
    int m = 0;
    int n = 0;
    boolean [][]visited = null;
    char[][] grid = null;
    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    // 每次把所有的可到达的 '1' 都访问一遍, 标记为已经访问
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(int sx, int sy) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        queue.push(new Pair<>(sx, sy));
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.pop();
            int x = p.getKey();
            int y = p.getValue();
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx>=m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] != '1') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                queue.push(new Pair<>(nx, ny));
                visited[nx][ny] = true;
            }

        }
    }

    @Test
    public void test() {
//        char [][] gridTest = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        char [][] gridTest = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(gridTest);
        System.out.println(i);

    }
}
