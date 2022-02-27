package ch04;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/** 快速排序
 * @author shaoqiangyan
 */
public class QuickSort {
    int [] arr;
    public int[] quickSort(int [] arr) {
        this.arr = arr;
        myQuickSort(0, arr.length - 1);
        return arr;

    }
    private void myQuickSort(int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = partition(left, right);
        // 基准两遍分别快速排序
        myQuickSort(left, pivot);
        myQuickSort(pivot + 1, right);
    }

    /**
     * 找基准然后将数组元素分到基准值的两边
     * @param low
     * @param high
     * @return
     */
    private int partition(int low, int high) {
        int pivot = rand(low, high);
        int pivotVal = arr[pivot];
        while (low <= high) {
            while (arr[low] < pivotVal) {
                low++;
            }
            while (arr[high] > pivotVal) {
                high--;
            }
            if (low == high) {
                break;
            }
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return high;

    }
    private int rand(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
//        return (low + high) / 2;

    }

    @Test
    public void test() {
        int[] arr = {2,123,12,312,4,123,1,4,1243,1,53,45,43,123};
        final int[] ints = quickSort(arr);
        System.out.println(Arrays.toString(ints));

    }



}
