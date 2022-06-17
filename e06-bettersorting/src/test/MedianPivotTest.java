package gad.SortTesting;

import gad.simplesort.PivotFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedianPivotTest {
    @Test
    void medianPivotTest0() {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(3);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 0, 9));

        numbers = new int[]{9, 1, 8, 5, 2, 3, 5, 1, 0, 7};
        medianPivotFinder = PivotFinder.getMedianPivotFront(5);
        assertEquals(3, medianPivotFinder.findPivot(numbers, 0, 9));

        numbers = new int[]{9, 1, 8, 5, 2, 3, 5, 1, 0, 7};
        medianPivotFinder = PivotFinder.getMedianPivotFront(5);
        assertEquals(3, medianPivotFinder.findPivot(numbers, 2, 8));

        numbers = new int[]{1, 5, 5, 5, 5, 5, 5, 7, 8};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        numbers = new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(5, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));
    }

    @Test
    void medianPivotTest1() {
        // 1 2 -4- 9 10
        // Pivot 4 at Index 1
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 6 10 11 -12- 13 14 15 26 37 45
        // Pivot 12 at Index 6
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 6 10 11 12 -13- 14 15 23 26 37 44 45 99
        // Pivot 13 at Index 10
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(10, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 -15- 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        // Pivot 15 at Index 4
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(4, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));
    }

    @Test
    void medianPivotTest2() {
        // 1 -2- 4
        // Pivot 2 at Index 0
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(3);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 -4- 9 10
        // Pivot 4 at Index 1
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(5);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 -9- 23 44 99
        // Pivot 9 at Index 6
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(7);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 10 11 -12- 13 15 21 26 29 30
        // Pivot 12 at Index 10
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotFront(12);
        assertEquals(10, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));
    }

    @Test
    void medianPivotTest3() {
        // 1 2 -4- 9 10
        // Pivot 4 at Index 1
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length + 1);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 6 10 11 -12- 13 14 15 26 37 45
        // Pivot 12 at Index 6
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length + 1);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 4 6 10 11 12 -13- 14 15 23 26 37 44 45 99
        // Pivot 1 at Index 0
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length + Integer.MAX_VALUE);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 -15- 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        // Pivot 0 at Index 0
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotFront(-numbers.length);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));
    }

    @Test
    void medianPivotTest4() {
        // 1 -2- 4 9
        // Pivot 2 at Index 0
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, 3));

        // 1 2 4 6 10 -11- 12 13 14 15 26
        // Pivot 11 at Index 5
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(5, medianPivotFinder.findPivot(numbers, 0, numbers.length - 3));

        // 1 2 4 6 10 11 12 -13- 14 15 23 26 37 44 45 99
        // Pivot 13 at Index 10
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length + 1);
        assertEquals(10, medianPivotFinder.findPivot(numbers, 0, numbers.length + 1));

        // 0 1 2 3 4 5 6 7 8 9 10 12 13 -14- 15 16 17 18 19 20 22 23 24 25 26 27 28 29
        // Pivot 14 at Index 19
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(19, medianPivotFinder.findPivot(numbers, 3, numbers.length - 1));
    }

    @Test
    void medianPivotTest5() {
        // 1 -4- 9
        // Pivot 4 at Index 1
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 1, numbers.length - 2));

        // 37 -26- 45
        // Pivot 26 at Index 11
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(numbers.length);
        assertEquals(11, medianPivotFinder.findPivot(numbers, numbers.length - 3, numbers.length - 1));

        // 1 9 -10- 11 99
        // Pivot 10 at Index 7
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotFront(5);
        assertEquals(7, medianPivotFinder.findPivot(numbers, 4, numbers.length - 4));

        // 10 12 17 -18- 22 24 25 29
        // Pivot 10 at Index 12
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotFront(8);
        assertEquals(16, medianPivotFinder.findPivot(numbers, 9, 23));
    }


}
