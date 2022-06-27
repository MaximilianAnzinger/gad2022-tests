package tests;

import gad.avl.AVLTree;
import gad.avl.AVLTreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class testValidAVL {

    @BeforeAll
    public static void generalTests() {
        testAVLTreeNode testAVLTreeNode = new testAVLTreeNode();
        testAVLTreeNode.testConstructor();
    }

    @Test
    public void testValidAVLSimple1() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(1);
        AVLTreeNode left = new AVLTreeNode(2);
        AVLTreeNode right = new AVLTreeNode(3);

        root.setLeft(left);
        root.setRight(right);

        avlTree.setRoot(root);

        validAVLTester(false, avlTree);
    }

    @Test
    public void testValidAVLSimple2() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(3);
        AVLTreeNode left = new AVLTreeNode(2);
        AVLTreeNode right = new AVLTreeNode(1);

        root.setLeft(left);
        root.setRight(right);

        avlTree.setRoot(root);

        validAVLTester(false, avlTree);
    }

    @Test
    public void testValidAVLSame1() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(3);
        AVLTreeNode right = new AVLTreeNode(3);

        root.setRight(right);
        root.setBalance(1);

        avlTree.setRoot(root);

        validAVLTester(true, avlTree);
    }

    @Test
    public void testValidAVLSame2() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(3);
        AVLTreeNode left = new AVLTreeNode(3);

        root.setLeft(left);
        root.setBalance(-1);

        avlTree.setRoot(root);

        validAVLTester(true, avlTree);
    }

    @Test
    public void testValidAVLSingle() {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(1);
        avlTree.setRoot(root);

        validAVLTester(true, avlTree);
    }

    @Test
    public void testValidAVLNull() { //changed this test in order to make it work without checking for a specific return value (undefined)
        AVLTree avlTree = new AVLTree();
        printTree(avlTree);
        assertDoesNotThrow((Executable) avlTree::validAVL, "Unexpected Exception when calling validAVL on an empty Tree");
    }


    @Test
    void invalidAVLEdgeCase1() {
        AVLTree tree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(25);
        AVLTreeNode left = new AVLTreeNode(20);
        AVLTreeNode right = new AVLTreeNode(26);
        root.setLeft(left);
        root.setRight(right);
        tree.setRoot(root);

        left.setLeft(new AVLTreeNode(19));
        left.setRight(new AVLTreeNode(23));

        right.setRight(new AVLTreeNode(27));
        right.setLeft(new AVLTreeNode(24));

        printTree(tree);

        assertFalse(tree.validAVL(), "Der Baum war nicht richtig sortiert, wurde aber als richtig erkannt.");
    }

    @Test
    void invalidAVLEdgeCase2() {
        AVLTree tree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(25);
        AVLTreeNode left = new AVLTreeNode(20);
        AVLTreeNode right = new AVLTreeNode(26);
        root.setLeft(left);
        root.setRight(right);
        tree.setRoot(root);

        left.setLeft(new AVLTreeNode(19));
        left.setRight(new AVLTreeNode(200));

        right.setRight(new AVLTreeNode(27));
        right.setLeft(new AVLTreeNode(26));

        printTree(tree);

        assertFalse(tree.validAVL(), "Der Baum war nicht richtig sortiert, wurde aber als richtig erkannt.");
    }


    public void validAVLTester(boolean expected, AVLTree avlTree) {
        printTree(avlTree);
        assertEquals(expected, avlTree.validAVL());
    }

    public void printTree(AVLTree avlTree) {
        System.out.println("Test with tree:");
        System.out.println(avlTree);
    }
}
