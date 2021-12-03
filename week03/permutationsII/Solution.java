package permutationsII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * @author shaoqiangyan
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> a = new ArrayList<>();
    boolean[] used = null;
    int n = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        // 排序将相同的数字搞到一起, 在组合的时候判断数字是否使用过
        Arrays.sort(nums);
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        if (pos == n) {
            ans.add(new ArrayList<>(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            //
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            a.add(nums[i]);
            used[i] = true;
            recur(nums, pos + 1);
            used[i] = false;
            a.remove(a.size() - 1);

        }
    }

    @Test
    public void test() {
        int[] nums = {3,3,0,3};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }
}
