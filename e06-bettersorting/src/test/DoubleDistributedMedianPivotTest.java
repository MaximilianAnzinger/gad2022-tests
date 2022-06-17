package test;

import gad.simplesort.DualPivotFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleDistributedMedianPivotTest {
    @Test
    void doubleMedianPivotTest1() {
        // -1- -2- 4
        int[] numbers = new int[]{4, 9, 1, 10, 2};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(3);
        assertDoubleMedians(2, 4, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // -3- -4- 15
        numbers = new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(3);
        assertDoubleMedians(10, 0, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 1 -2- 4 -13- 17
        numbers = new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(5);
        assertDoubleMedians(4, 6, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // -4- 10 -13- 55
        numbers = new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(4);
        assertDoubleMedians(0, 6, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 1 2 3 -4- 9 10 11 -13- 15 17 26 55
        numbers = new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(numbers.length);
        assertDoubleMedians(0, 6, dualPivotFinder.findPivot(numbers, 0, numbers.length));
    }


    @Test
    void doubleMedianPivotTest2() {
        // 19 20 21 -22- 23 24 25 -26- 27 28 29 30
        int[] numbers = new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 12, 9, 6, 3, 0};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(numbers.length);
        assertDoubleMedians(8, 4, dualPivotFinder.findPivot(numbers, 0, 11));

        // 22 -24- 26 -28- 30
        numbers = new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 12, 9, 6, 3, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(5);
        assertDoubleMedians(6, 2, dualPivotFinder.findPivot(numbers, 0, 11));

        // 0 -6- 12 -16- 18
        numbers = new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 12, 9, 6, 3, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(5);
        assertDoubleMedians(18, 14, dualPivotFinder.findPivot(numbers, 12, numbers.length));
    }

    @Test
    void doubleMedianPivotTest3() {
        // 5 -6- 6 -55- 55
        int[] numbers = new int[]{5, 6, 5, 6, 55, 6, 5, 6, 55, 6, 5, 6, 5};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(numbers.length);
        assertDoubleMedians(5, 4, dualPivotFinder.findPivot(numbers, 4, 8));

        // 5 5 -5- 5 5 -5- 55 55
        numbers = new int[]{5, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 5};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(8);
        assertDoubleMedians(2, 4, dualPivotFinder.findPivot(numbers, 2, 18));

        // 5 5 5 5 5 -5- 6 6 6 6 6 -6- 6 6 55 55 55
        numbers = new int[]{5, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 5};
        dualPivotFinder = DualPivotFinder.getMedianPivotDistributed(numbers.length);
        assertDoubleMedians(2, 3, dualPivotFinder.findPivot(numbers, 2, 18));
    }

    private void assertDoubleMedians(int firstPivot, int secondPivot, int[] actualPivots) {
        assertEquals(2, actualPivots.length);
        assertEquals(firstPivot, actualPivots[0]);
        assertEquals(secondPivot, actualPivots[1]);
    }
}
