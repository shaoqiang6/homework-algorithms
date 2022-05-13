package surroundedRegions0130;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
 * 输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [['X']]
 * 输出：[['X']]
 *
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @author shaoqiangyan
 */
public class Solution {
    /**
     * 1. 在边缘上进行每个 O 节点的深度优先遍历,然后把这写可以关联到的 O 都改为A
     * 2. 遍历所有区域,将'O'改为 'Z', A改为 O
     * @param board
     */
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 'O' -> 'A' start
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, j, 0);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        // 'O' -> 'A' end
        // 'O'-> 'X' start
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }



    }
    int [] dx = {-1, 0, 0, 1};
    int [] dy = {0, -1, 1, 0};

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y <= 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        for (int i = 0; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i]);
        }
    }
    
    @Test
    public void test() {
        char[][] board = {{'X','X','X','O'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
        System.out.println("----------------");
        solve(board);
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
    }

}
