package randompointinnonoverlappingrectangles0497;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 497. 非重叠矩形中的随机点
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 *
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 *
 * 请注意 ，整数点是具有整数坐标的点。
 *
 * 实现 Solution 类:
 *
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 *
 *
 * 示例 1：
 * 输入: 
 * ["Solution", "pick", "pick", "pick", "pick", "pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
 * 输出: 
 * [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
 *
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * 
 *
 * 提示：
 *
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -109<= ai< xi<= 109
 * -109<= bi< yi<= 109
 * xi- ai<= 2000
 * yi- bi<= 2000
 * 所有的矩形不重叠。
 * pick 最多被调用104次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author shaoqiangyan
 */
public class Solution {
    /*
    前缀和 + 二分
为了方便，我们使用 rs 来代指 rects，定义某个矩阵内整数点的数量为「面积」。

一个朴素的想法是「先随机使用哪个矩形，再随机该矩形内的点」，其中后者是极其容易的，根据矩形特质，只需在该矩形的 XY 坐标范围内随机即可确保等概率，而前者（随机使用哪个矩形）为了确保是等概率，我们不能简单随机坐标，而需要结合面积来做。

具体的，我们可以预处理前缀和数组 sum（前缀和数组下标默认从 11 开始），其中 sum[i]sum[i] 代表前 ii 个矩形的面积之和（即下标范围 [0, i - 1][0,i−1] 的面积总和），最终 sum[n]sum[n] 为所有矩形的总面积，我们可以在 [1, sum[n]][1,sum[n]] 范围内随机，假定随机到的值为 valval，然后利用 sum 数组的具有单调性，进行「二分」，找到 valval 所在的矩形（每个矩形均会贡献面积，可看做是每个矩形在数轴 [1, sum[n]][1,sum[n]] 内贡献一段长度为面积的连续段，我们二分是为了找到点 valval 所在的连续段是由哪个矩形所贡献），然后在该矩形中进行随机，得到最终的随机点。
     */

    int[][] rs;
    int[] sum;
    int n;
    Random random = new Random();
    public Solution(int[][] rects) {
        rs = rects;
        n = rs.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
    }
    public int[] pick() {
        int val = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) r = mid;
            else l = mid + 1;
        }
        int[] cur = rs[r - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}
