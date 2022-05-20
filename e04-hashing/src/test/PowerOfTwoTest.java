package test;
import gad.simplehash.Hashtable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerOfTwoTest {

    @Test
    void testPowerOfTwo(){
        assertEquals(1,Hashtable.getNextPowerOfTwo(1));
        assertEquals(1,Hashtable.getNextPowerOfTwo(0));
        assertEquals(4,Hashtable.getNextPowerOfTwo(3));
        assertEquals(4,Hashtable.getNextPowerOfTwo(4));
        assertEquals(8,Hashtable.getNextPowerOfTwo(6));
        assertEquals(64,Hashtable.getNextPowerOfTwo(33));
        assertEquals(1048576,Hashtable.getNextPowerOfTwo(999991));

        assertEquals(64,Hashtable.getNextPowerOfTwo(64));
        assertEquals(2,Hashtable.getNextPowerOfTwo(2));
    }
}
