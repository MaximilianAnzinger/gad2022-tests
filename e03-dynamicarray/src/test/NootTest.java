package test;

import gad.dynamicarray.Noot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NootTest {

    private enum NootOperation {
        PUSH, POP_FRONT, POP_BACK;
    }

    static Stream<Arguments> simpleExample() {
        Noot noot = new Noot(3, 4);
        return Stream.of(
                Arguments.of(noot, NootOperation.PUSH, 1, 1),
                Arguments.of(noot, NootOperation.PUSH, 2, 2),
                Arguments.of(noot, NootOperation.PUSH, 3, 3),
                Arguments.of(noot, NootOperation.POP_BACK, 3, 2),
                Arguments.of(noot, NootOperation.POP_FRONT, 1, 1),
                Arguments.of(noot, NootOperation.POP_FRONT, 2, 0)
        );
    }

    static Stream<Arguments> popThenPush() {
        Noot noot = new Noot(3, 4);
        return Stream.of(
                Arguments.of(noot, NootOperation.PUSH, 5, 1),
                Arguments.of(noot, NootOperation.PUSH, 6, 2),
                Arguments.of(noot, NootOperation.PUSH, 7, 3),
                Arguments.of(noot, NootOperation.PUSH, 8, 4),
                Arguments.of(noot, NootOperation.PUSH, 9, 5),
                Arguments.of(noot, NootOperation.POP_FRONT, 5, 4),
                Arguments.of(noot, NootOperation.POP_BACK, 9, 3),
                Arguments.of(noot, NootOperation.POP_BACK, 8, 2),
                Arguments.of(noot, NootOperation.POP_FRONT, 6, 1),
                Arguments.of(noot, NootOperation.PUSH, 8, 2),
                Arguments.of(noot, NootOperation.PUSH, 9, 3),
                Arguments.of(noot, NootOperation.POP_BACK, 9, 2),
                Arguments.of(noot, NootOperation.POP_BACK, 8, 1),
                Arguments.of(noot, NootOperation.POP_BACK, 7, 0)
        );
    }

    @ParameterizedTest
    @MethodSource({"popThenPush", "simpleExample"})
    void basicTest(Noot noot, NootOperation op, int value, int expectedSizeAfter) {
        switch (op) {
            case PUSH -> noot.pushBack(value);
            case POP_BACK -> assertEquals(value, noot.popBack());
            case POP_FRONT -> assertEquals(value, noot.popFront());
        }
        assertEquals(expectedSizeAfter, noot.size());
    }




    ///////////////////////

    @Test
        public void popFrontToEmpty() {
            Noot noot = new Noot(3, 4);

            assertTrue(noot.isEmpty());
            noot.pushBack(4);
            noot.pushBack(3);
            noot.pushBack(2);
            noot.pushBack(1);

            assertEquals(4, noot.popFront());
            assertEquals(3, noot.popFront());
            assertEquals(2, noot.popFront());
            assertEquals(1, noot.popFront());
            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popFront());
            assertTrue(noot.isEmpty());
        }

        @Test
        public void popBackToEmpty() {
            Noot noot = new Noot(3, 4);

            assertTrue(noot.isEmpty());
            noot.pushBack(4);
            noot.pushBack(3);
            noot.pushBack(2);
            noot.pushBack(1);

            assertEquals(1, noot.popBack());
            assertEquals(2, noot.popBack());
            assertEquals(3, noot.popBack());
            assertEquals(4, noot.popBack());
            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popBack());
            assertTrue(noot.isEmpty());
        }

        @Test
        public void popMixed() {
            Noot noot = new Noot(3, 4);

            noot.pushBack(1);
            noot.pushBack(2);
            noot.pushBack(3);
            noot.pushBack(4);

            assertEquals(1, noot.popFront());
            assertEquals(4, noot.popBack());
            assertEquals(3, noot.popBack());
            assertEquals(2, noot.popBack());
            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popFront());
            assertTrue(noot.isEmpty());

            noot.pushBack(101);
            assertEquals(101, noot.popFront());
            assertTrue(noot.isEmpty());
        }

        @Test
        public void popMixed2() {
            Noot noot = new Noot(2, 5);

            noot.pushBack(1);
            noot.pushBack(2);
            noot.pushBack(3);
            noot.pushBack(4);

            assertEquals(1, noot.popFront());
            assertEquals(2, noot.popFront());
            assertEquals(3, noot.popFront());
            assertEquals(4, noot.popBack());
            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popFront());
            assertTrue(noot.isEmpty());

            noot.pushBack(101);
            assertEquals(101, noot.popBack());
            assertTrue(noot.isEmpty());
        }

        @Test
        public void popMixed3() {
            Noot noot = new Noot(2, 5);

            noot.pushBack(1);
            assertEquals(1, noot.popFront());

            noot.pushBack(2);
            noot.pushBack(3);
            assertEquals(3, noot.popBack());
            noot.pushBack(4);

            assertEquals(2, noot.popFront());
            noot.pushBack(69);
            assertEquals(4, noot.popFront());
            assertEquals(69, noot.popBack());
            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popFront());
            assertTrue(noot.isEmpty());

            noot.pushBack(101);
            assertEquals(101, noot.popBack());
            assertTrue(noot.isEmpty());
        }

        @Test
        public void popMixed4() {
            Noot noot = new Noot(2, 5);

            noot.pushBack(1);
            noot.pushBack(2);
            assertEquals(1, noot.popFront());
            noot.pushBack(3);
            assertEquals(3, noot.popBack());
            noot.pushBack(4);
            noot.pushBack(69);
            assertEquals(2, noot.popFront());
            assertEquals(69, noot.popBack());
            assertEquals(4, noot.popFront());

            assertTrue(noot.isEmpty());

            noot.pushBack(42);
            assertEquals(42, noot.popFront());
            assertTrue(noot.isEmpty());

            noot.pushBack(101);
            assertEquals(101, noot.popBack());
            assertTrue(noot.isEmpty());
        }
}