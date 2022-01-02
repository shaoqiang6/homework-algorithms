package perfectSquares0279;

import org.junit.Assert;
import org.junit.Test;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 */
public class Solution {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt == (int) sqrt) {
            return 1;
        }
        int []f = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 求 i的最少的完全平方数
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }


    @Test
    public void test() {
        double sqrt = Math.sqrt(4);
        Assert.assertTrue(sqrt == (int) sqrt);
        sqrt = Math.sqrt(3);
        Assert.assertFalse(sqrt == (int) sqrt);
        Assert.assertTrue(3 == numSquares(12));
        Assert.assertTrue(2 == numSquares(13));
    }
}
