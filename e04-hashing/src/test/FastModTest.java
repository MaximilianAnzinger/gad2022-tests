package test;

import gad.simplehash.Hashtable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FastModTest {

    @Test
    void testNormal() {
        assertEquals(1, Hashtable.fastModulo(25, 8));
        assertEquals(0, Hashtable.fastModulo(4, 4));
        assertEquals(214, Hashtable.fastModulo(82134, 256));
        assertEquals(0, Hashtable.fastModulo(0, 0));
        assertEquals(0, Hashtable.fastModulo(0, 32));
        assertEquals(64, Hashtable.fastModulo(64, 512));
        assertEquals(0, Hashtable.fastModulo(64, 64));
    }

    @Test
    void testNegative() {
        assertTrue(() -> {
            int i = Hashtable.fastModulo(-8123, 16);
            return i >= 0 && i < 16;
        }, "Die fastModulo Methode gibt illegale Werte für negatives i aus");
        assertTrue(() -> {
            int i = Hashtable.fastModulo(-1, 2);
            return i >= 0 && i < 2;
        }, "Die fastModulo Methode gibt illegale Werte für negatives i aus");
    }
}
