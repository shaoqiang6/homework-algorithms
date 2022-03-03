package sortArrayByParity0905;

import org.junit.Test;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * @author shaoqiangyan
 */
public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int t = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                ans[t++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) {
                ans[t++] = nums[i];
            }
        }


        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,1,2,4,1,5};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
