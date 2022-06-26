package tests;

import gad.avl.AVLTree;
import gad.avl.AVLTreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testInsert {

    @BeforeAll
    static public void generalTests() {
        testAVLTreeNode testAVLTreeNode = new testAVLTreeNode();
        testAVLTreeNode.testConstructor();
    }

    @Test
    public void testInsertVerySimple() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                \t0 [label="0, b=0"];
                }""", avlTree.toString());
        avlTree.insert(-1);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                \t0 [label="0, b=-1"];
                \t0 -> 1 [label="l"];
                \t1 [label="-1, b=0"];
                }""", avlTree.toString());
        avlTree.insert(1);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                \t0 [label="0, b=0"];
                \t0 -> 1 [label="l"];
                \t1 [label="-1, b=0"];
                \t0 -> 2 [label="r"];
                \t2 [label="1, b=0"];
                }""", avlTree.toString());
    }
    @Test
    public void testInsertVerySimpleLeft() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                \t0 [label="0, b=0"];
                }""", avlTree.toString());
        avlTree.insert(-1);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                	0 [label="0, b=-1"];
                	0 -> 1 [label="l"];
                	1 [label="-1, b=0"];
                }""", avlTree.toString());
        avlTree.insert(-2);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                	0 [label="-1, b=0"];
                	0 -> 1 [label="l"];
                	1 [label="-2, b=0"];
                	0 -> 2 [label="r"];
                	2 [label="0, b=0"];
                }""", avlTree.toString());
    }

    @Test
    public void testInsertVerySimpleRight() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                \t0 [label="0, b=0"];
                }""", avlTree.toString());
        avlTree.insert(1);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                	0 [label="0, b=1"];
                	0 -> 1 [label="r"];
                	1 [label="1, b=0"];
                }""", avlTree.toString());
        avlTree.insert(2);
        assertTrue(avlTree.validAVL());
        System.out.println(avlTree);
        assertEquals("""
                digraph {
                	0 [label="1, b=0"];
                	0 -> 1 [label="l"];
                	1 [label="0, b=0"];
                	0 -> 2 [label="r"];
                	2 [label="2, b=0"];
                }""", avlTree.toString());
    }

    @Test
    public void testInsertSimple() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(2);
        AVLTreeNode left = new AVLTreeNode(1);
        AVLTreeNode right = new AVLTreeNode(3);

        root.setLeft(left);
        root.setRight(right);

        avlTree.setRoot(root);

        insertTester(4, "tree5", avlTree);
    }

    @Test
    public void testInsertRight() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(10);
        AVLTreeNode left = new AVLTreeNode(5);
        AVLTreeNode right = new AVLTreeNode(20);
        AVLTreeNode childl = new AVLTreeNode(15);
        AVLTreeNode childr = new AVLTreeNode(25);

        root.setLeft(left);
        root.setRight(right);
        right.setLeft(childl);
        right.setRight(childr);

        root.setBalance(1);

        avlTree.setRoot(root);

        insertTester(30, "tree4", avlTree);
    }

    @Test
    public void testInsertRightLeft() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(10);
        AVLTreeNode left = new AVLTreeNode(5);
        AVLTreeNode right = new AVLTreeNode(20);
        AVLTreeNode childL = new AVLTreeNode(15);
        AVLTreeNode childR = new AVLTreeNode(25);

        root.setLeft(left);
        root.setRight(right);
        right.setLeft(childL);
        right.setRight(childR);

        root.setBalance(1);

        avlTree.setRoot(root);

        insertTester(18, "tree6", avlTree);
    }

    @Test
    public void testInsertLeftRight1() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(20);
        AVLTreeNode left = new AVLTreeNode(10);
        AVLTreeNode right = new AVLTreeNode(30);
        AVLTreeNode childL = new AVLTreeNode(5);
        AVLTreeNode childR = new AVLTreeNode(15);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(childL);
        left.setRight(childR);

        root.setBalance(1);

        avlTree.setRoot(root);

        insertTester(18, "tree7", avlTree);
    }

    @Test
    public void testInsertLeftRight2() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(20);
        AVLTreeNode left = new AVLTreeNode(10);
        AVLTreeNode right = new AVLTreeNode(30);
        AVLTreeNode childL = new AVLTreeNode(5);
        AVLTreeNode childR = new AVLTreeNode(15);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(childL);
        left.setRight(childR);

        root.setBalance(1);

        avlTree.setRoot(root);

        insertTester(13, "tree8", avlTree);
    }

    @Test
    public void testInsertLeft() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(10);
        AVLTreeNode left = new AVLTreeNode(5);
        AVLTreeNode right = new AVLTreeNode(20);
        AVLTreeNode childl = new AVLTreeNode(3);
        AVLTreeNode childr = new AVLTreeNode(8);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(childl);
        left.setRight(childr);

        root.setBalance(-1);

        avlTree.setRoot(root);

        insertTester(1, "tree3", avlTree);
    }

    @Test
    public void testInsertSingle() throws IOException {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(1);
        avlTree.setRoot(root);

        insertTester(1, "tree2", avlTree);
    }

    @Test
    public void testInsertNull() throws IOException {
        AVLTree avlTree = new AVLTree();
        insertTester(1, "tree1", avlTree);
    }

    public void insertTester(int key, String expectedFile, AVLTree avlTree) throws IOException {
        System.out.println("Test with tree:");
        System.out.println(avlTree);
        avlTree.insert(key);
        System.out.println("\nTree after insert(key): " + key);
        System.out.println(avlTree);

        BufferedReader reader = new BufferedReader(new FileReader("" + expectedFile));
        StringBuilder expected = new StringBuilder(reader.readLine());

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            expected.append("\n").append(line);
        }

        reader.close();
        expected = new StringBuilder(expected.toString().replaceAll("\n", System.lineSeparator()));

        assertEquals(expected.toString(), avlTree.toString());

        assertTrue(avlTree.validAVL(), "Deine validAVL behauptet dass der Baum nicht korrekt ist");
    }
}
