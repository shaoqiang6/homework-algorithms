package a39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueue {
    /**
     * index 标识行号, 值标识这一行的第n列上放置queue
     */
    int[] result;
    int n = 0;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueue(int n) {
        this.n = n;
        result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        calNQueue(0);
        return ans;
    }


    public void calNQueue(int row) {
        if (row == n) {
            print();
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                calNQueue(row + 1);
                // todo 为什么要这样做?
                result[row] = -1;

            }
        }
    }

    private boolean isOk(int row, int column) {
        if (column == result[row]) {
            return false;
        }
        int leftLow = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            // 说明之前有一行,的当前列上已经放了queue
            if (column == result[i]) {
                return false;
            }
            // 左上对角线是否已经放置了queue; 右下(左下也一样)对角线不用判断,因为放queue是按照行从上到下放置的, 下一行肯定没有放queue
            if (leftLow >= 0 && leftLow == result[i]) {
                return false;
            }
            if (rightUp < n && rightUp == result[i]) {
                return false;
            }
            leftLow--;
            rightUp++;
        }
        return true;
    }


    private void print() {
        List<String> item = new ArrayList<>(4);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (result[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            item.add(sb.toString());
        }
        ans.add(item);
    }


    @Test
    public void test() {
        List<List<String>> lists = solveNQueue(4);
        for (List<String> item : lists) {
            for (String s : item) {
                System.out.println(s);
            }
            System.out.println("===================");
        }
    }

}
