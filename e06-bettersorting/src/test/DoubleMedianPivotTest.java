package test;

import gad.simplesort.DualPivotFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleMedianPivotTest {

    @Test
    void doubleMedianPivotTest1() {
        // 1 -2- 4 -9- 10
        int[] numbers = new int[]{4, 9, 1, 10, 2};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotFront(5);
        assertDoubleMedians(4, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 1 2 3 -4- 5 6 9 -10- 23 35 99
        numbers = new int[]{4, 9, 1, 10, 2, 5, 99, 23, 3, 35, 6};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 3, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 1 -2- 4 -9- 10
        numbers = new int[]{4, 9, 1, 10, 2, 5, 99, 23, 3, 35, 6};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(5);
        assertDoubleMedians(4, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 8 10 -24- 29 38 -42- 57 75 77
        numbers = new int[]{8, 42, 10, 75, 29, 77, 38, 57, 24};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(8, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 8 10 -24- 29 38 -57- 75 76 77
        numbers = new int[]{24, 8, 76, 10, 75, 29, 77, 38, 57};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 8, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 8 10 -24- 29 38 40 -42- 57 75 77
        numbers = new int[]{24, 8, 42, 10, 75, 29, 77, 38, 57, 40};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 2, dualPivotFinder.findPivot(numbers, 0, numbers.length));
    }

    @Test
    void doubleMedianPivotTest2() {
        // 0 1 2 3 4 5 6 7 8 -9- 10 11 12 13 14 15 16 17 18 19 -20- 21 22 23 24 25 26 27 28 29 30
        int[] numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(27, 28, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 1 -4- 13 -15- 26 30
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(6);
        assertDoubleMedians(3, 4, dualPivotFinder.findPivot(numbers, 2, numbers.length));

        // 1 -2- 12 13 -15- 26 29
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(7);
        assertDoubleMedians(8, 4, dualPivotFinder.findPivot(numbers, 4, numbers.length));

        // 2 10 -12- 13 17 -22- 26 29
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(8);
        assertDoubleMedians(10, 13, dualPivotFinder.findPivot(numbers, 6, numbers.length));

        // 1 2 -4- 11 13 15 -21- 26 29 30
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(3, 1, dualPivotFinder.findPivot(numbers, 0, 9));

        // -11- -21- 30
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, 2));
    }

    @Test
    void doubleMedianPivotTest3() {
        // 1 2 10 -12- 13 17 22 -24- 25 26 29
        int[] numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(10, 15, dualPivotFinder.findPivot(numbers, 5, 15));

        // 5 5 5 -5- 5 6 6 6 -6- 6 6 55 55
        numbers = new int[]{5, 6, 5, 6, 55, 6, 5, 6, 55, 6, 5, 6, 5};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 2 4 8 8 8 -12- 14 26 26 28 30 -30- 30 30 34 36 36
        numbers = new int[]{2, 4, 8, 8, 8, 12, 14, 26, 26, 28, 30, 30, 30, 30, 34, 36, 36};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(5, 10, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 5 6 7 -44- 44 44 44 -44- 44 44 44
        numbers = new int[]{5, 6, 7, 44, 44, 44, 44, 44, 44, 44, 44};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(3, 4, dualPivotFinder.findPivot(numbers, 0, numbers.length));
    }

    @Test
    void doubleMedianPivotTest4() {
        // 2 2 -2- 2 2 2 -2- 2 2 2
        int[] numbers = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 2 4 10 -10- 10 10 11 12 -12- 12 14 15 16
        numbers = new int[]{16, 15, 14, 12, 12, 12, 11, 10, 10, 10, 10, 4, 2};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(7, 3, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 2 4 10 -10- 10 10 12 -12- 12 14 15 16
        numbers = new int[]{16, 15, 14, 12, 12, 12, 10, 10, 10, 10, 4, 2};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(6, 3, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 10 10 -10- 10 10 -10- 15 20
        numbers = new int[]{10, 10, 10, 15, 10, 20, 10, 10};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));
    }

    /**
     * <div>
     *     This Testcase is a bitch. It's nearly impossible to pass it.
     * </div>
     * <div>
     *     Kudos to you if you can pass this testcase. It took me all night getting the algorithm right.
     * </div>
     */
    @Test
    void doubleMedianPivotTest5() {
        // 5 5 5 5 5 -5- 6 6 6 6 6 -6- 6 6 55 55 55
        int[] numbers = new int[]{5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55};
        DualPivotFinder dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));

        // 5 6 7 -44- 44 44 44 -44- 44 44 44
        numbers = new int[]{44, 44, 44, 5, 6, 44, 44, 7, 44, 44, 44};
        dualPivotFinder = DualPivotFinder.getMedianPivotFront(numbers.length);
        assertDoubleMedians(0, 1, dualPivotFinder.findPivot(numbers, 0, numbers.length));
    }

    private void assertDoubleMedians(int firstPivot, int secondPivot, int[] actualPivots) {
        assertEquals(2, actualPivots.length);
        assertEquals(firstPivot, actualPivots[0]);
        assertEquals(secondPivot, actualPivots[1]);
    }
}
