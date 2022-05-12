package test;

import gad.dynamicarray.DynamicArray;
import gad.dynamicarray.DynamicStack;
import gad.dynamicarray.StudentResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicStackTest {

	void checkStack(DynamicStack ds, int[] elementsShould, String... errorMsg) throws NoSuchFieldException,
			IllegalAccessException {

		var dynamicalArrayField = DynamicStack.class.getDeclaredField("array");
		dynamicalArrayField.setAccessible(true);

		var elementsField = DynamicArray.class.getDeclaredField("elements");
		elementsField.setAccessible(true);

		var dynamicArray = (DynamicArray) dynamicalArrayField.get(ds);
		var stackElements = (int[]) elementsField.get(dynamicArray);

		assertArrayEquals(elementsShould, stackElements,
				"\nShould be:\n" +
						Arrays.toString(elementsShould) + " but is:\n" +
						Arrays.toString(stackElements) + "\n" +
						Arrays.toString(errorMsg) + "\n\n");
	}


	@Test
	void artemisTest() throws NoSuchFieldException, IllegalAccessException {
		var ds = new DynamicStack(3, 4, new StudentResult());

		checkStack(ds, new int[]{}, "Stack should initially be empty");

		ds.pushBack(1);
		checkStack(ds, new int[]{1, 0, 0}, "just pushed 1");

		ds.pushBack(2);
		checkStack(ds, new int[]{1, 2, 0}, "just pushed 2");

		ds.pushBack(3);
		checkStack(ds, new int[]{1, 2, 3}, "just pushed 3");

		ds.pushBack(4);
		checkStack(ds, new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0}, "just pushed 4; stack should grow");

		assertEquals(4, ds.popBack());
		checkStack(ds, new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0}, "pop should not change the stack");

		ds.pushBack(5);
		checkStack(ds, new int[]{1, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0}, "just pushed 5");
		assertEquals(5, ds.popBack());

		checkStack(ds, new int[]{1, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0}, "pop Should not change the stack");

		assertEquals(3, ds.popBack());
		checkStack(ds, new int[]{1, 2, 0, 0, 0, 0}, "Stack should shrink and only copy the needed elements");

	}
}
