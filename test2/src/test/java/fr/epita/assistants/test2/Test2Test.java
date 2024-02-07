package fr.epita.assistants.test2;

import fr.epita.assistants.server.MyServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class Test2Test {
    // TEST DIVISION
    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testDivisionBy0() {
        assertThrows(ArithmeticException.class, () -> {
            int result = Test2.division(12, 0);
        });
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testDivSimple() {
        assertEquals(6, Test2.division(12, 2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testDivMaxInt() {
        assertEquals(0, Test2.division(2, Integer.MAX_VALUE), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testDivNeg() {
        assertEquals(-1, Test2.division(3, -2), "Invalid result");
    }

    // TEST TRIBONNACCI
    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMax() {
        assertThrows(ArithmeticException.class, () -> {
            long res = Test2.tribonacci(Integer.MAX_VALUE);
        });
    }
    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testBase() {
        assertEquals(1, Test2.tribonacci(0), "Invalid result");
    }
    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testBase2() {
        assertEquals(1, Test2.tribonacci(1), "Invalid result");
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMid() {
        assertEquals(504, Test2.tribonacci(12), "Invalid result");
    }
    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMid2() {
        assertEquals(410744, Test2.tribonacci(23), "Invalid result");
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testNeg() {
        assertThrows(IllegalArgumentException.class, () -> {
            long res = Test2.tribonacci(-2);
        });
    }

    // TEST SERVER
    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testServer1() {
        assertThrows(IllegalArgumentException.class, () -> {
            MyServer.launchServer();
            long res = Test2.serverGetResponseCode();
            MyServer.stopServer();
        });
    }
}
