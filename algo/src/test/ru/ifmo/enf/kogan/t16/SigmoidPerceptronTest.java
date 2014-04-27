package ru.ifmo.enf.kogan.t16;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class SigmoidPerceptronTest extends Assert {

    @Test
    public void perceptronResultTest() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(Arrays.asList(1d, 1d, 1d));
        assertEquals(0.5, perceptron.getOutput(Arrays.asList(0d, 0d, 0d)));
        assertEquals(1, perceptron.getOutput(Arrays.asList(10d, 10d, 10d)), 0.01);
        assertEquals(0, perceptron.getOutput(Arrays.asList(-10d, -10d, -10d)), 0.01);
    }

    @Test
    public void getWeights() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(Arrays.asList(1d, 1d, 1d));
        assertEquals(Arrays.asList(1d, 1d, 1d), perceptron.getWeights());
    }

    @Test
    public void getWeight() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(Arrays.asList(1d, 2d, 3d));
        assertEquals(1d, perceptron.getWeight(0));
        assertEquals(2d, perceptron.getWeight(1));
        assertEquals(3d, perceptron.getWeight(2));
    }

    @Test
    public void setWeights() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(Arrays.asList(0d, 0d, 0d));
        perceptron.setWeight(0, 1d);
        perceptron.setWeight(1, 2d);
        perceptron.setWeight(2, 3d);
        assertEquals(1d, perceptron.getWeight(0));
        assertEquals(2d, perceptron.getWeight(1));
        assertEquals(3d, perceptron.getWeight(2));
    }

    @Test
    public void numberOfInputs() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(Arrays.asList(0d, 0d, 0d, 0d, 0d));
        assertEquals(5, perceptron.getInputCount());
    }

    @Test
    public void randomPerceptronToString() {
        final SigmoidPerceptron perceptron = new SigmoidPerceptron(5);
        System.out.println(perceptron);
    }
}
