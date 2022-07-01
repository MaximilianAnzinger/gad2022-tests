package tests;

import gad.abtree.ABTree;
import gad.abtree.ABTreeInnerNode;
import gad.abtree.ABTreeLeaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class validABTest {

    @Test
    public void empty() {
        ABTree abTree = new ABTree(2, 4);
        testValidAB(abTree, true);
    }

    @Test
    public void single() {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(10);
        testValidAB(abTree, true);
    }

    @Test
    public void insert12() {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        abTree.insert(120);
        abTree.insert(163);
        abTree.insert(172);
        abTree.insert(130);
        abTree.insert(95);
        abTree.insert(156);
        abTree.insert(99);
        testValidAB(abTree, true);
    }

    @Test
    public void insert12False() {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        abTree.insert(120);
        abTree.insert(163);
        abTree.insert(172);
        abTree.insert(130);
        abTree.insert(95);
        abTree.insert(156);
        abTree.insert(99);
        abTree.getRoot().getChildren().add(new ABTreeLeaf(2, 4));
        testValidAB(abTree, false);
    }

    @Test
    void decreasing() {
        ABTree tree = new ABTree(3, 5);

        for (int i = 5; i > 0; i--) {
            tree.insert(i);
            assertTrue(tree.find(i));
            assertTrue(tree.validAB(), "\n\nFehler bei Baum:\n" + tree + "\n\n");
        }
    }

    @Test
    public void big() {
        ABTree tree = new ABTree(3, 5);

        for (int i = 0; i <= 500; i += 10) {
            tree.insert(i);
        }

        testValidAB(tree, true);
    }

    @Test
    public void invalidHeight() {
        ABTree tree = new ABTree(2, 4);
        ABTree stealer = new ABTree(2, 4);

        for (int i = 1; i <= 4; i++) {
            tree.insert(i);
        }
        stealer.insert(123);

        ((ABTreeInnerNode) tree.getRoot().getChildren().get(1)).getChildren().add(stealer.getRoot());

        testValidAB(tree, false);
    }

    public void testValidAB(ABTree abTree, boolean expected) {
        System.out.println("Test with tree:");
        System.out.println(abTree);
        assertEquals(expected, abTree.validAB());
    }
}
