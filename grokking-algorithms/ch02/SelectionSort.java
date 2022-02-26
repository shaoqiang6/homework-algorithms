package ch02;

import org.junit.Test;

import java.util.Arrays;


/** 选择排序
 * @author shaoqiangyan
 */
public class SelectionSort {

    public int[] sort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 找这个索引之后最小的数字对应的索引
            int smallest = findSmallest(arr, i);
            if (smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        }
        return arr;
    }

    private int findSmallest(int[] arr, int index) {
        int smallest = arr[index];
        int smallestIndex = index;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallestIndex = i;
                smallest = arr[i];
            }
        }
        return smallestIndex;
    }

    @Test
    public void test() {
        int[] arr = new int[]{5,2,4,7,2,1};
        final int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }


}
