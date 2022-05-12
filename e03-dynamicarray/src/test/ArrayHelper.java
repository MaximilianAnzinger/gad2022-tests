package test;

import gad.dynamicarray.DynamicArray;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayHelper {

	static void checkUnderlyingArray(int[] expected, Object o, String[] errorMsg) throws NoSuchFieldException,
			IllegalAccessException {

		//get dynamicArray variable from object
		var dynamicalArrayField = o.getClass().getDeclaredField("array");
		dynamicalArrayField.setAccessible(true);

		var dynamicArray = (DynamicArray) dynamicalArrayField.get(o);

		//get int[] array from object
		var elementsField = DynamicArray.class.getDeclaredField("elements");
		elementsField.setAccessible(true);

		var actual = (int[]) elementsField.get(dynamicArray);


		assertArrayEquals(
				expected,
				actual,
				"\nShould be:\n" +
						Arrays.toString(expected) + " but is:\n" +
						Arrays.toString(actual) + "\n" +
						Arrays.toString(errorMsg) + "\n\n");
	}
}
