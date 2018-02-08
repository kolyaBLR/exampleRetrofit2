package com.example.kolyaservit.retrofitexample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private final int timeout = 1000;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(timeout = timeout)
    public void addition_correct() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test(timeout = timeout)
    public void addition_isNotCorrect() throws Exception {
        assertNotEquals("Numbers isn't equals!", 5, 2 + 2);
    }

    @Test(expected = NullPointerException.class)
    public void nullStringTest() {
        String str = null;
        assertTrue(str.isEmpty());
    }
}
