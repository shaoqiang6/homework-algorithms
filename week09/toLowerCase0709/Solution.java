package toLowerCase0709;

import org.junit.Assert;
import org.junit.Test;

/**
 * 709. 转换成小写字母
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello"
 * 输出："hello"
 * 示例 2：
 *
 * 输入：s = "here"
 * 输出："here"
 * 示例 3：
 *
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 */
public class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char cc = c;
            if (c >= 'A' && c <= 'Z') {
                cc = (char)(c - 'A' + 'a');
            }
            sb.append(cc);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("hello", toLowerCase("Hello"));
        Assert.assertEquals("lovely", toLowerCase("LOVELY"));

    }
}
