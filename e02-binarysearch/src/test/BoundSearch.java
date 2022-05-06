package gad.tests.binarysearch;

import gad.binarysearch.BinSea;
import gad.binarysearch.StudentResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BoundSearch {
	static Stream<Arguments> simple() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 3, 4}, 1, true, 0),
				Arguments.of(new int[]{1, 2, 3, 4}, 2, true, 1),
				Arguments.of(new int[]{1, 2, 3, 4}, 3, true, 2),
				Arguments.of(new int[]{1, 2, 3, 4}, 3, false, 2)
		);
	}

	static Stream<Arguments> duplicatesInArray() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, 2, true, 1),
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, 2, false, 3),
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, 6, true, 4),
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, 6, false, 4)
		);
	}

	static Stream<Arguments> valueNotInArray() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 3, 4}, 5, true, -1),
				Arguments.of(new int[]{1, 2, 3, 4}, 5, false, 3),
				Arguments.of(new int[]{1, 2, 3, 4}, 0, true, 0),
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, 0, false, -1),
				Arguments.of(new int[]{1, 2, 2, 2, 6, 7, 8, 9, 10}, -1, true, 0)
		);
	}

	static Stream<Arguments> randomValues() {
		return Stream.of(
				Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 1, 1}, 1, true, 1),
				Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 2, true, -1),
				Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 4}, 1, false, 6),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8}, 4, true, 1),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8}, 5, true, 4),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8}, 5, false, 7),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8}, 9, false, 8),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8, 10, 23}, 6, true, 8),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8, 10, 23}, 6, false, 7),
				Arguments.of(new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8}, 9, true, -1)
		);
	}

	static Stream<Arguments> valuesOnArrayBoundaries() {
		return Stream.of(
				Arguments.of(new int[]{0, 4, 4, 4, 4, 9, 10}, 2, true, 1),
				Arguments.of(new int[]{0, 4, 4, 4, 4, 9, 10}, 11, true, -1),
				Arguments.of(new int[]{0, 4, 4, 4, 4, 9, 10}, 11, false, 6),
				Arguments.of(new int[]{1, 1, 4, 4, 4, 9, 10}, 1, false, 1)
		);
	}

	@ParameterizedTest
	@MethodSource({"simple", "randomValues", "valueNotInArray", "duplicatesInArray", "valuesOnArrayBoundaries"})
	void testSearch(int[] arr, int value, boolean lowerBound, int expectedIdx) {
		assertEquals(expectedIdx, BinSea.search(arr, value, lowerBound, new StudentResult()));
	}
}
