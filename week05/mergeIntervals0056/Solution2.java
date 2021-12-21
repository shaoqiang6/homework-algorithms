package mergeIntervals0056;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

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
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        return merge2(intervals);
    }

    /**
     * 1.对区间数组排序, 然后依次进行merge
     * @param intervals 区间数组
     * @return 合并之后的区间数组
     */
    private int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        Pair<Integer, Integer> [] events = new Pair[len * 2];

        for (int i = 0; i < intervals.length; i++) {
            events[i] = new Pair<>(intervals[i][0], 1);
            events[i + len] = new Pair<>(intervals[i][1] + 1, -1);
        }
        Arrays.sort(events, (p1, p2) -> p1.getKey().equals(p2.getKey()) ? p1.getValue() - p2.getValue() : p1.getKey() - p2.getKey());
        int start = 0;
        int convert = 0;
        int index = 0;
        int [][] temp = new int[intervals.length][2];
        for (Pair<Integer, Integer> pair : events) {
            if (convert == 0) {
                start = pair.getKey();
            }
            convert += pair.getValue();
            if (convert == 0) {
                temp[index++]  = new int[]{start, pair.getKey() - 1};
            }
        }
        if (temp.length == index) {
            return temp;
        }
        return Arrays.copyOf(temp, index, int[][].class);
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
