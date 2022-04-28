package generateparentheses0022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * @author shaoqiangyan
 */
public class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recur("", 0, 0, n);
        return ans;
    }

    private void recur(String sb, int left, int right, int n) {
        System.out.println(sb+ ", l=" + left + ", r=" + right );
        if (left == n && right == n) {
            ans.add(sb);
            System.out.println("---------------");
            return;
        }
        if (left < n) {
            recur(sb+ "(", left + 1, right, n);
        }
        if (left > right) {
            recur(sb + ")", left, right + 1, n);
        }
    }

    @Test
    public void test() {
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);

    }

}
