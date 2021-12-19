package relativeSortArray;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len2 = arr2.length;
        for(int i = 0; i < len2; i++) {
            map.put(arr2[i], i);
        }
        return sort1(arr1);
    }

    /**
     * 选择排序
     * @param arr1  src array
     * @return 排序之后的数组
     */
    private int[] sort1(int[] arr1) {
        int len1 = arr1.length;
        for (int i = 0; i < len1; i++) {
            for (int j = i + 1; j < len1; j++) {
                if (frontSmall(arr1[j], arr1[i])) {
                    int temp = arr1[j];
                    arr1[j] = arr1[i];
                    arr1[i] = temp;
                }
            }
        }
        return arr1;
    }

    /**
     * 两数比较
     * @param front 第一个数
     * @param j 第二个数
     * @return 返回比较结果 true front 较小,否则j较大
     */
    private boolean frontSmall(int front, int j) {
        // 找到就按照对应的权重排序, 否则将值加1000(因为 0 <= arr1[i], arr2[i] <= 1000) 然后比较值
        return map.getOrDefault(front, front + 1000) - map.getOrDefault(j, j + 1000) <=0;
    }

    @Test
    public void test() {
        int [] arr1 = new int []{26,21,11,20,50,34,1,18};
        int [] arr2 = new int []{21,11,26,20};
        int[] ints = relativeSortArray(arr1, arr2);
        Arrays.stream(ints).forEach(i -> System.out.print(" " + i));
    }

}
