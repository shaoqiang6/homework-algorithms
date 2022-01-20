package partitionEqualSubsetSum0416;

import org.junit.Test;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @author shaoqiangyan
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int [] nums2 = new int[n + 1];
        nums2[0] = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            nums2[i + 1] = nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int targetSum = sum / 2;
        boolean [] f = new boolean[targetSum + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = targetSum; j >= nums2[i]; j--) {
                f[j] |= f[j - nums2[i]];
            }
            if (f[targetSum]) {
                return true;
            }
//            System.out.println(i + ";  " + Arrays.toString(f));
        }
        return f[targetSum];

    }

    @Test
    public void test() {
        int[] things = new int[]{100,10,40,50};
        boolean b = canPartition(things);
        System.out.println(b);

    }
}
