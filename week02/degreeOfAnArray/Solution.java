package degreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 *
 */
public class Solution {

    /**
     * 完全没想到这个解法, 不想浪费太多时间, 看题解之后豁然开朗 ^^
     * 构建一个map来存每个数字 k 对应的开始结束索引以及出现次数 v
     * 1. map.k : 最大度 每次碰到相同的数字就更新 map.value
     * 2. map.value : 最大度前提下最小的距离  value的格式: int[]{度, beginIndex, endIndex}
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Map<Integer, int[]> map = new HashMap<>(length);
        for(int i = 0; i < length; i++) {
            int[] n = map.get(nums[i]);
            if (n == null) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                // 度+=1; 更新endIndex
                n[0]++;
                n[2] = i;
            }
        }
        int maxNum = 0;
        int minLen = 0;
        for (int[] arr : map.values()) {
            int tempLen = arr[2] - arr[1] + 1;
            int tempMax = arr[0];
            if (maxNum < tempMax) {
                maxNum = tempMax;
                minLen = tempLen;
            } else if (maxNum == tempMax) {
                minLen = minLen < tempLen ? minLen : tempLen;
            }
        }
        return minLen;
    }


}
