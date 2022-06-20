package tests;

import gad.fiboheap.FiboHeap;
import gad.fiboheap.FiboNode;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboHeapConsolidateTests {

    // Alle diese Tests erwarten, dass extractMin so implementiert ist, dass die consolidate()-Methode aufgerufen wird.

    @Test
    public void testConsolidateEasy() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(1);
        FiboNode fiboNode2 = new FiboNode(2);
        fiboNode1.setNext(fiboNode2);
        fiboNode2.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode2);
        fiboNode2.setPrev(fiboNode1);


        FiboNode fiboNodeChild = new FiboNode<>(4);
        fiboNode1.setDown(fiboNodeChild);
        fiboNodeChild.setUp(fiboNode1);
        fiboNode1.setRank(1);
        fiboNodeChild.setRank(0);

        fiboHeap1.setMin(fiboNode1);
        fiboHeap1.setSize(3);

        consolidateTester(fiboHeap1, "tree13", 1, 2);
    }

    @Test
    public void testConsolidateArtemisExample() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(1);
        FiboNode fiboNode2 = new FiboNode(2);
        FiboNode fiboNode3 = new FiboNode(3);
        FiboNode fiboNode4 = new FiboNode(4);
        FiboNode fiboNode5 = new FiboNode(5);
        FiboNode fiboNode6 = new FiboNode(6);
        FiboNode fiboNode7 = new FiboNode(7);
        FiboNode fiboNode8 = new FiboNode(8);
        FiboNode fiboNode9 = new FiboNode(9);
        FiboNode fiboNode10 = new FiboNode(10);
        FiboNode fiboNode11 = new FiboNode(11);


        fiboNode1.setNext(fiboNode11);
        fiboNode11.setNext(fiboNode9);
        fiboNode9.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode9);
        fiboNode9.setPrev(fiboNode11);
        fiboNode11.setPrev(fiboNode1);

        fiboNode2.setNext(fiboNode3);
        fiboNode3.setNext(fiboNode5);
        fiboNode5.setNext(fiboNode2);
        fiboNode2.setPrev(fiboNode5);
        fiboNode5.setPrev(fiboNode3);
        fiboNode3.setPrev(fiboNode2);

        fiboNode6.setNext(fiboNode7);
        fiboNode7.setNext(fiboNode6);
        fiboNode6.setPrev(fiboNode7);
        fiboNode7.setPrev(fiboNode6);

        fiboNode1.setDown(fiboNode2);
        fiboNode2.setUp(fiboNode1);
        fiboNode3.setUp(fiboNode1);
        fiboNode5.setUp(fiboNode1);

        fiboNode3.setDown(fiboNode4);
        fiboNode4.setUp(fiboNode3);

        fiboNode5.setDown(fiboNode6);
        fiboNode6.setUp(fiboNode5);
        fiboNode7.setUp(fiboNode5);

        fiboNode7.setDown(fiboNode8);
        fiboNode8.setUp(fiboNode7);

        fiboNode9.setDown(fiboNode10);
        fiboNode10.setUp(fiboNode9);

        fiboNode1.setRank(3);
        fiboNode3.setRank(1);
        fiboNode5.setRank(2);
        fiboNode7.setRank(1);
        fiboNode9.setRank(1);

        fiboHeap1.setMin(fiboNode1);
        fiboHeap1.setSize(11);

        consolidateTester(fiboHeap1, "tree14", 1, 2);
    }

    @Test
    public void testConsolidateArtemisExampleEdited1() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(1234);
        FiboNode fiboNode2 = new FiboNode(20);
        FiboNode fiboNode3 = new FiboNode(30);
        FiboNode fiboNode4 = new FiboNode(40);
        FiboNode fiboNode5 = new FiboNode(50);
        FiboNode fiboNode6 = new FiboNode(60);
        FiboNode fiboNode7 = new FiboNode(70);
        FiboNode fiboNode8 = new FiboNode(80);
        FiboNode fiboNode9 = new FiboNode(90);
        FiboNode fiboNode10 = new FiboNode(100);
        FiboNode fiboNode11 = new FiboNode(10);


        fiboNode1.setNext(fiboNode11);
        fiboNode11.setNext(fiboNode9);
        fiboNode9.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode9);
        fiboNode9.setPrev(fiboNode11);
        fiboNode11.setPrev(fiboNode1);

        fiboNode2.setNext(fiboNode3);
        fiboNode3.setNext(fiboNode5);
        fiboNode5.setNext(fiboNode2);
        fiboNode2.setPrev(fiboNode5);
        fiboNode5.setPrev(fiboNode3);
        fiboNode3.setPrev(fiboNode2);

        fiboNode6.setNext(fiboNode7);
        fiboNode7.setNext(fiboNode6);
        fiboNode6.setPrev(fiboNode7);
        fiboNode7.setPrev(fiboNode6);

        fiboNode1.setDown(fiboNode2);
        fiboNode2.setUp(fiboNode1);
        fiboNode3.setUp(fiboNode1);
        fiboNode5.setUp(fiboNode1);

        fiboNode3.setDown(fiboNode4);
        fiboNode4.setUp(fiboNode3);

        fiboNode5.setDown(fiboNode6);
        fiboNode6.setUp(fiboNode5);
        fiboNode7.setUp(fiboNode5);

        fiboNode7.setDown(fiboNode8);
        fiboNode8.setUp(fiboNode7);

        fiboNode9.setDown(fiboNode10);
        fiboNode10.setUp(fiboNode9);

        fiboNode1.setRank(3);
        fiboNode3.setRank(1);
        fiboNode5.setRank(2);
        fiboNode7.setRank(1);
        fiboNode9.setRank(1);

        fiboHeap1.setMin(fiboNode11);
        fiboHeap1.setSize(11);

        consolidateTester(fiboHeap1, "tree15", 10, 90);
    }

    @Test
    public void testConsolidateArtemisExampleEdited2() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode1 = new FiboNode(10);
        FiboNode fiboNode2 = new FiboNode(20);
        FiboNode fiboNode3 = new FiboNode(30);
        FiboNode fiboNode4 = new FiboNode(40);
        FiboNode fiboNode44 = new FiboNode(44);
        FiboNode fiboNode5 = new FiboNode(50);
        FiboNode fiboNode6 = new FiboNode(60);
        FiboNode fiboNode7 = new FiboNode(70);
        FiboNode fiboNode8 = new FiboNode(80);
        FiboNode fiboNode9 = new FiboNode(90);
        FiboNode fiboNode10 = new FiboNode(100);
        FiboNode fiboNode11 = new FiboNode(110);


        fiboNode1.setNext(fiboNode11);
        fiboNode11.setNext(fiboNode9);
        fiboNode9.setNext(fiboNode1);
        fiboNode1.setPrev(fiboNode9);
        fiboNode9.setPrev(fiboNode11);
        fiboNode11.setPrev(fiboNode1);

        fiboNode2.setNext(fiboNode3);
        fiboNode3.setNext(fiboNode5);
        fiboNode5.setNext(fiboNode2);
        fiboNode2.setPrev(fiboNode5);
        fiboNode5.setPrev(fiboNode3);
        fiboNode3.setPrev(fiboNode2);

        fiboNode6.setNext(fiboNode7);
        fiboNode7.setNext(fiboNode6);
        fiboNode6.setPrev(fiboNode7);
        fiboNode7.setPrev(fiboNode6);

        fiboNode1.setDown(fiboNode2);
        fiboNode2.setUp(fiboNode1);
        fiboNode3.setUp(fiboNode1);
        fiboNode5.setUp(fiboNode1);

        fiboNode3.setDown(fiboNode4);
        fiboNode4.setUp(fiboNode3);
        fiboNode4.setDown(fiboNode44);
        fiboNode44.setUp(fiboNode4);

        fiboNode5.setDown(fiboNode6);
        fiboNode6.setUp(fiboNode5);
        fiboNode7.setUp(fiboNode5);

        fiboNode7.setDown(fiboNode8);
        fiboNode8.setUp(fiboNode7);

        fiboNode9.setDown(fiboNode10);
        fiboNode10.setUp(fiboNode9);

        fiboNode1.setRank(3);
        fiboNode3.setRank(1);
        fiboNode4.setRank(1);
        fiboNode5.setRank(2);
        fiboNode7.setRank(1);
        fiboNode9.setRank(1);

        fiboHeap1.setMin(fiboNode1);
        fiboHeap1.setSize(11);

        consolidateTester(fiboHeap1, "tree16", 10, 20);
    }

    @Test
    public void testConsolidateEmpty() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        FiboNode fiboNode = new FiboNode(100);
        fiboHeap1.setMin(fiboNode);
        fiboHeap1.setSize(1);

        consolidateTester(fiboHeap1, "tree7", 100);
    }

    @Test
    public void testConsolidateNull() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();
        fiboHeap1.setSize(0);
        consolidateTester(fiboHeap1, "tree8");
    }

    @Test
    public void testConsolidateSmall1() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode = new FiboNode(1);
        FiboNode child = new FiboNode<>(2);

        child.setUp(fiboNode);
        fiboNode.setDown(child);
        fiboNode.setRank(1);

        fiboHeap1.setMin(fiboNode);
        fiboHeap1.setSize(2);

        consolidateTester(fiboHeap1, "tree17", 1, 2);
    }

    @Test
    public void testConsolidateSmall2() throws IOException {
        FiboHeap fiboHeap1 = new FiboHeap();

        FiboNode fiboNode = new FiboNode(2);
        FiboNode next = new FiboNode<>(1);

        fiboNode.setNext(next);
        fiboNode.setPrev(next);
        next.setNext(fiboNode);
        next.setPrev(fiboNode);

        fiboHeap1.setMin(next);
        fiboHeap1.setSize(2);

        consolidateTester(fiboHeap1, "tree17", 1, 2);
    }


    public void consolidateTester(FiboHeap fiboHeap, String expectedFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/tests/resources/" + expectedFile));
        String expected = reader.readLine();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            expected = expected + "\n" + line;
        }

        reader.close();

        assertEquals(expected, fiboHeap.toString());
    }

    public void consolidateTester(FiboHeap fiboHeap1, String expectedFile, int expectedValue, int expectedMin) throws IOException {
        System.out.println("fiboHeap: ");
        System.out.println(fiboHeap1.toString());

        System.out.println("\n\nfiboHeap (extracted Min): ");
        assertEquals(expectedValue, fiboHeap1.extractMin());
        System.out.println(fiboHeap1.toString());

        assertEquals(expectedMin, fiboHeap1.getMin().getValue(), "min ist nicht richtig gesetzt");
        consolidateTester(fiboHeap1, expectedFile);
    }

    public void consolidateTester(FiboHeap fiboHeap1, String expectedFile, int expectedValue) throws IOException {
        System.out.println("fiboHeap: ");
        System.out.println(fiboHeap1.toString());

        System.out.println("\n\nfiboHeap (extracted Min): ");
        assertEquals(expectedValue, fiboHeap1.extractMin());
        System.out.println(fiboHeap1.toString());

        consolidateTester(fiboHeap1, expectedFile);
    }
}
