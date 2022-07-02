package tests;

import gad.abtree.ABTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class removeTest {

    ABTree artemisTree;

    @BeforeEach
    public void artemisTreeSetup() {
        artemisTree = new ABTree(2, 4);
        int nodes[] = { 109, 23, 49, 180, 120, 163, 172, 130, 95, 156, 99, 39, 178, 197, 71, 194, 118, 88 };
        for (int i = 0; i < nodes.length; i++) {
            artemisTree.insert(nodes[i]);
        }
    }

    @Test
    public void empty() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        removeTester(10, "treeEmpty", false, abTree);
    }

    @Test
    public void singleTrue() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(10);
        removeTester(10, "treeEmpty", true, abTree);
    }

    @Test
    public void singleFalse() throws IOException {
        ABTree abTree = new ABTree(2, 4);
        abTree.insert(5);
        removeTester(10, "treeSingle", false, abTree);
    }

    @Test
    public void remove01() throws IOException {
        removeTester(95, "treeRemove1", true, artemisTree);
    }

    @Test
    public void remove02() throws IOException {
        artemisTree.remove(95);
        removeTester(194, "treeRemove2", true, artemisTree);
    }

    @Test
    public void remove04() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        removeTester(118, "treeRemove4", true, artemisTree);
    }

    @Test
    public void remove05() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        removeTester(109, "treeRemove5", true, artemisTree);
    }

    @Test
    public void remove06() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        artemisTree.remove(109);
        removeTester(178, "treeRemove6", true, artemisTree);
    }

    @Test
    public void remove07() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        artemisTree.remove(109);
        artemisTree.remove(178);
        removeTester(71, "treeRemove7", true, artemisTree);
    }

    @Test
    public void remove10() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        artemisTree.remove(109);
        artemisTree.remove(178);
        artemisTree.remove(71);
        artemisTree.remove(88);
        artemisTree.remove(197);
        removeTester(156, "treeRemove10_1", true, artemisTree);
    }

    @Test
    public void remove11() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        artemisTree.remove(109);
        artemisTree.remove(178);
        artemisTree.remove(71);
        artemisTree.remove(88);
        artemisTree.remove(197);
        artemisTree.remove(156);
        removeTester(99, "treeRemove11", true, artemisTree);
    }

    @Test
    public void remove12() throws IOException {
        artemisTree.remove(95);
        artemisTree.remove(194);
        artemisTree.remove(23);
        artemisTree.remove(118);
        artemisTree.remove(109);
        artemisTree.remove(178);
        artemisTree.remove(71);
        artemisTree.remove(88);
        artemisTree.remove(197);
        artemisTree.remove(156);
        artemisTree.remove(99);
        removeTester(163, "treeRemove12", true, artemisTree);
    }

    public void removeTester(int key, String expectedFile, boolean expectedReturnValue, ABTree abTree) throws IOException {
        System.out.println("Test with tree:");
        System.out.println(abTree);
        assertEquals(expectedReturnValue, abTree.remove(key), "remove hat nicht " + expectedReturnValue + " zurückgegeben");
        System.out.println("\nTree after remove(" + key + "): ");
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
