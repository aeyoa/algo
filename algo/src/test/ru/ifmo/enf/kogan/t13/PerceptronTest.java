package ru.ifmo.enf.kogan.t13;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by arsenykogan on 12/04/14.
 */
public class PerceptronTest extends Assert {

    @Test
    public void simpleTest() {
        final PerceptronTraining.Perceptron p1 = new Perceptron(Arrays.asList(-1d, 1d, 1d));
        assertEquals(1d, p1.getOutput(Arrays.asList(1d, 1d, 1d)));

        final PerceptronTraining.Perceptron p2 = new Perceptron(Arrays.asList(-1d, 0d, 0d));
        assertEquals(-1d, p2.getOutput(Arrays.asList(1d, 10d, 10d)));

        final PerceptronTraining.Perceptron p3 = new Perceptron(Arrays.asList(-1d, 2d, 3d));
        assertEquals(1d, p3.getOutput(Arrays.asList(1d, 10d, 10d)));
    }
}
