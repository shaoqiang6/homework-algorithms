package subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        // s[0] = 0; s[1] = s[0] + nums[0]
        int [] s = new int[n+1];
        s[0] = 0;
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            // System.out.print(s[i]);
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(n+1);
        for (int i = 0; i < n+1; i++) {
            if (map.containsKey(s[i] - k)) {
                ans += map.get(s[i] - k);
            }
            // int count = 1;
            if (map.containsKey(s[i])) {
                int count = map.get(s[i]);
                map.put(s[i], ++count);
            } else {
                map.put(s[i], 1);
            }

        }
        return ans;
    }

}
