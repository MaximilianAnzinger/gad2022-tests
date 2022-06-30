package tests;

import gad.abtree.ABTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class heightTest {

    @Test
    public void empty() {
        ABTree abTree = new ABTree(2, 4);
        assertEquals(0, abTree.height());
    }

    @Test
    public void single() {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(123);
        assertEquals(1, abTree.height());
    }

    @Test
    public void height() {
        ABTree tree = new ABTree(3, 5);

        for (int i = 0; i <= 16; i++) {
            tree.insert(i);
        }

        System.out.println(tree);

        assertEquals(3, tree.height());
    }
}
