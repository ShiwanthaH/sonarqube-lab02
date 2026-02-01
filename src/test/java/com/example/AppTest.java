package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAppMainMethod() {
        // Test that App.main() runs without throwing an exception
        try {
            App.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            fail("App.main() should not throw an exception");
        }
    }
}
