package gad.tests;

import gad.dijkstra.Graph;

public class READ_ME {
    /*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Before you run them tests, first copy and paste the following static method into your Graph class.
    It's made for easy creation of graphs from formatted arrays.
    It's necessary to run the tests.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    /**
     * Do not input wrongly formatted int array into this method
     * or it will throw an ArrayIndexOutOfBoundsException.
     * Format:
     * First value at index 0: Size of graph
     * Values at indices greater or equals to 1: node ids seperated by
     * 1) value 0 or greater -> weight of edge between nodes,
     * 2) value less than 0 -> escape value
     */
    @SuppressWarnings("all")
    public static Graph of(int... format) {
        Graph graph = new Graph();
        for (int i = 0; i < format[0]; i++) {
            graph.addNode();
        }
        for (int i = 3; i < format.length; i += 2) {
            if (0 <= format[i - 2] && 0 <= format[i - 1] && 0 <= format[i]) {
                try {
                    graph.addEdge(format[i - 2], format[i], format[i - 1]);
                } catch (NullPointerException exception) {
                    int debug = 0;
                }
            }
        }
        return graph;
    }
}
