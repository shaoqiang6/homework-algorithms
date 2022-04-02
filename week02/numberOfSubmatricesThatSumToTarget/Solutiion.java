package numberOfSubmatricesThatSumToTarget;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *
 *
 * 示例 1：
 *  -------------
 *  | 0 | 1 | 0 |
 *  -------------
 *  | 1 | 1 | 1 |
 *  ------------
 *  | 0 | 1 | 0 |
 *  -------------
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 *
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * 示例 3：
 *
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */
public class Solutiion {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][]sum = new int[n+1][m+1];
        // 前缀和
        for (int i =1; i< n + 1;i++) {
            for (int j =1; j< m + 1;j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                System.out.println(sum[i][j]);
            }
            System.out.println("========");
        }
        Map<Integer,Integer> map = new HashMap<>((n+1)*(m+1));
        int ans = 0;
        for (int i = 1; i< n + 1;i++) {
            for (int j = 1; j< m + 1;j++) {
                int sumIj = sum[i][j];
                if (map.containsKey(target - sumIj)) {
                    ans += map.get(target - sumIj);
                }
                if (map.containsKey(sumIj)) {
                    int c = map.get(sumIj);
                    map.put(sumIj, ++c);
                } else {
                    map.put(sumIj, 1);
                }
                System.out.println(map);
                // int cnt = map.getOrDefault(sum[i][j], 0);
                // map.put(sum[i][j], ++cnt);
            }
            System.out.println("========111");
        }
        System.out.println(map);
        return ans;

    }

    @Test
    public void test () {
        int[][] matrix = {{0,1,0}, {1,1,1},{0,1,0}};
        int i = numSubmatrixSumTarget(matrix, 0);
        System.out.println(i);
    }
}
