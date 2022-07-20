package gad.tests;

import gad.dijkstra.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class FirstGraphTest {
    private static final Graph lectureGraph1 = Graph.of(7,
            1, 1, 3, 1, 5, 1, 1, 1, 4, 1, 6, 1, 2, 1, 5, 1, 2, 1, 4, -1,
            3, 1, 6);
    private static final Graph lectureGraph2 = Graph.of(11,
            0, 1, 1, 1, 10, 2, 4, 2, 7, 1, 8, -1,
            0, 2, 2, 4, 6, 1, 5, 2, 7, 2, 9, -1,
            10, 1, 3, 1, 7, -1,
            2, 3, 5, -1,
            3, 3, 6);
    private static final Graph exerciseGraph1 = Graph.of(7,
            0, 1, 3, 2, 2, 3, 1, 4, 4, 5, 5, 6, 6, 1, 3, -1,
            0, 20, 2, 11, 5, -1,
            0, 19, 1, -1,
            0, 18, 4, 7, 3, -1,
            0, 17, 5);
    private static final Graph exerciseGraph2 = Graph.of(11,
            0, 1, 2, 1, 6, 1, 7, 1, 9, 1, 1, 1, 5, -1,
            2, 1, 3, 1, 6, 1, 9, -1,
            10, 1, 0, 1, 8, 1, 4, -1,
            3, 1, 8, 1, 10, 1, 6, 1, 1, -1,
            3, 1, 1, -1, 10, 1, 5);
    private static final Graph sampleGraph1 = Graph.of(5,
            0, 2, 1, 3, 0, 4, 1, 5, 0, 6, 1, -1,
            2, 1, 3, 10, 4, 0, 2, 1, 3, 20, 4, 100, 2, 1, 3, -1,
            4, 1, 3);

    @Test
    void graphTest1() {
        assertEquals(7, lectureGraph1.getAllNodes().size());
        assertNeighbors(lectureGraph1, 0);
        assertNeighbors(lectureGraph1, 1, 3, 4);
        assertNeighbors(lectureGraph1, 2, 4, 5);
        assertNeighbors(lectureGraph1, 3, 5, 6);
        assertNeighbors(lectureGraph1, 4, 6);
        assertNeighbors(lectureGraph1, 5, 1, 2);
        assertNeighbors(lectureGraph1, 6, 2);

        assertEquals(11, lectureGraph2.getAllNodes().size());
        assertNeighbors(lectureGraph2, 0, 1, 2);
        assertNeighbors(lectureGraph2, 1, 10);
        assertNeighbors(lectureGraph2, 2, 5, 6);
        assertNeighbors(lectureGraph2, 3, 6, 7);
        assertNeighbors(lectureGraph2, 4, 7);
        assertNeighbors(lectureGraph2, 5, 7);
        assertNeighbors(lectureGraph2, 6, 5);
        assertNeighbors(lectureGraph2, 7, 8, 9);
        assertNeighbors(lectureGraph2, 8);
        assertNeighbors(lectureGraph2, 9);
        assertNeighbors(lectureGraph2, 10, 3, 4);

        assertNeighbors(exerciseGraph1, 0, 1, 2, 3, 4, 5);
        assertNeighbors(exerciseGraph1, 1, 4);
        assertNeighbors(exerciseGraph1, 2, 1, 5);
        assertNeighbors(exerciseGraph1, 3, 2);
        assertNeighbors(exerciseGraph1, 4, 3, 5);
        assertNeighbors(exerciseGraph1, 5, 6);
        assertNeighbors(exerciseGraph1, 6, 3);

        assertNeighbors(exerciseGraph2, 0, 2, 8);
        assertNeighbors(exerciseGraph2, 1, 5);
        assertNeighbors(exerciseGraph2, 2, 3, 6);
        assertNeighbors(exerciseGraph2, 3, 1, 6, 8);
        assertNeighbors(exerciseGraph2, 4);
        assertNeighbors(exerciseGraph2, 5);
        assertNeighbors(exerciseGraph2, 6, 1, 7, 9);
        assertNeighbors(exerciseGraph2, 7, 9);
        assertNeighbors(exerciseGraph2, 8, 4, 10);
        assertNeighbors(exerciseGraph2, 9, 1);
        assertNeighbors(exerciseGraph2, 10, 0, 5, 6);

        assertEquals(5, sampleGraph1.getAllNodes().size());
        assertNeighbors(sampleGraph1, 0, 1);
        assertNeighbors(sampleGraph1, 1, 0);
        assertNeighbors(sampleGraph1, 2, 3);
        assertNeighbors(sampleGraph1, 3, 4);
        assertNeighbors(sampleGraph1, 4, 2, 3);
        assertShortestDistanceNeighbors(sampleGraph1, 0, 1, 2);
        assertShortestDistanceNeighbors(sampleGraph1, 1, 0, 3);
        assertShortestDistanceNeighbors(sampleGraph1, 2, 3, 1);
        assertShortestDistanceNeighbors(sampleGraph1, 3, 4, 10);
        assertShortestDistanceNeighbors(sampleGraph1, 4, 2, 0);
    }

    private void assertNeighbors(Graph graph, int node, int... neighbors) {
        assertEquals(Arrays.toString(neighbors), Arrays.toString
                (graph.getAllNodes().stream().
                        filter(n -> n.getID() == node).
                        findAny().orElseThrow().getNeighbours().stream().
                        sorted(Comparator.comparingInt(Graph.Node::getID)).
                        mapToInt(Graph.Node::getID).toArray()));
    }

    @SuppressWarnings("all")
    private void assertShortestDistanceNeighbors(Graph graph, int node, int neighbor, int distance) {
        assertEquals(distance, graph.getAllNodes().stream().
                filter(n -> n.getID() == node).
                findAny().orElseThrow().
                getShortestDistanceToNeighbour(graph.getAllNodes().stream().
                        filter(n -> n.getID() == neighbor).
                        findAny().orElseThrow()));
    }


    public static void write(Object object) {
        System.out.println
                (object instanceof Object[] objects ? Arrays.toString(objects) :
                        object instanceof int[] ints ? Arrays.toString(ints) :
                                object instanceof long[] longs ? Arrays.toString(longs) :
                                        object instanceof double[] doubles ? Arrays.toString(doubles) :
                                                object instanceof float[] floats ? Arrays.toString(floats) :
                                                        object instanceof boolean[] bools ? Arrays.toString(bools) :
                                                                object instanceof char[] chars ? Arrays.toString(chars) :
                                                                        object.toString());
    }
}
