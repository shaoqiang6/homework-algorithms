package implementStrstr0028;

import org.junit.Assert;
import org.junit.Test;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author shaoqiangyan
 */
public class Solution {
    /**
     * rabin-karp 算法 实现 string.indexOf()
     * 字符串的hash值算法: 将字符看做是 b进制的数字, 然后计算他转换成10进制之后对 P 取模
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        long[] preHash = new long[n + 1];
        long b = 131;
        long p = (long)(1e9 + 7);
        for (int i = 1; i <= n; i++) {
            preHash[i] = (preHash[i - 1] * b + (haystack.charAt(i - 1) - 'a' + 1))%p;
        }
        long needleHash = 0;
        // power(b,m);
        long powerBM = 1;
        for (int j = 1; j <= m; j++) {
            needleHash = (needleHash * b +  (needle.charAt(j - 1) - 'a' + 1))%p;
            // 及时 %p 保证不越界
            powerBM = powerBM * b % p;
        }

        for (int l = 1; l <= n - m + 1; l++) {
            int r = l + m - 1;
            // 求l~r 的hash
            long hLR = ((preHash[r] - preHash[l - 1] * powerBM)%p+ p) %p;
            if (hLR == needleHash) {
                return l - 1;
            }
        }
        return -1;
    }
    @Test
    public void test() {
        String haystack = "aabaaabaaac",
        needle = "aabaaac";
        int i = strStr(haystack, needle);
        Assert.assertEquals(i, 4);
        haystack = "hello";
        needle = "ll";
        Assert.assertTrue(2 == strStr(haystack, needle));
    }
}
