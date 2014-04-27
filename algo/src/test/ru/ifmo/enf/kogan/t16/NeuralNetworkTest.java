package ru.ifmo.enf.kogan.t16;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class NeuralNetworkTest extends Assert {

    @Test
    public void printTest() {
        final NeuralNetwork neuralNetwork = new NeuralNetwork(10, new Integer[]{3, 2, 1});
        System.out.println(neuralNetwork);
    }

}
