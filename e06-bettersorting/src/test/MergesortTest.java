package gad.SortTesting;

import gad.simplesort.Mergesort;
import gad.simplesort.StudentResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MergesortTest {
    @Test
    void mergeSortTest1() {
        Mergesort mergesort = new Mergesort(5);
        StudentResult result = new StudentResult();

        int[] numbers = new int[]{2, 4, 1, 9, 10};
        mergesort.sort(numbers, result, 0, numbers.length);
        assertEquals("[1, 2, 4, 9, 10]", Arrays.toString(numbers));

        numbers = new int[]{2, 4, 1, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        mergesort.sort(numbers, result, 0, numbers.length);
        assertEquals("[1, 2, 4, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45]", Arrays.toString(numbers));

        numbers = new int[]{44, 23, 2, 4, 1, 99, 9, 10, 11, 12, 13, 14, 15, 26, 37, 45};
        mergesort.sort(numbers, result, 0, numbers.length);
        assertEquals("[1, 2, 4, 9, 10, 11, 12, 13, 14, 15, 23, 26, 37, 44, 45, 99]", Arrays.toString(numbers));


        numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        mergesort.sort(numbers, result, 0, numbers.length);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]", Arrays.toString(numbers));
    }

    @Test
    void mergeSortTest2() {
        Mergesort mergesort = new Mergesort(5);
        StudentResult result = new StudentResult();

        int[] numbers = new int[]{11, 21, 30, 4, 15, 1, 26, 13, 2, 29, 12, 10, 17, 22, 25, 24, 18, 28, 6, 14, 16, 19, 3, 5, 7, 27, 8, 9, 20, 23, 0};
        mergesort.sort(numbers, result, 0, numbers.length);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]", Arrays.toString(numbers));

        numbers = new int[]{5, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 5};
        mergesort.sort(numbers, result, -1, numbers.length + 1);
        assertEquals("[5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 55, 55, 55]", Arrays.toString(numbers));

        numbers = new int[]{30, 25, 20, 15, 14, 10, 5, 1, 0, -5, -20, -100};
        mergesort.sort(numbers, result, -2, numbers.length + 2);
        assertEquals("[-100, -20, -5, 0, 1, 5, 10, 14, 15, 20, 25, 30]", Arrays.toString(numbers));
    }

    @Test
    void mergeSortTest3() {
        Mergesort mergesort = new Mergesort(0);
        StudentResult studentResult=new StudentResult();
        // Tests for public access and correctness of parameters
        // This is a compiler-test, your compiler will tell you
        // if there's something wrong with your code before you can even run the test
        mergesort.sort(new int[]{1}, studentResult);
        mergesort.sort(new int[]{1}, studentResult, 0, 0);
        mergesort.sort(new int[]{1}, studentResult, 0, 0, new int[]{1,2});
        mergesort.merge(new int[]{1}, 0, 0,0, new int[]{1,2});
    }
}
