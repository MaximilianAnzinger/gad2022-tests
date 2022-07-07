package tests;

import gad.bfs.BFS;
import gad.bfs.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testSssp {

    @Test
    public void testSimple() {
        Graph graph = new Graph();
        BFS bfs = new BFS();

        graph.addNode();
        for (int i = 0; i < 10; i++) {
            graph.addNode();
            graph.addEdge(i, i + 1);
        }

        bfs.sssp(graph, 0);
        for (int i = 0; i < 11; i++) {
            assertEquals(i, bfs.getDepth(i));
            if (i < 2) {
                assertEquals(0, bfs.getParent(i));
            } else {
                assertEquals(i - 1, bfs.getParent(i));
            }
            assertTrue(bfs.visitedNode(i));
        }
    }

    @Test
    public void testGetter() {
        BFS bfs = new BFS();

        assertDoesNotThrow(() -> bfs.getMarked());
    }

    @Test
    public void testEDGE() {
        Graph graph = new Graph();
        BFS bfs = new BFS();

        graph.addNode();
        for (int i = 0; i < 10; i++) {
            graph.addNode();
            graph.addEdge(i, i + 1);
        }

        bfs.sssp(graph, 0);

        for (int i = 0; i < bfs.getMarked().length; i++) {
            bfs.getMarked()[i] = false;
        }

        for (int i = 0; i < 11; i++) {
            assertEquals(-1, bfs.getDepth(i));
            assertEquals(-1, bfs.getParent(i));
        }
    }
}
