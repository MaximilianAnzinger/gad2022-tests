package tests;

import gad.fiboheap.FiboHeap;
import gad.fiboheap.FiboNode;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboHeapMergeTests {


    @Test
    public void testMergeEasy() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        fiboHeap1.setMin(new FiboNode(3));
        FiboNode fiboNodeChild = new FiboNode<>(4);
        fiboNodeChild.setUp(fiboHeap1.getMin());
        fiboHeap1.getMin().setRank(1);
        fiboNodeChild.setRank(0);

        fiboHeap1.getMin().setDown(fiboNodeChild);

        FiboHeap fiboHeap2 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode<>(10);
        FiboNode fiboNode2 = new FiboNode<>(20);
        fiboNode2.setPrev(fiboNode1);
        fiboNode1.setPrev(fiboNode2);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode1);
        fiboNode1.setRank(0);
        fiboNode2.setRank(0);

        fiboHeap2.setMin(fiboNode1);

        mergeTester(fiboHeap1, fiboHeap2, "tree1", 3);

        fiboHeap1 = new FiboHeap();
        fiboHeap1.setMin(new FiboNode(3));
        fiboNodeChild = new FiboNode<>(4);
        fiboNodeChild.setUp(fiboHeap1.getMin());
        fiboHeap1.getMin().setDown(fiboNodeChild);
        fiboHeap1.getMin().setRank(1);
        fiboNodeChild.setRank(0);

        fiboHeap2 = new FiboHeap();
        fiboNode1 = new FiboNode<>(15);
        fiboNode1.setPrev(fiboNode1);
        fiboNode1.setNext(fiboNode1);
        fiboNode1.setRank(0);

        fiboHeap2.setMin(fiboNode1);

        mergeTester(fiboHeap1, fiboHeap2, "tree2", 3);
    }

    @Test
    public void testMergeEmpty() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboHeap fiboHeap2 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode<>(5);
        FiboNode fiboNode2 = new FiboNode<>(10);
        fiboNode2.setPrev(fiboNode1);
        fiboNode1.setPrev(fiboNode2);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode1);
        fiboNode1.setRank(0);
        fiboNode2.setRank(0);

        fiboHeap2.setMin(fiboNode1);

        mergeTester(fiboHeap1, fiboHeap2, "tree3", 5);
    }

    @Test
    public void testMergeSingle() throws IOException {

        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode<>(2);
        FiboNode fiboNode2 = new FiboNode<>(3);
        fiboNode2.setPrev(fiboNode1);
        fiboNode1.setPrev(fiboNode2);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode1);
        fiboNode1.setRank(0);
        fiboNode2.setRank(0);

        fiboHeap1.setMin(fiboNode1);

        FiboHeap fiboHeap2 = new FiboHeap();
        fiboHeap2.setMin(new FiboNode(4));

        mergeTester(fiboHeap1, fiboHeap2, "tree5", 2);
    }

    @Test
    public void testMergeCorrectMin() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        fiboHeap1.setMin(new FiboNode(30));
        FiboNode fiboNodeChild = new FiboNode<>(40);
        fiboNodeChild.setUp(fiboHeap1.getMin());
        fiboHeap1.getMin().setRank(1);
        fiboNodeChild.setRank(0);

        fiboHeap1.getMin().setDown(fiboNodeChild);

        FiboHeap fiboHeap2 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode<>(10);
        FiboNode fiboNode2 = new FiboNode<>(20);
        fiboNode2.setPrev(fiboNode1);
        fiboNode1.setPrev(fiboNode2);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode1);
        fiboNode1.setRank(0);
        fiboNode2.setRank(0);

        fiboHeap2.setMin(fiboNode1);

        mergeTester(fiboHeap1, fiboHeap2, "tree4", 10);
    }

    public void mergeTester(FiboHeap fiboHeap1, FiboHeap fiboHeap2, String expectedFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/tests/resources/" + expectedFile));
        String expected = reader.readLine();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            expected =  expected + "\n" + line;
        }

        reader.close();

        assertEquals(expected, fiboHeap1.toString());
    }

    public void mergeTester(FiboHeap fiboHeap1, FiboHeap fiboHeap2, String expectedFile, int expectedMin) throws IOException {
        System.out.println("fiboHeap1: ");
        System.out.println(fiboHeap1.toString());
        System.out.println("\nfiboHeap2: ");
        System.out.println(fiboHeap2.toString());

        System.out.println("\n\nfiboHeap1 (merged): ");
        fiboHeap1.merge(fiboHeap2);
        System.out.println(fiboHeap1.toString());

        assertEquals(expectedMin, fiboHeap1.getMin().getValue(), "min ist nicht richtig gesetzt");
        mergeTester(fiboHeap1, fiboHeap2, expectedFile);
    }
}
