package letterCombinationsOfAPhoneNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Solution {

    List<String> ans = null;
    String digits = null;
    Map<Character, String> map = null;
    StringBuilder str = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>(0);
        }
        ans = new ArrayList<>();
        this.digits = digits;
        this.initMap();
        this.dfs(0);
        return ans;

    }


    private void dfs(int index) {
        // break;
        if (index >= digits.length()) {
            ans.add(str.toString());
            return;
        }
        String ss = map.get(digits.charAt(index));
        for(int i = 0; i < ss.length(); i++) {
            str.append(ss.charAt(i));
//            System.out.println(str);
            dfs(index + 1);
//            System.out.println(index);
            str.deleteCharAt(index);
        }
    }

    private void initMap() {
        map = new HashMap<>(8);
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    @Test
    public void test() {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

}
