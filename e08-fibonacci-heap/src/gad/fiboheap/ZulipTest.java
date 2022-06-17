package gad.fiboheap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZulipTest {
    // Special thanks to Georg Henning (ÜL)
    // converted to a JUnit Test by Jonas Ladner
    // https://zulip.in.tum.de/#narrow/stream/1133-GAD-Aufgabe-8---Fibonacci-Heap/topic/Beispielheaps/near/615976
    @Test
    public void testInstructionExamples() {
        // INSERT
        // insert example: pre insert(4)
        assertEquals(insertPreString, insertPre().toString());
        // insert example: post insert(4)
        assertEquals(insertPostString, insertPost().toString());

        // MERGE
        // merge example: heap 1
        assertEquals(mergeH1String, mergeH1().toString());
        // merge example: heap 2
        assertEquals(mergeH2String, mergeH2().toString());
        // merge example: final heap
        assertEquals(mergeExampleString, mergeExample().toString());

        // EXTRACTMIN, CONSOLIDATE
        // extractMin: pre operation heap
        assertEquals(extractMinPreString, extractMinPre().toString());
        // extractMin: pre consolidate
        // TODO: add 'System.out.println(this);' in extractMin before calling consolidate
        //		extractMinPost();
        // extractMin: post operation
        assertEquals(extractMinPostString, extractMinPost().toString());

        // DECREASEKEY
        // decreaseKey: pre operations
        //		System.out.println(decreaseKeyPre());
        assertEquals(decreaseKeyPreString, decreaseKeyPre().toString());
        // decreaseKey: post decreaseKey(26,6)
        //		System.out.println(decreaseKeyPost1());
        assertEquals(decreaseKeyPost1String, decreaseKeyPost1().toString());
        // decreaseKey: post decreaseKey(25,5)
        assertEquals(decreaseKeyPost2String, decreaseKeyPost2().toString());
    }

    private static FiboHeap<Integer> insertPre() {
        FiboHeap<Integer> heap = new FiboHeap<>();
        insertRange(heap, 1, 4);
        heap.consolidate();
        return heap;
        /* Graphviz string:
         * insertPreString
         */
    }

    private static final String insertPreString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n1[label="1" pos="0,-1!"];
            subgraph {
            n2[label="2" pos="0,-2!"];
            }
            n1 -> n2[label="d"];
            n2 -> n2[label="n"];
            n2 -> n2[label="p"];
            n2 -> n1[label="u"];
            }
            subgraph {
            n3[label="3" pos="2,-1!"];
            }
            min -> n1[label=""];
            n1 -> n3[label="n"];
            n1:s -> n3:s[label="p"];
            n3:n -> n1:n[label="n"];
            n3 -> n1[label="p"];
            }""";

    private static FiboHeap<Integer> insertPost() {
        FiboHeap<Integer> heap = insertPre();
        heap.insert(4);
        return heap;
        /* Graphviz string:
         * insertPostString
         */
    }

    private static final String insertPostString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n1[label="1" pos="0,-1!"];
            subgraph {
            n2[label="2" pos="0,-2!"];
            }
            n1 -> n2[label="d"];
            n2 -> n2[label="n"];
            n2 -> n2[label="p"];
            n2 -> n1[label="u"];
            }
            subgraph {
            n3[label="3" pos="2,-1!"];
            }
            subgraph {
            n4[label="4" pos="3,-1!"];
            }
            min -> n1[label=""];
            n1 -> n3[label="n"];
            n1:s -> n4:s[label="p"];
            n3 -> n4[label="n"];
            n3 -> n1[label="p"];
            n4:n -> n1:n[label="n"];
            n4 -> n3[label="p"];
            }""";

    private static FiboHeap<Integer> mergeH1() {
        FiboHeap<Integer> heap = new FiboHeap<>();
        insertRange(heap, 1, 6);
        heap.consolidate();
        return heap;
        /* Graphviz string:
         * mergeH2String
         */
    }

    private static final String mergeH1String = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n1[label="1" pos="0,-1!"];
            subgraph {
            n2[label="2" pos="0,-2!"];
            }
            subgraph {
            n3[label="3" pos="1,-2!"];
            subgraph {
            n4[label="4" pos="1,-3!"];
            }
            n3 -> n4[label="d"];
            n4 -> n4[label="n"];
            n4 -> n4[label="p"];
            n4 -> n3[label="u"];
            }
            n1 -> n2[label="d"];
            n2 -> n3[label="n"];
            n2:s -> n3:s[label="p"];
            n2 -> n1[label="u"];
            n3:n -> n2:n[label="n"];
            n3 -> n2[label="p"];
            n3 -> n1[label="u"];
            }
            subgraph {
            n5[label="5" pos="3,-1!"];
            }
            min -> n1[label=""];
            n1 -> n5[label="n"];
            n1:s -> n5:s[label="p"];
            n5:n -> n1:n[label="n"];
            n5 -> n1[label="p"];
            }""";

    private static FiboHeap<Integer> mergeH2() {
        FiboHeap<Integer> heap = new FiboHeap<>();
        insertRange(heap, 10, 31, 10);
        return heap;
        /* Graphviz string:
         * mergeH2String
         */
    }

    private static final String mergeH2String = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n10[label="10" pos="0,-1!"];
            }
            subgraph {
            n20[label="20" pos="1,-1!"];
            }
            subgraph {
            n30[label="30" pos="2,-1!"];
            }
            min -> n10[label=""];
            n10 -> n20[label="n"];
            n10:s -> n30:s[label="p"];
            n20 -> n30[label="n"];
            n20 -> n10[label="p"];
            n30:n -> n10:n[label="n"];
            n30 -> n20[label="p"];
            }""";

    private static FiboHeap<Integer> mergeExample() {
        FiboHeap<Integer> heap1 = mergeH1();
        FiboHeap<Integer> heap2 = mergeH2();
        heap1.merge(heap2);
        return heap1;
        /* Graphviz string:
         * mergeExample
         */
    }

    private static final String mergeExampleString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n1[label="1" pos="0,-1!"];
            subgraph {
            n2[label="2" pos="0,-2!"];
            }
            subgraph {
            n3[label="3" pos="1,-2!"];
            subgraph {
            n4[label="4" pos="1,-3!"];
            }
            n3 -> n4[label="d"];
            n4 -> n4[label="n"];
            n4 -> n4[label="p"];
            n4 -> n3[label="u"];
            }
            n1 -> n2[label="d"];
            n2 -> n3[label="n"];
            n2:s -> n3:s[label="p"];
            n2 -> n1[label="u"];
            n3:n -> n2:n[label="n"];
            n3 -> n2[label="p"];
            n3 -> n1[label="u"];
            }
            subgraph {
            n5[label="5" pos="3,-1!"];
            }
            subgraph {
            n10[label="10" pos="4,-1!"];
            }
            subgraph {
            n20[label="20" pos="5,-1!"];
            }
            subgraph {
            n30[label="30" pos="6,-1!"];
            }
            min -> n1[label=""];
            n1 -> n5[label="n"];
            n1:s -> n30:s[label="p"];
            n5 -> n10[label="n"];
            n5 -> n1[label="p"];
            n10 -> n20[label="n"];
            n10 -> n5[label="p"];
            n20 -> n30[label="n"];
            n20 -> n10[label="p"];
            n30:n -> n1:n[label="n"];
            n30 -> n20[label="p"];
            }""";

    private static FiboHeap<Integer> extractMinPre() {
        FiboHeap<Integer> heap = new FiboHeap<Integer>();
        insertRange(heap, 1, 12);
        heap.consolidate();
        return heap;
        /* Graphviz string:
         * extractMinPreString
         */
    }

    private static final String extractMinPreString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n1[label="1" pos="0,-1!"];
            subgraph {
            n2[label="2" pos="0,-2!"];
            }
            subgraph {
            n3[label="3" pos="1,-2!"];
            subgraph {
            n4[label="4" pos="1,-3!"];
            }
            n3 -> n4[label="d"];
            n4 -> n4[label="n"];
            n4 -> n4[label="p"];
            n4 -> n3[label="u"];
            }
            subgraph {
            n5[label="5" pos="3,-2!"];
            subgraph {
            n6[label="6" pos="3,-3!"];
            }
            subgraph {
            n7[label="7" pos="4,-3!"];
            subgraph {
            n8[label="8" pos="4,-4!"];
            }
            n7 -> n8[label="d"];
            n8 -> n8[label="n"];
            n8 -> n8[label="p"];
            n8 -> n7[label="u"];
            }
            n5 -> n6[label="d"];
            n6 -> n7[label="n"];
            n6:s -> n7:s[label="p"];
            n6 -> n5[label="u"];
            n7:n -> n6:n[label="n"];
            n7 -> n6[label="p"];
            n7 -> n5[label="u"];
            }
            n1 -> n2[label="d"];
            n2 -> n3[label="n"];
            n2:s -> n5:s[label="p"];
            n2 -> n1[label="u"];
            n3 -> n5[label="n"];
            n3 -> n2[label="p"];
            n3 -> n1[label="u"];
            n5:n -> n2:n[label="n"];
            n5 -> n3[label="p"];
            n5 -> n1[label="u"];
            }
            subgraph {
            n11[label="11" pos="4,-1!"];
            }
            subgraph {
            n9[label="9" pos="5,-1!"];
            subgraph {
            n10[label="10" pos="5,-2!"];
            }
            n9 -> n10[label="d"];
            n10 -> n10[label="n"];
            n10 -> n10[label="p"];
            n10 -> n9[label="u"];
            }
            min -> n1[label=""];
            n1 -> n11[label="n"];
            n1:s -> n9:s[label="p"];
            n11 -> n9[label="n"];
            n11 -> n1[label="p"];
            n9:n -> n1:n[label="n"];
            n9 -> n11[label="p"];
            }""";

    private static FiboHeap<Integer> extractMinPost() {
        FiboHeap<Integer> heap = extractMinPre();
        heap.extractMin();
        return heap;
        /* Graphviz string - pre consolidate
         * extractMinPostString
         */
    }

    private static final String extractMinPostString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n2[label="2" pos="0,-1!"];
            }
            subgraph {
            n3[label="3" pos="1,-1!"];
            subgraph {
            n4[label="4" pos="1,-2!"];
            }
            n3 -> n4[label="d"];
            n4 -> n4[label="n"];
            n4 -> n4[label="p"];
            n4 -> n3[label="u"];
            }
            subgraph {
            n5[label="5" pos="3,-1!"];
            subgraph {
            n6[label="6" pos="3,-2!"];
            }
            subgraph {
            n7[label="7" pos="4,-2!"];
            subgraph {
            n8[label="8" pos="4,-3!"];
            }
            n7 -> n8[label="d"];
            n8 -> n8[label="n"];
            n8 -> n8[label="p"];
            n8 -> n7[label="u"];
            }
            n5 -> n6[label="d"];
            n6 -> n7[label="n"];
            n6:s -> n7:s[label="p"];
            n6 -> n5[label="u"];
            n7:n -> n6:n[label="n"];
            n7 -> n6[label="p"];
            n7 -> n5[label="u"];
            }
            subgraph {
            n9[label="9" pos="6,-1!"];
            subgraph {
            n10[label="10" pos="6,-2!"];
            }
            n9 -> n10[label="d"];
            n10 -> n10[label="n"];
            n10 -> n10[label="p"];
            n10 -> n9[label="u"];
            }
            subgraph {
            n11[label="11" pos="8,-1!"];
            }
            min -> n2[label=""];
            n2 -> n3[label="n"];
            n2:s -> n11:s[label="p"];
            n3 -> n5[label="n"];
            n3 -> n2[label="p"];
            n5 -> n9[label="n"];
            n5 -> n3[label="p"];
            n9 -> n11[label="n"];
            n9 -> n5[label="p"];
            n11:n -> n2:n[label="n"];
            n11 -> n9[label="p"];
            }
             */

            /* Graphviz string - post consolidate:
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n2[label="2" pos="0,-1!"];
            subgraph {
            n11[label="11" pos="0,-2!"];
            }
            n2 -> n11[label="d"];
            n11 -> n11[label="n"];
            n11 -> n11[label="p"];
            n11 -> n2[label="u"];
            }
            subgraph {
            n3[label="3" pos="2,-1!"];
            subgraph {
            n4[label="4" pos="2,-2!"];
            }
            subgraph {
            n9[label="9" pos="3,-2!"];
            subgraph {
            n10[label="10" pos="3,-3!"];
            }
            n9 -> n10[label="d"];
            n10 -> n10[label="n"];
            n10 -> n10[label="p"];
            n10 -> n9[label="u"];
            }
            subgraph {
            n5[label="5" pos="5,-2!"];
            subgraph {
            n6[label="6" pos="5,-3!"];
            }
            subgraph {
            n7[label="7" pos="6,-3!"];
            subgraph {
            n8[label="8" pos="6,-4!"];
            }
            n7 -> n8[label="d"];
            n8 -> n8[label="n"];
            n8 -> n8[label="p"];
            n8 -> n7[label="u"];
            }
            n5 -> n6[label="d"];
            n6 -> n7[label="n"];
            n6:s -> n7:s[label="p"];
            n6 -> n5[label="u"];
            n7:n -> n6:n[label="n"];
            n7 -> n6[label="p"];
            n7 -> n5[label="u"];
            }
            n3 -> n4[label="d"];
            n4 -> n9[label="n"];
            n4:s -> n5:s[label="p"];
            n4 -> n3[label="u"];
            n9 -> n5[label="n"];
            n9 -> n4[label="p"];
            n9 -> n3[label="u"];
            n5:n -> n4:n[label="n"];
            n5 -> n9[label="p"];
            n5 -> n3[label="u"];
            }
            min -> n2[label=""];
            n2 -> n3[label="n"];
            n2:s -> n3:s[label="p"];
            n3:n -> n2:n[label="n"];
            n3 -> n2[label="p"];
            }""";

    private static FiboHeap<Integer> decreaseKeyPre() {
        FiboHeap<Integer> heap = new FiboHeap<>();
        insertRange(heap, 11, 27);
        heap.consolidate();
        heap.decreaseKey(heap.getHandle(20), 10);
        heap.decreaseKey(heap.getHandle(24), 4);
        return heap;
        /* Graphviz string:
         * decreaseKeyPre
         */
    }

    private static final String decreaseKeyPreString = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n4[label="4" pos="0,-1!"];
            }
            subgraph {
            n10[label="10" pos="1,-1!"];
            }
            subgraph {
            n11[label="11" pos="2,-1!"];
            subgraph {
            n12[label="12" pos="2,-2!"];
            }
            subgraph {
            n13[label="13" pos="3,-2!"];
            subgraph {
            n14[label="14" pos="3,-3!"];
            }
            n13 -> n14[label="d"];
            n14 -> n14[label="n"];
            n14 -> n14[label="p"];
            n14 -> n13[label="u"];
            }
            subgraph {
            n15[label="15" pos="5,-2!"];
            subgraph {
            n16[label="16" pos="5,-3!"];
            }
            subgraph {
            n17[label="17" pos="6,-3!"];
            subgraph {
            n18[label="18" pos="6,-4!"];
            }
            n17 -> n18[label="d"];
            n18 -> n18[label="n"];
            n18 -> n18[label="p"];
            n18 -> n17[label="u"];
            }
            n15 -> n16[label="d"];
            n16 -> n17[label="n"];
            n16:s -> n17:s[label="p"];
            n16 -> n15[label="u"];
            n17:n -> n16:n[label="n"];
            n17 -> n16[label="p"];
            n17 -> n15[label="u"];
            }
            subgraph {
            n19[label="19" color="red" pos="8,-2!"];
            subgraph {
            n21[label="21" pos="8,-3!"];
            subgraph {
            n22[label="22" pos="8,-4!"];
            }
            n21 -> n22[label="d"];
            n22 -> n22[label="n"];
            n22 -> n22[label="p"];
            n22 -> n21[label="u"];
            }
            subgraph {
            n23[label="23" color="red" pos="10,-3!"];
            subgraph {
            n25[label="25" pos="10,-4!"];
            subgraph {
            n26[label="26" pos="10,-5!"];
            }
            n25 -> n26[label="d"];
            n26 -> n26[label="n"];
            n26 -> n26[label="p"];
            n26 -> n25[label="u"];
            }
            n23 -> n25[label="d"];
            n25 -> n25[label="n"];
            n25 -> n25[label="p"];
            n25 -> n23[label="u"];
            }
            n19 -> n21[label="d"];
            n21 -> n23[label="n"];
            n21:s -> n23:s[label="p"];
            n21 -> n19[label="u"];
            n23:n -> n21:n[label="n"];
            n23 -> n21[label="p"];
            n23 -> n19[label="u"];
            }
            n11 -> n12[label="d"];
            n12 -> n13[label="n"];
            n12:s -> n19:s[label="p"];
            n12 -> n11[label="u"];
            n13 -> n15[label="n"];
            n13 -> n12[label="p"];
            n13 -> n11[label="u"];
            n15 -> n19[label="n"];
            n15 -> n13[label="p"];
            n15 -> n11[label="u"];
            n19:n -> n12:n[label="n"];
            n19 -> n15[label="p"];
            n19 -> n11[label="u"];
            }
            min -> n4[label=""];
            n4 -> n10[label="n"];
            n4:s -> n11:s[label="p"];
            n10 -> n11[label="n"];
            n10 -> n4[label="p"];
            n11:n -> n4:n[label="n"];
            n11 -> n10[label="p"];
            }""";

    private static FiboHeap<Integer> decreaseKeyPost1() {
        FiboHeap<Integer> heap = decreaseKeyPre();
        heap.decreaseKey(heap.getHandle(26), 6);
        return heap;
        /* Graphviz string:
         * decreaseKeyPost1
         */
    }

    private static final String decreaseKeyPost1String = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n4[label="4" pos="0,-1!"];
            }
            subgraph {
            n10[label="10" pos="1,-1!"];
            }
            subgraph {
            n11[label="11" pos="2,-1!"];
            subgraph {
            n12[label="12" pos="2,-2!"];
            }
            subgraph {
            n13[label="13" pos="3,-2!"];
            subgraph {
            n14[label="14" pos="3,-3!"];
            }
            n13 -> n14[label="d"];
            n14 -> n14[label="n"];
            n14 -> n14[label="p"];
            n14 -> n13[label="u"];
            }
            subgraph {
            n15[label="15" pos="5,-2!"];
            subgraph {
            n16[label="16" pos="5,-3!"];
            }
            subgraph {
            n17[label="17" pos="6,-3!"];
            subgraph {
            n18[label="18" pos="6,-4!"];
            }
            n17 -> n18[label="d"];
            n18 -> n18[label="n"];
            n18 -> n18[label="p"];
            n18 -> n17[label="u"];
            }
            n15 -> n16[label="d"];
            n16 -> n17[label="n"];
            n16:s -> n17:s[label="p"];
            n16 -> n15[label="u"];
            n17:n -> n16:n[label="n"];
            n17 -> n16[label="p"];
            n17 -> n15[label="u"];
            }
            subgraph {
            n19[label="19" color="red" pos="8,-2!"];
            subgraph {
            n21[label="21" pos="8,-3!"];
            subgraph {
            n22[label="22" pos="8,-4!"];
            }
            n21 -> n22[label="d"];
            n22 -> n22[label="n"];
            n22 -> n22[label="p"];
            n22 -> n21[label="u"];
            }
            subgraph {
            n23[label="23" color="red" pos="10,-3!"];
            subgraph {
            n25[label="25" color="red" pos="10,-4!"];
            }
            n23 -> n25[label="d"];
            n25 -> n25[label="n"];
            n25 -> n25[label="p"];
            n25 -> n23[label="u"];
            }
            n19 -> n21[label="d"];
            n21 -> n23[label="n"];
            n21:s -> n23:s[label="p"];
            n21 -> n19[label="u"];
            n23:n -> n21:n[label="n"];
            n23 -> n21[label="p"];
            n23 -> n19[label="u"];
            }
            n11 -> n12[label="d"];
            n12 -> n13[label="n"];
            n12:s -> n19:s[label="p"];
            n12 -> n11[label="u"];
            n13 -> n15[label="n"];
            n13 -> n12[label="p"];
            n13 -> n11[label="u"];
            n15 -> n19[label="n"];
            n15 -> n13[label="p"];
            n15 -> n11[label="u"];
            n19:n -> n12:n[label="n"];
            n19 -> n15[label="p"];
            n19 -> n11[label="u"];
            }
            subgraph {
            n6[label="6" pos="7,-1!"];
            }
            min -> n4[label=""];
            n4 -> n10[label="n"];
            n4:s -> n6:s[label="p"];
            n10 -> n11[label="n"];
            n10 -> n4[label="p"];
            n11 -> n6[label="n"];
            n11 -> n10[label="p"];
            n6:n -> n4:n[label="n"];
            n6 -> n11[label="p"];
            }""";

    private static FiboHeap<Integer> decreaseKeyPost2() {
        FiboHeap<Integer> heap = decreaseKeyPost1();
        heap.decreaseKey(heap.getHandle(25), 5);
        return heap;
        /* Graphviz string:
         * decreaseKeyPost2
         */
    }

    private static final String decreaseKeyPost2String = """
            digraph G {
            min[label="min" pos="0,0!"];
            subgraph {
            n4[label="4" pos="0,-1!"];
            }
            subgraph {
            n10[label="10" pos="1,-1!"];
            }
            subgraph {
            n11[label="11" pos="2,-1!"];
            subgraph {
            n12[label="12" pos="2,-2!"];
            }
            subgraph {
            n13[label="13" pos="3,-2!"];
            subgraph {
            n14[label="14" pos="3,-3!"];
            }
            n13 -> n14[label="d"];
            n14 -> n14[label="n"];
            n14 -> n14[label="p"];
            n14 -> n13[label="u"];
            }
            subgraph {
            n15[label="15" pos="5,-2!"];
            subgraph {
            n16[label="16" pos="5,-3!"];
            }
            subgraph {
            n17[label="17" pos="6,-3!"];
            subgraph {
            n18[label="18" pos="6,-4!"];
            }
            n17 -> n18[label="d"];
            n18 -> n18[label="n"];
            n18 -> n18[label="p"];
            n18 -> n17[label="u"];
            }
            n15 -> n16[label="d"];
            n16 -> n17[label="n"];
            n16:s -> n17:s[label="p"];
            n16 -> n15[label="u"];
            n17:n -> n16:n[label="n"];
            n17 -> n16[label="p"];
            n17 -> n15[label="u"];
            }
            n11 -> n12[label="d"];
            n12 -> n13[label="n"];
            n12:s -> n15:s[label="p"];
            n12 -> n11[label="u"];
            n13 -> n15[label="n"];
            n13 -> n12[label="p"];
            n13 -> n11[label="u"];
            n15:n -> n12:n[label="n"];
            n15 -> n13[label="p"];
            n15 -> n11[label="u"];
            }
            subgraph {
            n6[label="6" pos="6,-1!"];
            }
            subgraph {
            n5[label="5" pos="7,-1!"];
            }
            subgraph {
            n23[label="23" pos="8,-1!"];
            }
            subgraph {
            n19[label="19" pos="9,-1!"];
            subgraph {
            n21[label="21" pos="9,-2!"];
            subgraph {
            n22[label="22" pos="9,-3!"];
            }
            n21 -> n22[label="d"];
            n22 -> n22[label="n"];
            n22 -> n22[label="p"];
            n22 -> n21[label="u"];
            }
            n19 -> n21[label="d"];
            n21 -> n21[label="n"];
            n21 -> n21[label="p"];
            n21 -> n19[label="u"];
            }
            min -> n4[label=""];
            n4 -> n10[label="n"];
            n4:s -> n19:s[label="p"];
            n10 -> n11[label="n"];
            n10 -> n4[label="p"];
            n11 -> n6[label="n"];
            n11 -> n10[label="p"];
            n6 -> n5[label="n"];
            n6 -> n11[label="p"];
            n5 -> n23[label="n"];
            n5 -> n6[label="p"];
            n23 -> n19[label="n"];
            n23 -> n5[label="p"];
            n19:n -> n4:n[label="n"];
            n19 -> n23[label="p"];
            }""";

    private static void insertRange(FiboHeap<Integer> heap, int lowerBound, int upperBound, int... stepwidth) {
        int step = stepwidth.length > 0 ? stepwidth[0] : 1;
        for (int i = lowerBound; i < upperBound; i += step) {
            heap.insert(i);
        }
    }
}
