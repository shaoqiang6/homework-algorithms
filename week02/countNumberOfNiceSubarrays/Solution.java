package countNumberOfNiceSubarrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Solution {

    public int numberOfSubArrays(int[] nums, int k) {
        // nums[i]%2 偶数为0，奇数为1
        // 子段和为k的数量,
        // 求出nums1中子段为k的数量
        // sum(l, r) == k == sum(r) -sum(l-1)
        // sum(r) -sum(l-1)
        int [] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1]%2;
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i] + ",");
        }
        // 方案1 ======== O(n平方) 判断前缀之差为k
        // int sum[] = 0,1,2,2,3,4
        // k = 3
        int ans = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    ans+=1;
                }
            }
        }
        // 方案2==========
        //
        int ans2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            int temp = sum[i] - k;
            if (map.containsKey(temp)) {
                int count = map.get(temp);
                ans2 += count;
            }
            if (map.containsKey(sum[i])) {
                int c = map.get(sum[i]);
                map.put(sum[i], ++c);
            } else {
                map.put(sum[i], 1);
            }
        }

        // 方案 3 ====================
        // int sum[] = 0,1,2,2,3,4
        // k = 3

         int[] count = new int[sum.length];
         count[0] = 1;
         int ans3 = 0;
         for (int i = 1; i < sum.length; i++) {
             if(sum[i] - 3>=0) {
                 ans3 += count[sum[i] - 3];
             }
             count[sum[i]]++;
         }
        return ans;
    }

    @Test
    public void test() {
        int ans = numberOfSubArrays(new int[]{1, 1, 2, 1, 1}, 3);
        System.out.println("ans");
        System.out.println("ans: " + ans);
    }

}
