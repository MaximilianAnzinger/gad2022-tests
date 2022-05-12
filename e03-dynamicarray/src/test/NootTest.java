package test;

import gad.dynamicarray.Noot;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void artemisTest(Noot noot, NootOperation op, int value, int expectedSizeAfter) {
        switch (op) {
            case PUSH -> noot.pushBack(value);
            case POP_BACK -> assertEquals(value, noot.popBack());
            case POP_FRONT -> assertEquals(value, noot.popFront());
        }
        assertEquals(expectedSizeAfter, noot.size());
    }
}