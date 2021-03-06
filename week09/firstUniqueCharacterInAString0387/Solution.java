package firstUniqueCharacterInAString0387;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Solution {

    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String s = "aabb";
        Assert.assertTrue(-1 == firstUniqChar(s));
        s = "loveleetcode";
        Assert.assertTrue(2 == firstUniqChar(s));
    }
}
