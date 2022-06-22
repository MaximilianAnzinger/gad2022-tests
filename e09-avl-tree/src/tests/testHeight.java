package tests;

import gad.avl.AVLTree;
import gad.avl.AVLTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testHeight {

    @BeforeEach
    public void generalTests() {
        testAVLTreeNode testAVLTreeNode = new testAVLTreeNode();
        testAVLTreeNode.testConstructor();
    }

    @Test
    public void testHeightSimple() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(1);
        AVLTreeNode left = new AVLTreeNode(2);
        AVLTreeNode right = new AVLTreeNode(3);

        root.setLeft(left);
        root.setRight(right);

        avlTree.setRoot(root);

        heightTester(2, avlTree);
    }

    @Test
    public void testHeightSingle() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(1);
        avlTree.setRoot(root);

        heightTester(1, avlTree);
    }

    @Test
    public void testHeightNull() {
        AVLTree avlTree = new AVLTree();
        heightTester(0, avlTree);
    }

    public void heightTester(int expected, AVLTree avlTree) {
        System.out.println("Test with tree:");
        System.out.println(avlTree);

        assertEquals(expected, avlTree.height());
    }
}
