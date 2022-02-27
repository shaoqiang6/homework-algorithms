package ch04;

import org.junit.Assert;
import org.junit.Test;
import sun.jvm.hotspot.SALauncherLoader;

/** divide & conquer 分而治之
 * @author shaoqiangyan
 */
public class DC {
    /**
     * 将一块长方形的土地均匀的分成方块,并确保分出的方块是最大的
     * @param length
     * @param width
     * @return
     */
    public int count(int length, int width) {
        int c = length / width;
        int width2 = length % width;
        if (width2 == 0) {
            return c;
        }
        return c + count(width, width2);
    }

    /**
     * 找到最小的方块的长度
     * @param length
     * @param width
     * @return
     */
    public int smallLength(int length, int width) {
        // 长是宽的整数倍,可以分成 k个 width的方块, 返回方块的边长
        int width2 = length % width;
        if (width2 == 0) {
            return width;
        }
        return smallLength(width, width2);
    }
    @Test
    public void test() {
        final int count = count(1680, 640);
        System.out.println(count);
        final int i = smallLength(1680, 640);
        Assert.assertTrue(80 == i);


    }
}
