package tests;

import gad.fiboheap.FiboHeap;
import gad.fiboheap.FiboNode;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboHeapExtractMinTests {

    // Alle diese Tests müssen ohne die consolidate()-Methode aufgerufen werden.
    // Also einfach zum Testen den Methodenaufruf auskommentieren.

    @Test
    public void testExtractMinEasy() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(1);
        FiboNode fiboNode2 = new FiboNode(2);
        FiboNode fiboNode3 = new FiboNode(3);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode3);
        fiboNode3.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode3);
        fiboNode2.setPrev(fiboNode1);
        fiboNode3.setPrev(fiboNode2);


        FiboNode fiboNodeChild = new FiboNode<>(4);
        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNode1.setRank(1);
        fiboNodeChild.setRank(0);

        fiboHeap1.setMin(fiboNode1);
		fiboHeap1.setSize(4);

        extractMinTester(fiboHeap1, "tree6", 1, 2);
    }

    @Test
    public void testExtractMinHard() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(10);
        FiboNode fiboNode2 = new FiboNode(20);
        FiboNode fiboNode3 = new FiboNode(30);
        FiboNode fiboNode4 = new FiboNode(40);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode3);
        fiboNode3.setNext(fiboNode4);
        fiboNode4.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode4);
        fiboNode2.setPrev(fiboNode1);
        fiboNode3.setPrev(fiboNode2);
        fiboNode4.setPrev(fiboNode3);


        FiboNode fiboNodeChild = new FiboNode<>(12);
        FiboNode fiboNode13 = new FiboNode(13);
        FiboNode fiboNode14 = new FiboNode(14);
        fiboNodeChild.setNext(fiboNode13);
        fiboNode13.setNext(fiboNode14);
        fiboNode14.setNext(fiboNodeChild);
        fiboNodeChild.setPrev(fiboNode14);
        fiboNode14.setPrev(fiboNode13);
        fiboNode13.setPrev(fiboNodeChild);

        FiboNode fiboNodeChildChild = new FiboNode<>(28);
        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setDown(fiboNodeChildChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNodeChildChild.setUp(fiboNodeChild);
        fiboNode1.setRank(3);
        fiboNodeChild.setRank(1);

        fiboHeap1.setMin(fiboNode1);

        extractMinTester(fiboHeap1, "tree9", 10, 12);
    }

    @Test
    public void testExtractMinOnlyDown() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode(10);

        FiboNode fiboNodeChild = new FiboNode<>(12);
        FiboNode fiboNodeChildChild = new FiboNode<>(28);

        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setDown(fiboNodeChildChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNodeChildChild.setUp(fiboNodeChild);
        fiboNode1.setRank(1);
        fiboNodeChild.setRank(1);

        fiboHeap1.setMin(fiboNode1);

        extractMinTester(fiboHeap1, "tree10", 10, 12);
    }

    @Test
    public void testExtractMinOnlyDown2() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode(10);

        FiboNode fiboNodeChild = new FiboNode<>(12);
        FiboNode fiboNode13 = new FiboNode<>(13);
        FiboNode fiboNodeChildChild = new FiboNode<>(28);

        fiboNodeChild.setNext(fiboNode13);
        fiboNodeChild.setPrev(fiboNode13);
        fiboNode13.setNext(fiboNodeChild);
        fiboNode13.setPrev(fiboNodeChild);

        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setDown(fiboNodeChildChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNodeChildChild.setUp(fiboNodeChild);
        fiboNode1.setRank(1);
        fiboNodeChild.setRank(1);

        fiboHeap1.setMin(fiboNode1);

        extractMinTester(fiboHeap1, "tree11", 10, 12);
    }

    @Test
    public void testExtractMinSmall() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode1 = new FiboNode(10);
        FiboNode fiboNode11 = new FiboNode(11);
        fiboNode1.setNext(fiboNode11);
        fiboNode1.setPrev(fiboNode11);
        fiboNode11.setNext(fiboNode1);
        fiboNode11.setPrev(fiboNode1);

        FiboNode fiboNodeChild = new FiboNode<>(12);
        FiboNode fiboNode13 = new FiboNode<>(13);
        FiboNode fiboNodeChildChild = new FiboNode<>(28);

        fiboNodeChild.setNext(fiboNode13);
        fiboNodeChild.setPrev(fiboNode13);
        fiboNode13.setNext(fiboNodeChild);
        fiboNode13.setPrev(fiboNodeChild);

        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setDown(fiboNodeChildChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNodeChildChild.setUp(fiboNodeChild);
        fiboNode1.setRank(1);
        fiboNodeChild.setRank(1);

        fiboHeap1.setMin(fiboNode1);

        extractMinTester(fiboHeap1, "tree12", 10, 11);
    }

    @Test
    public void testExtractMinEmpty() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode = new FiboNode(100);
        fiboHeap1.setMin(fiboNode);

        extractMinTester(fiboHeap1, "tree7", 100);
    }

    @Test
    public void testExtractMinNull() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        extractMinTester(fiboHeap1, "tree8");
    }

    public void extractMinTester(FiboHeap fiboHeap, String expectedFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/tests/resources/" + expectedFile));
        String expected = reader.readLine();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            expected =  expected + "\n" + line;
        }

        reader.close();

        assertEquals(expected, fiboHeap.toString());
    }

    public void extractMinTester(FiboHeap fiboHeap1, String expectedFile, int expectedValue, int expectedMin) throws IOException {
        System.out.println("fiboHeap: ");
        System.out.println(fiboHeap1.toString());

        System.out.println("\n\nfiboHeap (extracted Min): ");
        assertEquals(expectedValue, fiboHeap1.extractMin());
        System.out.println(fiboHeap1.toString());

        assertEquals(expectedMin, fiboHeap1.getMin().getValue(), "min ist nicht richtig gesetzt");
        extractMinTester(fiboHeap1, expectedFile);
    }

    public void extractMinTester(FiboHeap fiboHeap1, String expectedFile, int expectedValue) throws IOException {
        System.out.println("fiboHeap: ");
        System.out.println(fiboHeap1.toString());

        System.out.println("\n\nfiboHeap (extracted Min): ");
        assertEquals(expectedValue, fiboHeap1.extractMin());
        System.out.println(fiboHeap1.toString());

        extractMinTester(fiboHeap1, expectedFile);
    }
}
