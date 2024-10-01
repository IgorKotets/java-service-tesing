package my.first.program;

import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleTest {

    @BeforeClass
    public static void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
