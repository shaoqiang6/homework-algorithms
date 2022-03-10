package ch03;

import org.junit.Assert;
import org.junit.Test;

public class FindKey {

    public int findKey(Box box) {
        if (box.isKey()) {
            return box.key;
        }
        return findKey(box.innerBox);
    }

    @Test
    public void test() {
        Box box = new Box(1);
        Box box1 = new Box(box);
        Box box2 = new Box(box1);
        Box box3 = new Box(box2);
        final int key = findKey(box3);
        Assert.assertTrue(1 == key);


    }




    private static class Box {
        private Box innerBox;
        private int key;
        private Box(Box innerBox) {
            this.innerBox = innerBox;
        }
        private Box(int key) {
            if (key <= 0) {
                throw new IllegalArgumentException("key must > 0");
            }
            this.key = key;
        }
        private boolean isKey() {
            return innerBox == null && key > 0;
        }
    }
}
