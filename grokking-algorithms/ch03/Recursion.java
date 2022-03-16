package ch03;

import org.junit.Assert;
import org.junit.Test;

public class Recursion {

    public int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    @Test
    public void test() {
        final int factorial = factorial(3);
        Assert.assertTrue(6 == factorial);

    }
}
