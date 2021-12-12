package nQueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 9
 */
public class Solution {

    List<List<Integer>> ans = null;
    List<Integer> item = null;
    boolean[] colUsed = null;
    Set<Integer> usedPlus = new HashSet<>();
    Set<Integer> usedMinus = new HashSet<>();
    int n = 0;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        this.n = n;
        item = new ArrayList<>();
        colUsed = new boolean[n];
        dfs(0);
//        System.out.println(ans);
        List<List<String>> result = new ArrayList<>(ans.size());
        for(List<Integer> list : ans) {
            List<String> rowList = new ArrayList<>();
            for (Integer colValue : list) {
                StringBuilder rowBuilder = new StringBuilder(n);
                for (int currentCol = 0; currentCol < n; currentCol++) {
                    if (colValue == currentCol) {
                        rowBuilder.append("Q");
                    } else {
                        rowBuilder.append(".");
                    }
                }
                rowList.add(rowBuilder.toString());
            }
            result.add(rowList);
        }
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for(int col = 0; col < n; col++) {
            if (colUsed[col] || usedPlus.contains(col + row) || usedMinus.contains(row - col)) {
                continue;
            }
            colUsed[col] = true;
            usedPlus.add(col + row);
            usedMinus.add(row - col);
            item.add(col);
            dfs(row + 1);
            item.remove(item.size() - 1);
            usedMinus.remove(row - col);
            usedPlus.remove(col + row);
            colUsed[col] = false;
        }
    }

    @Test
    public void test() {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);

    }

}
