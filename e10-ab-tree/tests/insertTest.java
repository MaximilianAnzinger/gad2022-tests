package tests;

import gad.abtree.ABTree;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class insertTest {

    @Test
    public void insert01() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        insertTester(109, "tree1", abTree);
    }

    @Test
    public void insert02() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        insertTester(23, "tree2", abTree);
    }

    @Test
    public void insert03() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        insertTester(49, "tree3", abTree);
    }

    @Test
    public void insert04() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        insertTester(180, "tree4", abTree);
    }

    @Test
    public void insert05() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        insertTester(120, "tree5", abTree);
    }

    @Test
    public void insert06() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        abTree.insert(120);
        insertTester(163, "tree6", abTree);
    }

    @Test
    public void insert07() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        abTree.insert(120);
        abTree.insert(163);
        insertTester(172, "tree7", abTree);
    }

    @Test
    public void insert08() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(49);
        abTree.insert(180);
        abTree.insert(120);
        abTree.insert(163);
        abTree.insert(172);
        insertTester(130, "tree8", abTree);
    }

    @Test
    public void insert10() throws IOException {
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
        insertTester(156, "tree10", abTree);
    }

    @Test
    public void insert11() throws IOException {
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
        insertTester(99, "tree11", abTree);
    }

    @Test
    public void insert12() throws IOException {
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
        insertTester(39, "tree12", abTree);
    }

    @Test
    public void insertSameEasy() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(10);
        insertTester(10, "treeSameEasy", abTree);
    }

    @Test
    public void insertSameHard() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(109);
        abTree.insert(23);
        abTree.insert(10);
        abTree.insert(49);
        abTree.insert(15);
        abTree.insert(180);
        abTree.insert(120);
        abTree.insert(163);
        abTree.insert(172);
        abTree.insert(130);
        abTree.insert(95);
        abTree.insert(156);
        abTree.insert(99);
        insertTester(10, "treeSameHard", abTree);
    }

    public void insertTester(int key, String expectedFile, ABTree abTree) throws IOException {
        System.out.println("Test with tree:");
        System.out.println(abTree);
        abTree.insert(key);
        System.out.println("\nTree after insert(" + key + "): ");
        System.out.println(abTree);

        BufferedReader reader = new BufferedReader(new FileReader("src/tests/resources/" + expectedFile));
        StringBuilder expected = new StringBuilder(reader.readLine());

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            expected.append("\n").append(line);
        }

        reader.close();
        expected = new StringBuilder(expected.toString().replaceAll("\n", System.lineSeparator()));

        assertEquals(expected.toString(), abTree.toString());
    }
}
