package combinations0077;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Solution {

    List<Integer> per = new ArrayList<>();
    List<List<Integer>> ans;
    int k = 0;
    int n = 0;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        this.n = n + 1;
        this.k = k;
        dfs(1);
        return ans;
    }

    private void dfs(int x) {
        if (per.size() > k || (per.size() + (n - x + 1)) < k) {
            return;
        }
        if (x == n) {
            if (per.size() == k) {
                ans.add(new ArrayList<>(per));
            }
            return;
        }
        dfs(x+1);
        System.out.println(x + ", per: " +per);
        per.add(x);
        dfs(x+1);
        per.remove(per.size() - 1);

    }

    @Test
    public void test() {

        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }

}
