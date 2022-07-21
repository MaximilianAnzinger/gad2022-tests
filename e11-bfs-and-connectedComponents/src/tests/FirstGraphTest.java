package gad.tests;

import gad.bfs.BFS;
import gad.bfs.ConnectedComponents;
import gad.bfs.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FirstGraphTest {

    public static Graph graphFromArray(int... nodes) {
        Graph graph = new Graph();
        if (nodes != null && nodes.length > 0) {
            int size = Arrays.stream(nodes).max().orElse(0) + 1;
            for (int i = 0; i < size; i++) {
                graph.addNode();
            }
            for (int i = 1; i < nodes.length; i++) {
                while (i < nodes.length && nodes[i] < 0) {
                    i += 2;
                }
                if (i >= nodes.length) {
                    break;
                }
                graph.addEdge(nodes[i - 1], nodes[i]);
            }
        }
        return graph;
    }

    @Test
    void incrementalGraphTest1() {
        Graph graph = graphFromArray(9, 19, 29);
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(28, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(0, 2, 4, 6, 8, 10, -1, 1, 3, 5, 7, 9, 11);
        assertEquals(2, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(1, 5, 10, 1, -1, 2, 6, 14, 2, -1, 7, 11, 13, 7);
        assertEquals(9, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void edgeGraphTest6() {
        Graph graph = graphFromArray(9, 19, 29);
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(28, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(15);
        assertEquals(16, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(0, -1, 1, 2, -1, 3, 4, 5, -1, 6, 7, 8, 9, -1, 10, 11, 12, 13, 14);
        assertEquals(5, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void edgeGraphTest5() {
        Graph graph = graphFromArray(0, -1, 1, 2, 3, 4, 5, 6, -1, 4, 6, 2);
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(2, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(0, 0, 7, 7, -1, 1, 2, 3, 4, 5, 6, -1, 4, 6, 2);
        assertEquals(2, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(0, 0, 7, 7, -1, 1, 2, 3, 4, 5, 6, -1, 4, 6, 2, -1, 8, 9, 10, 11, 12, 13, 8);
        assertEquals(3, connectedComponents.countConnectedComponents(graph));
        graph = graphFromArray(0, 0, 7, 7, -1, 1, 2, 3, 4, 5, 6, -1, 4, 6, 2, -1, 8, 9, 10, 11, 12, 13, 8, -1, 14, -1, 15, -1, 16, 16);
        assertEquals(6, connectedComponents.countConnectedComponents(graph));
    }


    @Test
    void edgeGraphTest4() {
        int size = 1000;
        int[] nodes = new int[2 * size];
        int[] pivots = new int[]{0, 5, 15, 50, 100, 200, 301, 509, 999};
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = (i + 1) % 2 == 0 ? -1 : i / 2;
        }
        Graph graph = graphFromArray(nodes);
        BFS bfs = new BFS();
        for (int pivot : pivots) {
            bfs.sssp(graph, pivot);
            for (int i = 0; i < size; i++) {
                if (i != pivot) {
                    assertEquals(-1, bfs.getDepth(i));
                    assertEquals(-1, bfs.getParent(i));
                } else {
                    assertEquals(0, bfs.getDepth(i));
                    assertEquals(pivot, bfs.getParent(i));
                }
            }
        }
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(size, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void edgeGraphTest3() {
        int size = 1000;
        int[] nodes = new int[3 * size];
        int[] pivots = new int[]{0, 5, 15, 50, 100, 200, 301, 509, 999};
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = (i + 1) % 3 == 0 ? -1 : i / 3;
        }
        Graph graph = graphFromArray(nodes);
        BFS bfs = new BFS();
        for (int pivot : pivots) {
            bfs.sssp(graph, pivot);
            for (int i = 0; i < size; i++) {
                if (i != pivot) {
                    assertEquals(-1, bfs.getDepth(i));
                    assertEquals(-1, bfs.getParent(i));
                } else {
                    assertEquals(0, bfs.getDepth(i));
                    assertEquals(pivot, bfs.getParent(i));
                }
            }
        }
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(size, connectedComponents.countConnectedComponents(graph));
    }

    @SuppressWarnings("all")
    @Test
    void edgeGraphTest2() {
        Graph graph = graphFromArray(0, 5, 1, 4, 2, 3);
        BFS bfs = new BFS();

        bfs.sssp(graph, 0);
        assertEquals(0, bfs.getDepth(0));
        assertEquals(0, bfs.getParent(0));
        assertEquals(2, bfs.getDepth(1));
        assertEquals(5, bfs.getParent(1));
        assertEquals(4, bfs.getDepth(2));
        assertEquals(4, bfs.getParent(2));
        assertEquals(5, bfs.getDepth(3));
        assertEquals(2, bfs.getParent(3));
        assertEquals(3, bfs.getDepth(4));
        assertEquals(1, bfs.getParent(4));
        assertEquals(1, bfs.getDepth(5));
        assertEquals(0, bfs.getParent(5));

        bfs.sssp(graph, 1);
        assertEquals(2, bfs.getDepth(0));
        assertEquals(5, bfs.getParent(0));
        assertEquals(0, bfs.getDepth(1));
        assertEquals(1, bfs.getParent(1));
        assertEquals(2, bfs.getDepth(2));
        assertEquals(4, bfs.getParent(2));
        assertEquals(3, bfs.getDepth(3));
        assertEquals(2, bfs.getParent(3));
        assertEquals(1, bfs.getDepth(4));
        assertEquals(1, bfs.getParent(4));
        assertEquals(1, bfs.getDepth(5));
        assertEquals(1, bfs.getParent(5));

        bfs.sssp(graph, 3);
        assertEquals(5, bfs.getDepth(0));
        assertEquals(5, bfs.getParent(0));
        assertEquals(3, bfs.getDepth(1));
        assertEquals(4, bfs.getParent(1));
        assertEquals(1, bfs.getDepth(2));
        assertEquals(3, bfs.getParent(2));
        assertEquals(0, bfs.getDepth(3));
        assertEquals(3, bfs.getParent(3));
        assertEquals(2, bfs.getDepth(4));
        assertEquals(2, bfs.getParent(4));
        assertEquals(4, bfs.getDepth(5));
        assertEquals(1, bfs.getParent(5));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void edgeGraphTest1() {
        Graph graph = graphFromArray(0, 1, 2, 3, 1, -1, 8, 7, 10, 9, 11, 10, -1, 7, 11, -1, 5, 4, 6);
        BFS bfs = new BFS();
        bfs.sssp(graph, 0);
        assertEquals(0, bfs.getDepth(0));
        assertEquals(0, bfs.getParent(0));
        assertEquals(1, bfs.getDepth(1));
        assertEquals(0, bfs.getParent(1));
        assertEquals(2, bfs.getDepth(2));
        assertEquals(1, bfs.getParent(2));
        assertEquals(2, bfs.getDepth(3));
        assertEquals(1, bfs.getParent(3));
        assertEquals(-1, bfs.getDepth(4));
        assertEquals(-1, bfs.getParent(4));
        assertEquals(-1, bfs.getDepth(5));
        assertEquals(-1, bfs.getParent(5));
        assertEquals(-1, bfs.getDepth(6));
        assertEquals(-1, bfs.getParent(6));
        assertEquals(-1, bfs.getDepth(7));
        assertEquals(-1, bfs.getParent(7));
        assertEquals(-1, bfs.getDepth(8));
        assertEquals(-1, bfs.getParent(8));
        assertEquals(-1, bfs.getDepth(9));
        assertEquals(-1, bfs.getParent(9));
        assertEquals(-1, bfs.getDepth(10));
        assertEquals(-1, bfs.getParent(10));
        assertEquals(-1, bfs.getDepth(11));
        assertEquals(-1, bfs.getParent(11));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(3, connectedComponents.countConnectedComponents(graph));
    }


    @Test
    void graphWriteTest5() {
        Graph graph = sampleGraph7();
        BFS bfs = new BFS();
        bfs.sssp(graph, 0);
        assertEquals(0, bfs.getDepth(0));
        assertEquals(0, bfs.getParent(0));
        assertEquals(2, bfs.getDepth(1));
        assertEquals(5, bfs.getParent(1));
        assertEquals(4, bfs.getDepth(2));
        assertEquals(4, bfs.getParent(2));
        assertEquals(5, bfs.getDepth(3));
        assertEquals(2, bfs.getParent(3));
        assertEquals(3, bfs.getDepth(4));
        assertEquals(1, bfs.getParent(4));
        assertEquals(1, bfs.getDepth(5));
        assertEquals(0, bfs.getParent(5));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }


    @Test
    void graphWriteTest4() {
        Graph graph = sampleGraph1();
        BFS bfs = new BFS();
        bfs.sssp(graph, 5);
        assertEquals(2, bfs.getDepth(0));
        assertEquals(4, bfs.getParent(0));
        assertEquals(2, bfs.getDepth(1));
        assertEquals(2, bfs.getParent(1));
        assertEquals(1, bfs.getDepth(2));
        assertEquals(5, bfs.getParent(2));
        assertEquals(2, bfs.getDepth(3));
        assertEquals(2, bfs.getParent(3));
        assertEquals(1, bfs.getDepth(4));
        assertEquals(5, bfs.getParent(4));
        assertEquals(1, bfs.getDepth(6));
        assertEquals(5, bfs.getParent(6));
        assertEquals(2, bfs.getDepth(7));
        assertEquals(6, bfs.getParent(7));
        assertEquals(2, bfs.getDepth(8));
        assertEquals(4, bfs.getParent(8));
        assertEquals(1, bfs.getDepth(9));
        assertEquals(5, bfs.getParent(9));
        assertEquals(2, bfs.getDepth(10));
        assertEquals(9, bfs.getParent(10));
        assertEquals(2, bfs.getDepth(11));
        assertEquals(2, bfs.getParent(11));
        assertEquals(2, bfs.getDepth(12));
        assertEquals(4, bfs.getParent(12));
        assertEquals(2, bfs.getDepth(13));
        assertEquals(2, bfs.getParent(13));
        assertEquals(2, bfs.getDepth(14));
        assertEquals(9, bfs.getParent(14));
        assertEquals(2, bfs.getDepth(15));
        assertEquals(2, bfs.getParent(15));
        assertEquals(2, bfs.getDepth(16));
        assertEquals(6, bfs.getParent(16));
        assertEquals(2, bfs.getDepth(17));
        assertEquals(4, bfs.getParent(17));
        assertEquals(1, bfs.getDepth(18));
        assertEquals(5, bfs.getParent(18));
        assertEquals(2, bfs.getDepth(19));
        assertEquals(2, bfs.getParent(19));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void graphWriteTest3() {
        Graph graph = sampleGraph1();
        BFS bfs = new BFS();
        bfs.sssp(graph, 15);
        assertEquals(2, bfs.getDepth(0));
        assertEquals(18, bfs.getParent(0));
        assertEquals(2, bfs.getDepth(1));
        assertEquals(2, bfs.getParent(1));
        assertEquals(1, bfs.getDepth(2));
        assertEquals(15, bfs.getParent(2));
        assertEquals(2, bfs.getDepth(3));
        assertEquals(2, bfs.getParent(3));
        assertEquals(2, bfs.getDepth(4));
        assertEquals(12, bfs.getParent(4));
        assertEquals(2, bfs.getDepth(5));
        assertEquals(2, bfs.getParent(5));
        assertEquals(2, bfs.getDepth(6));
        assertEquals(2, bfs.getParent(6));
        assertEquals(2, bfs.getDepth(7));
        assertEquals(13, bfs.getParent(7));
        assertEquals(3, bfs.getDepth(8));
        assertEquals(4, bfs.getParent(8));
        assertEquals(2, bfs.getDepth(9));
        assertEquals(14, bfs.getParent(9));
        assertEquals(3, bfs.getDepth(10));
        assertEquals(11, bfs.getParent(10));
        assertEquals(2, bfs.getDepth(11));
        assertEquals(2, bfs.getParent(11));
        assertEquals(1, bfs.getDepth(12));
        assertEquals(15, bfs.getParent(12));
        assertEquals(1, bfs.getDepth(13));
        assertEquals(15, bfs.getParent(13));
        assertEquals(1, bfs.getDepth(14));
        assertEquals(15, bfs.getParent(14));
        assertEquals(1, bfs.getDepth(16));
        assertEquals(15, bfs.getParent(16));
        assertEquals(2, bfs.getDepth(17));
        assertEquals(16, bfs.getParent(17));
        assertEquals(1, bfs.getDepth(18));
        assertEquals(15, bfs.getParent(18));
        assertEquals(2, bfs.getDepth(19));
        assertEquals(2, bfs.getParent(19));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void graphWriteTest2() {
        Graph graph = sampleGraph1();
        BFS bfs = new BFS();
        bfs.sssp(graph, 10);
        assertEquals(2, bfs.getDepth(0));
        assertEquals(9, bfs.getParent(0));
        assertEquals(3, bfs.getDepth(1));
        assertEquals(0, bfs.getParent(1));
        assertEquals(2, bfs.getDepth(2));
        assertEquals(11, bfs.getParent(2));
        assertEquals(2, bfs.getDepth(3));
        assertEquals(9, bfs.getParent(3));
        assertEquals(3, bfs.getDepth(4));
        assertEquals(0, bfs.getParent(4));
        assertEquals(2, bfs.getDepth(5));
        assertEquals(9, bfs.getParent(5));
        assertEquals(3, bfs.getDepth(6));
        assertEquals(5, bfs.getParent(6));
        assertEquals(2, bfs.getDepth(7));
        assertEquals(11, bfs.getParent(7));
        assertEquals(2, bfs.getDepth(8));
        assertEquals(9, bfs.getParent(8));
        assertEquals(1, bfs.getDepth(9));
        assertEquals(10, bfs.getParent(9));
        assertEquals(1, bfs.getDepth(11));
        assertEquals(10, bfs.getParent(11));
        assertEquals(2, bfs.getDepth(12));
        assertEquals(11, bfs.getParent(12));
        assertEquals(3, bfs.getDepth(13));
        assertEquals(14, bfs.getParent(13));
        assertEquals(2, bfs.getDepth(14));
        assertEquals(9, bfs.getParent(14));
        assertEquals(3, bfs.getDepth(15));
        assertEquals(14, bfs.getParent(15));
        assertEquals(3, bfs.getDepth(16));
        assertEquals(17, bfs.getParent(16));
        assertEquals(2, bfs.getDepth(17));
        assertEquals(9, bfs.getParent(17));
        assertEquals(3, bfs.getDepth(18));
        assertEquals(0, bfs.getParent(18));
        assertEquals(3, bfs.getDepth(19));
        assertEquals(0, bfs.getParent(19));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }

    @Test
    void graphWriteTest1() {
        Graph graph = sampleGraph1();
        BFS bfs = new BFS();
        bfs.sssp(graph, 0);
        assertEquals(1, bfs.getDepth(1));
        assertEquals(0, bfs.getParent(1));
        assertEquals(2, bfs.getDepth(2));
        assertEquals(1, bfs.getParent(2));
        assertEquals(2, bfs.getDepth(3));
        assertEquals(4, bfs.getParent(3));
        assertEquals(1, bfs.getDepth(4));
        assertEquals(0, bfs.getParent(4));
        assertEquals(2, bfs.getDepth(5));
        assertEquals(4, bfs.getParent(5));
        assertEquals(2, bfs.getDepth(6));
        assertEquals(7, bfs.getParent(6));
        assertEquals(1, bfs.getDepth(7));
        assertEquals(0, bfs.getParent(7));
        assertEquals(1, bfs.getDepth(8));
        assertEquals(0, bfs.getParent(8));
        assertEquals(1, bfs.getDepth(9));
        assertEquals(0, bfs.getParent(9));
        assertEquals(2, bfs.getDepth(10));
        assertEquals(9, bfs.getParent(10));
        assertEquals(2, bfs.getDepth(11));
        assertEquals(7, bfs.getParent(11));
        assertEquals(2, bfs.getDepth(12));
        assertEquals(4, bfs.getParent(12));
        assertEquals(2, bfs.getDepth(13));
        assertEquals(7, bfs.getParent(13));
        assertEquals(2, bfs.getDepth(14));
        assertEquals(9, bfs.getParent(14));
        assertEquals(2, bfs.getDepth(15));
        assertEquals(18, bfs.getParent(15));
        assertEquals(2, bfs.getDepth(16));
        assertEquals(17, bfs.getParent(16));
        assertEquals(1, bfs.getDepth(17));
        assertEquals(0, bfs.getParent(17));
        assertEquals(1, bfs.getDepth(18));
        assertEquals(0, bfs.getParent(18));
        assertEquals(1, bfs.getDepth(19));
        assertEquals(0, bfs.getParent(19));
        ConnectedComponents connectedComponents = new ConnectedComponents();
        assertEquals(1, connectedComponents.countConnectedComponents(graph));
    }


    public static Graph sampleGraph7() {
        Graph graph = new Graph();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addEdge(0, 5);
        graph.addEdge(5, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        return graph;
    }

    public static Graph sampleGraph6() {
        int size = 200;
        int split = 17;
        int splitsize = size / split;
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.addNode();
        }
        for (int i = 0; i < size; i += splitsize + 1) {
            for (int j = 0; j < splitsize; j++) {
                if (i + j + 1 < size) {
                    graph.addEdge(i + j, i + j + 1);
                }
            }
        }
        return graph;
    }


    public static Graph sampleGraph5() {
        int size = 6;
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.addNode();
        }
        for (int i = 0; i < size; i++) {
            graph.addEdge(i, i);
        }
        return graph;
    }

    public static Graph sampleGraph4() {
        int size = 14;
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.addNode();
        }
        for (int i = 0; i < size; i += 2) {
            graph.addEdge(i, i + 1);
        }
        return graph;
    }


    public static Graph sampleGraph3() {
        Graph graph = new Graph();
        for (int i = 0; i < 12; i++) {
            graph.addNode();
        }
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(8, 7);
        graph.addEdge(7, 10);
        graph.addEdge(10, 9);
        graph.addEdge(9, 11);
        graph.addEdge(11, 10);
        graph.addEdge(11, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        return graph;
    }

    public static Graph sampleGraph2(int size) {
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.addNode();
        }
        int size1 = (3 * size) / 4;
        int size2 = size - size1;
        for (int i = 0; i < (3 * size) / 4; i++) {
            graph.addEdge(i % size1, (17 * i) % size1);
            graph.addEdge((7 * i) % size1, (31 * i) % size1);
            graph.addEdge((13 * i) % size1, (29 * i) % size1);
            graph.addEdge((53 * i) % size1, (97 * i) % size1);
            graph.addEdge((93 * i) % size1, (101 * i) % size1);
            graph.addEdge((47 * i) % size1, (83 * i) % size1);
            graph.addEdge((59 * i) % size1, (61 * i) % size1);
        }
        for (int i = size1; i < size; i++) {
            graph.addEdge((i % size2) + size1, ((11 * i) % size2) + size1);
            graph.addEdge(((23 * i) % size2) + size1, ((43 * i) % size2) + size1);
            graph.addEdge(((93 * i) % size2) + size1, ((79 * i) % size2) + size1);
            graph.addEdge(((41 * i) % size2) + size1, ((103 * i) % size2) + size1);
        }
        return graph;
    }

    public static Graph sampleGraph1() {
        int size = 20;
        Graph graph = new Graph();
        for (int i = 0; i < size; i++) {
            graph.addNode();
        }
        for (int i = 0; i < size; i++) {
            graph.addEdge(i % size, (i + 1) % size);
        }
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 17);
        graph.addEdge(17, 19);
        graph.addEdge(4, 19);
        graph.addEdge(19, 13);
        graph.addEdge(16, 6);
        graph.addEdge(2, 13);
        graph.addEdge(13, 15);
        graph.addEdge(7, 11);
        graph.addEdge(19, 2);
        graph.addEdge(18, 5);
        graph.addEdge(15, 12);
        graph.addEdge(9, 17);
        graph.addEdge(14, 9);
        graph.addEdge(2, 15);
        graph.addEdge(4, 17);
        graph.addEdge(7, 13);
        graph.addEdge(18, 15);
        graph.addEdge(2, 6);
        graph.addEdge(9, 3);
        graph.addEdge(9, 5);
        graph.addEdge(0, 4);
        graph.addEdge(7, 0);
        graph.addEdge(0, 8);
        graph.addEdge(0, 9);
        graph.addEdge(4, 8);
        graph.addEdge(4, 12);
        graph.addEdge(0, 18);
        graph.addEdge(0, 17);
        graph.addEdge(11, 2);
        return graph;
    }
}
