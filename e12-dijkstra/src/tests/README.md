------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Before you run them tests, first copy and paste the following static method into your Graph class.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```java
public class Graph {
    /**
     * Do not input wrongly formatted int array into this method or it will throw an ArrayIndexOutOfBoundsException.
     * Format:
     * First value at index 0: Size of graph
     * Values at indices greater or equals to 1: node ids seperated by
     * 1) value 0 or greater -> weight of edge between nodes,
     * 2) value less than 0 -> escape value
     */
    public static Graph of(int... format) {
        Graph graph=new Graph();
        for (int i = 0; i < format[0]; i++) {
            graph.addNode();
        }
        for (int i = 3; i < format.length; i+=2) {
            if(0<=format[i-2] && 0<=format[i-1] && 0<=format[i]) {
                graph.addEdge(format[i-2], format[i], format[i-1]);
            }
        }
        return graph;
    }
}
```
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    I can't remember whether the template included a Node getNode(int id) method in the Graph class.
    In case it didn't, you need a Node getNode(int id) method in the graph class that finds and returns a Node by id.
    I'm not gonna show how to write it in case it was in the template and I don't want to give away any solutions.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## this should be the implementation of your StudentResult for the tests to work
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```java
package gad.dijkstra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentResult implements Result {
    private ArrayList<Destination> nodes;

    public StudentResult() {
        this.nodes = new ArrayList<>();
    }

    @Override
    public void addNode(int id, int pathLength) {
        nodes.add(Destination.of(id, pathLength));
    }

    @Override
    public void addNeighbour(int id) {
        // Irrelevant
    }

    @Override
    public void addNeighbours(Collection<Integer> ids) {
        // Irrelevant
    }

    @Override
    public String toString() {
        return nodes.stream().map(Destination::id).map(Objects::toString).collect(Collectors.joining(",")) + "\n" +
                nodes.stream().map(Destination::pathLength).map(Objects::toString).collect(Collectors.joining(","));
    }

    public void clear(){
        nodes.clear();
    }

    private record Destination(int id, int pathLength) {
        public static Destination of(int id, int pathLength) {
            return new Destination(id, pathLength);
        }
    }
}
```
    