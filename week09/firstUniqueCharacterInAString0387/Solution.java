package firstUniqueCharacterInAString0387;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
