package ch04;

import org.junit.Assert;
import org.junit.Test;

/**
 * 求数组内元素的和
 */
public class ArraySum {
    int[]  arr;
    public int sum(int[] arr) {
        this.arr = arr;
        return mySum(0);
    }
    private int mySum(int i) {
        if (i > arr.length - 1) {
            return 0;
        }
        return arr[i] + mySum(i + 1);
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5};
        Assert.assertTrue(15 == sum(arr));
    }
}
