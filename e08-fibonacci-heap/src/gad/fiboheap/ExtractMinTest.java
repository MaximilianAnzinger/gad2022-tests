package gad.fiboheap;
import gad.fiboheap.FiboHeap;
import gad.fiboheap.FiboNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractMinTest {

    @Test
    public void smallTest() {
        FiboHeap<Integer> actual = new FiboHeap<>();
        FiboNode<Integer> min = new FiboNode<>(1);
        actual.setSize(1);
        actual.setMin(min);


        Integer actualValue = actual.extractMin();

        System.out.println(actual);

        assertEquals(1, actualValue, "Bei extractMin() wird ein falscher Wert zurückgegeben!");

        assertEquals(0, actual.size(), "Die Größe des Heaps passt nach extractMin() nicht!");

        assertEquals(new FiboHeap<>().toString(), actual.toString(), "Die toString() Methode des Heaps erzeugt nicht den gleichen String wie erwartet, der Heap könnte trotzdem richtig sein, überprüfe den Graphen auf der GraphViz Website (siehe Artemis)");
    }

    @Test
    public void smallTest2() {
        FiboHeap<Integer> actual = new FiboHeap<>();
        FiboNode<Integer> min = new FiboNode<>(1);
        min.setDown(new FiboNode<>(2));
        min.getDown().setUp(min);
        actual.setSize(2);
        actual.setMin(min);

        FiboHeap<Integer> expected = new FiboHeap<>();
        expected.setSize(1);
        expected.setMin(new FiboNode<>(2));


        Integer actualValue = actual.extractMin();

        System.out.println(actual);

        assertEquals(1, actualValue, "Bei extractMin() wird ein falscher Wert zurückgegeben!");

        assertEquals(1, actual.size(), "Die Größe des Heaps passt nach extractMin() nicht!");

        assertEquals(expected.toString(), actual.toString(), "Die toString() Methode des Heaps erzeugt nicht den gleichen String wie erwartet, der Heap könnte trotzdem richtig sein, überprüfe den Graphen auf der GraphViz Website (siehe Artemis)");
    }
}
