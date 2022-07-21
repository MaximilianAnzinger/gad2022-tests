package gad.tests;

import gad.dijkstra.Dijkstra;
import gad.dijkstra.Graph;
import gad.dijkstra.StudentResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static gad.tests.FirstGraphTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class DijkstraTest {
    @ParameterizedTest
    @MethodSource("restartTestParameters")
    void dijkstraTest3(Dijkstra dijkstra,StudentResult result) {
        executeDijkstra(dijkstra, exerciseGraph1, 0,4, result);
        assertEquals("0,3,2,1,4\n" +
                "0,1,3,6,10", result.toString());
        assertPath(dijkstra, 10, 0,3,2,1,4);

        executeDijkstra(dijkstra, exerciseGraph1, 0,5, result);
        assertEquals("0,3,2,1,4,5\n" +
                "0,1,3,6,10,14", result.toString());
        assertPath(dijkstra, 14, 0,3,2,5);

        executeDijkstra(dijkstra, exerciseGraph1, 0,6, result);
        assertEquals("0,3,2,1,4,5,6\n" +
                "0,1,3,6,10,14,20", result.toString());
        assertPath(dijkstra, 20, 0,3,2,5,6);

        executeDijkstra(dijkstra, exerciseGraph1, 1,3, result);
        assertEquals("1,4,5,3\n" +
                "0,4,9,11", result.toString());
        assertPath(dijkstra, 11, 1,4,3);
    }

    @ParameterizedTest
    @MethodSource("restartTestParameters")
    void dijkstraTest2(Dijkstra dijkstra,StudentResult result) {
        executeDijkstra(dijkstra, lectureGraph2, 0, 8, result);
        assertEquals("0,1,2,10,3,4,6,7,5,8\n" +
                "0,1,2,2,3,4,4,4,5,5", result.toString());
        assertPath(dijkstra, 5, 0, 1, 10, 3, 7, 8);
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(lectureGraph2, lectureGraph2.getNode(8),
                        lectureGraph2.getNode(0), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());

        executeDijkstra(dijkstra, lectureGraph2, 0, 9, result);
        assertEquals("0,1,2,10,3,4,6,7,5,8,9\n" +
                "0,1,2,2,3,4,4,4,5,5,6", result.toString());
        assertPath(dijkstra, 6, 0, 1, 10, 3, 7, 9);
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(lectureGraph2, lectureGraph2.getNode(9),
                        lectureGraph2.getNode(0), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());

        executeDijkstra(dijkstra, lectureGraph2, 0, 6, result);
        assertEquals("0,1,2,10,3,4,6\n" +
                "0,1,2,2,3,4,4", result.toString());
        assertPath(dijkstra, 4, 0, 1, 10, 3, 6);

        executeDijkstra(dijkstra, lectureGraph2, 0, 4, result);
        assertEquals("0,1,2,10,3,4\n" +
                "0,1,2,2,3,4", result.toString());
        assertPath(dijkstra, 4, 0, 1, 10, 4);
    }

    @ParameterizedTest
    @MethodSource("restartTestParameters")
    void dijkstraTest1(Dijkstra dijkstra,StudentResult result) {
        executeDijkstra(dijkstra, sampleGraph1, 0, 1, result);
        assertEquals("0,1\n0,2", result.toString());
        assertPath(dijkstra, 2, 0, 1);

        executeDijkstra(dijkstra, sampleGraph1, 1, 0, result);
        assertEquals("1,0\n0,3", result.toString());
        assertPath(dijkstra, 3, 1, 0);

        executeDijkstra(dijkstra, sampleGraph1, 2, 3, result);
        assertEquals("2,3\n0,1", result.toString());
        assertPath(dijkstra, 1, 2, 3);

        executeDijkstra(dijkstra, sampleGraph1, 3, 2, result);
        assertEquals("3,4,2\n0,10,10", result.toString());
        assertPath(dijkstra, 10, 3, 4, 2);

        executeDijkstra(dijkstra, sampleGraph1, 2, 4, result);
        assertEquals("2,3,4\n0,1,11", result.toString());
        assertPath(dijkstra, 11, 2, 3, 4);

        executeDijkstra(dijkstra, sampleGraph1, 4, 2, result);
        assertEquals("4,2\n0,0", result.toString());
        assertPath(dijkstra, 0, 4, 2);

        executeDijkstra(dijkstra, sampleGraph1, 3, 4, result);
        assertEquals("3,4\n0,10", result.toString());
        assertPath(dijkstra, 10, 3, 4);

        executeDijkstra(dijkstra, sampleGraph1, 4, 3, result);
        assertEquals("4,2,3\n0,0,1", result.toString());
        assertPath(dijkstra, 1, 4, 3);

        result.clear();
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(sampleGraph1, sampleGraph1.getNode(0),
                        sampleGraph1.getNode(3), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(sampleGraph1, sampleGraph1.getNode(1),
                        sampleGraph1.getNode(4), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(sampleGraph1, sampleGraph1.getNode(2),
                        sampleGraph1.getNode(0), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(sampleGraph1, sampleGraph1.getNode(2),
                        sampleGraph1.getNode(1), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());
        assertThrows(RuntimeException.class, () -> dijkstra.
                findRoute(sampleGraph1, sampleGraph1.getNode(4),
                        sampleGraph1.getNode(0), result));
        assertEquals("[]", dijkstra.getShortestPath().toString());
        assertEquals(0, dijkstra.getShortestPathLength());
    }


    private void assertPath(Dijkstra dijkstra, int pathLength, int... nodesOnPath) {
        assertEquals(Arrays.toString(nodesOnPath), Arrays.toString
                (dijkstra.getShortestPath().stream().
                        mapToInt(Graph.Node::getID).toArray()));
        assertEquals(pathLength, dijkstra.getShortestPathLength());
    }

    public void executeDijkstra(Dijkstra dijkstra, Graph graph,
                                int start, int end, StudentResult result) {
        result.clear();
        dijkstra.findRoute(graph, graph.getNode(start), graph.getNode(end), result);
    }

    public static Stream<Arguments> restartTestParameters() {
        return Stream.of(Arguments.of(new Dijkstra(), new StudentResult()));
    }

}
