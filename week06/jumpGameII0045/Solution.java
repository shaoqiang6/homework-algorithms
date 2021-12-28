package jumpGameII0045;

import org.junit.Assert;
import org.junit.Test;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * @author shaoqiangyan
 */
public class Solution {
    public int jump(int[] nums) {

        int now = 0;
        int len = nums.length;
        int ans = 0;
        while(now < len - 1) {
            // 本次可以到达的最远索引
            int right = now + nums[now];
            if (right >= len - 1) {
                return ans + 1;
            }
            // 下一个索引位置
            int nextRight = right;
            // 下一个索引
            int next = now + 1;
            // 选出最好的下一个索引 跳跃
            for (int i = now + 1; i <= right; i++) {
                if (nums[i] + i > nextRight) {
                    nextRight = nums[i] + i;
                    next = i;
                }
            }
            now = next;
            ans++;

        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        int jump = jump(nums);
        Assert.assertTrue(jump == 2);
    }
}
