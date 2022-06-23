package tests;

import gad.avl.AVLTree;
import gad.avl.AVLTreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testValidAVLNull() {
        AVLTree avlTree = new AVLTree();
        validAVLTester(true, avlTree);
    }

    public void validAVLTester(boolean expected, AVLTree avlTree) {
        System.out.println("Test with tree:");
        System.out.println(avlTree);

        assertEquals(expected, avlTree.validAVL());
    }
}
