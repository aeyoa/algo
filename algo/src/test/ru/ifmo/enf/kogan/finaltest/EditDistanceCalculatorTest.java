package ru.ifmo.enf.kogan.finaltest;

import junit.framework.Assert;
import org.junit.Test;
import ru.ifmo.enf.kogan.finaltask.EditDistanceCalculatorImpl;

/**
 * Created by arsenykogan on 31/05/14.
 */
public class EditDistanceCalculatorTest extends Assert {

    @Test
    public void testMoscow() throws Exception {
        assertEquals(3, new EditDistanceCalculatorImpl().getEditDistance("москва", "ложка"));
    }

    @Test
    public void testSimple1() throws Exception {
        assertEquals(5, new EditDistanceCalculatorImpl().getEditDistance("hello", ""));
    }

    @Test
    public void testSimple2() throws Exception {
        assertEquals(5, new EditDistanceCalculatorImpl().getEditDistance("0", "kogan"));
    }

    @Test
    public void testEmpty() throws Exception {
        assertEquals(0, new EditDistanceCalculatorImpl().getEditDistance("", ""));
    }
}
