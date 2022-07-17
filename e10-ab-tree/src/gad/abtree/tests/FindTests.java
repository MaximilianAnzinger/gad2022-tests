package gad.abtree.tests;

import gad.abtree.ABTree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindTests {

    public static Stream<Arguments> insertFind_ReverseInsertFind_Test_Arguments() {
        return Stream.of(
                Arguments.of(2, 3, 16),
                Arguments.of(2, 4, 16),
                Arguments.of(2, 5, 16),
                Arguments.of(4, 8, 16),
                Arguments.of(5, 10, 16),
                Arguments.of(10, 20, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("insertFind_ReverseInsertFind_Test_Arguments")
    void insertFind_ReverseInsertFind_Test(int a, int b, int testSize) {
        ABTree tree = new ABTree(a, b);
        assertFalse(tree.find(0));

        for (int i = 0; i < testSize; i++) {
            System.out.println("inserting: " + i);
            tree.insert(i);
            System.out.println(tree);
            assertTrue(tree.validAB());
        }
        for (int i = 0; i < testSize; i++) {
            System.out.println(i);
            assertTrue(tree.find(i));
        }

        ABTree treeReverse = new ABTree(a, b);
        assertFalse(treeReverse.find(0));

        for (int i = testSize - 1; i >= 0; i--) {
            System.out.println("inserting: " + i);
            treeReverse.insert(i);
            System.out.println(treeReverse);
            assertTrue(treeReverse.validAB());
        }
        for (int i = testSize - 1; i >= 0; i--) {
            System.out.println(i);
            assertTrue(treeReverse.find(i));
        }
    }
}
