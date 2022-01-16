package lengthOfLastWord0058;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        // 最后一个单词的结尾的索引
        int j = n - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }

        int ans = 0;
        for (int i = j; i >= 0; i--) {
            // 碰到单词的结尾就结束
            if (s.charAt(i) == ' ') {
                break;
            }
            ans++;
        }
        return ans;
    }

    @Test
    public void test(){
        Assert.assertTrue( 3 == lengthOfLastWord("sdfasd sadfadsf aadf sdf   "));
    }
}
