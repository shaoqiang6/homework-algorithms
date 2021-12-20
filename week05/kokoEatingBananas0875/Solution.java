package kokoEatingBananas0875;

import org.junit.Assert;
import org.junit.Test;

/**
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * @author shaoqiangyan
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        if (len == h) {
            return max;
        }
        int left = 1;
        while (left < max) {
            int mid = (left + max) / 2;
            if (validate(piles, mid, h)) {
                max = mid;
            } else {
                left = mid + 1;
            }
        }
        return max;
    }


    private boolean validate(int[] piles, int mid, int h) {
        int used = 0;
        // 每一堆香蕉都是独立的, 每一堆使用的时间计算是关键, 如果可以整除则使用 /即可,否则需要 + 1
        for (int pile : piles) {
            used += pile / mid;
            if (pile % mid != 0) {
                used += 1;
            }
            if (used > h) {
                return false;
            }
        }
        return used <=h;
    }

    @Test
    public void test() {
//        int [] piles = {3,6,7,11};
//        int H = 8;
//        int i = minEatingSpeed(piles, H);
//        Assert.assertEquals(4, i);
        // --------------------
//        int []piles = new int[]{30,11,23,4,20};
//        int H = 5;
//        int i = minEatingSpeed(piles, H);
//        Assert.assertEquals(30, i);
        int [] piles = new int[]{30,11,23,4,20};
        int H = 6;
        int i = minEatingSpeed(piles, H);
        Assert.assertEquals(23, i);
        System.out.println(i);

    }
}
