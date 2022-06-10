package gad.test;

import gad.radix.BinaryBucket;
import gad.radix.BinaryRadixSort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryRadixSortTest {


    @ParameterizedTest
    @MethodSource("provideTestDataBinaryKey")
    void testBinaryKey(int element, int binPlace, int expected) {
        assertEquals(expected, BinaryRadixSort.key(element, binPlace));
    }

    private static Stream<Arguments> provideTestDataBinaryKey() {
        return Stream.of(
                Arguments.of(0b00000000000000000000000000000001, 0, 1),
                Arguments.of(0b00000000000000000000010000000010, 1, 1),
                Arguments.of(0b00000000000000000000010000000100, 2, 1),
                Arguments.of(0b10000000000000000000000000000001, 31, 1),
                Arguments.of(0b01000000000000000000000000000000, 30, 1),
                Arguments.of(0b1111011111111111111111111111111, 26, 0),
                Arguments.of(0b00000000000000000000010000000000, 10, 1)
        );
    }

}
