package mergeIntervals0056;

import org.junit.Test;

import java.util.Arrays;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author shaoqiangyan
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        return merge1(intervals);
    }

    /**
     * 1.对区间数组排序, 然后依次进行merge
     * @param intervals 区间数组
     * @return 合并之后的区间数组
     */
    private int[][] merge1(int[][] intervals) {
        // 1. sort
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1 ; j < intervals.length; j++) {
                if (compare(intervals[i], intervals[j]) >= 0) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
//        * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        * 输出：[[1,6],[8,10],[15,18]]
        // 2. merge
        int left = intervals[0][0];
        int max = intervals[0][1];
        int index = 0;
        int [][] temp = new int[intervals.length][2];
        for (int[] interval : intervals) {
            int x = interval[0];
            int y = interval[1];
            // 没有交集
            if (x > max) {
                temp[index++] = new int[]{left, max};
                left = x;
                max = y;
            } else {
                max = Math.max(max, y);
            }

        }
        temp[index] = new int[]{left, max};
        if (temp.length == index + 1) {
            return temp;
        }
        // merge之后的区间数小于原区间数时, 需要舍去temp数组中的 {0,0}
        return Arrays.copyOf(temp, index + 1, int[][].class);
    }




    private int compare(int[] i, int[] j) {
        int x = i[0];
        int y = j[0];
        return x != y ? x - y : i[1] - j[1];
    }

    @Test
    public void test() {
        int [][] intervals = {{1,3}, {2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for(int[] interval : merge) {
            System.out.println(interval[0] + ", " + interval[1]);
        }
    }


}
