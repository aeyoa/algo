package ru.ifmo.enf.kogan.t16;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class NeuralNetwork {

    private SigmoidPerceptron[][] perceptrons;

    public NeuralNetwork(final Integer inputCount, final Integer[] layersCount) {
        if (inputCount <= 0 || layersCount.length <= 0 || Collections.min(Arrays.asList(layersCount)) <= 0) {
            throw new IllegalArgumentException("wrong neural network parameters");
        }
        perceptrons = new SigmoidPerceptron[layersCount.length][];
        for (int i = 0; i < perceptrons.length; i++) {
            perceptrons[i] = new SigmoidPerceptron[layersCount[i]];
            int numberOfInputs = (i == 0) ? inputCount : layersCount[i - 1];
            for (int j = 0; j < perceptrons[i].length; j++) {
                perceptrons[i][j] = new SigmoidPerceptron(numberOfInputs);
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (SigmoidPerceptron[] perceptron : perceptrons) {
            res += perceptron.length + "\n";
        }
        return res;
    }
}
