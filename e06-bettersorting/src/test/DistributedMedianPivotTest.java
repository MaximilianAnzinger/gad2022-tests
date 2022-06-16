package gad.SortTesting;

import gad.simplesort.PivotFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistributedMedianPivotTest {
    @Test
    void distributedMedianPivotTest0() {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotDistributed(3);
        assertEquals(4, medianPivotFinder.findPivot(numbers, 0, 9));

        numbers = new int[]{9, 1, 8, 5, 2, 3, 5, 1, 0, 7};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(5);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, 9));

        numbers = new int[]{9, 1, 8, 5, 2, 3, 5, 1, 0, 7};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(5);
        assertEquals(5, medianPivotFinder.findPivot(numbers, 1, 9));


        numbers = new int[]{1, 5, 5, 5, 5, 5, 5, 7, 8};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(2);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        numbers = new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(4);
        assertEquals(5, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        numbers = new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(5);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));
    }

    @Test
    void distributedMedianPivotTest1() {
        // 1 -2- 10
        // Pivot 2 at Index 0
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotDistributed(3);
        assertEquals(0, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 10 -12- 14 26 45
        // Pivot 12 at Index 6
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(7);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 0, numbers.length - 1));

        // 1 2 -9- 11 13 15
        // Pivot 9 at Index 6
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(6);
        assertEquals(6, medianPivotFinder.findPivot(numbers, 2, numbers.length - 4));

        // 5 -8- 16 23
        // Pivot 15 at Index 4
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12,
                10, 17, 22, 25, 24, 18, 28, 6, 14, 16,
                19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(4);
        assertEquals(26, medianPivotFinder.findPivot(numbers, 20, numbers.length - 1));
    }

    @Test
    void distributedMedianPivotTest2() {
        // -4- 9
        // Pivot 4 at Index 1
        int[] numbers = new int[]{2, 4, 1, 9, 10};
        PivotFinder medianPivotFinder = PivotFinder.getMedianPivotDistributed(2);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 1, numbers.length - 2));

        // -4- 37
        // Pivot 4 at Index 1
        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(2);
        assertEquals(1, medianPivotFinder.findPivot(numbers, 1, numbers.length - 2));

        // 10 -37- 44
        // Pivot 37 at Index 14
        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(3);
        assertEquals(14, medianPivotFinder.findPivot(numbers, 0, 14));

        // 11 -23- 24
        // Pivot 23 at Index 10
        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 23, 18, 28, 6, 14, 16, 19, 0, 3, 5, 7, 27, 8, 9, 20, 24};
        assertEquals(31, numbers.length);
        medianPivotFinder = PivotFinder.getMedianPivotDistributed(3);
        assertEquals(15, medianPivotFinder.findPivot(numbers, 0, numbers.length-1));
    }
}
