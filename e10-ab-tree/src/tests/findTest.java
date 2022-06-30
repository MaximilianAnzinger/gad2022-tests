package tests;

import gad.abtree.ABTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class findTest {

    @Test
    public void empty() {
        ABTree abTree = new ABTree(2, 4);
        assertFalse(abTree.find(10));
    }

    @Test
    public void single() {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(10);
        assertTrue(abTree.find(10));
    }

    @Test
    public void big() {
        ABTree tree = new ABTree(3, 5);

        for (int i = 0; i <= 500; i += 10) {
            tree.insert(i);
        }

        System.out.println(tree);

        for (int i = 0; i <= 500; i++) {
            if (i % 10 == 0) {
                assertTrue(tree.find(i));
            } else {
                assertFalse(tree.find(i));
            }
        }
    }
}
