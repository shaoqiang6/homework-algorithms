package lemonadeChange0860;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * 示例 3：
 *
 * 输入：bills = [5,5,10]
 * 输出：true
 * 示例 4：
 *
 * 输入：bills = [10,10]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= bills.length <= 105
 * bills[i] 不是 5 就是 10 或是 20
 *
 * @author shaoqiangyan
 */
public class Solution {
    /**
     * k 面额, v 这个面额的钱的个数
     */
    Map<Integer, Integer> map;
    private static final int[] money = new int[]{20, 10, 5};
    public boolean lemonadeChange(int[] bills) {
        map = new HashMap<>();
        for (int bill : bills) {
            map.put(bill, 0);
        }

        for (int bill : bills) {
            if (!exchange(bill - 5)) {
                return false;
            }
            map.put(bill, map.get(bill) + 1);
        }
        return true;
    }
    /**
     使用map中的钱兑换bill
     */
    private boolean exchange(int bill) {
        if (bill == 0) {
            return true;
        }
        for (int m : money) {
            while (map.get(m) != null && map.get(m) > 0 && bill >= m) {
                bill -= m;
                map.put(m, map.get(m) - 1);
            }
        }
        return bill == 0;
    }

    @Test
    public void test() {
        int[] bills = new int[]{5,5,5,10,5,5,10,20,20,20};
        boolean lemonadeChange = lemonadeChange(bills);
        System.out.println(lemonadeChange);


    }
}
