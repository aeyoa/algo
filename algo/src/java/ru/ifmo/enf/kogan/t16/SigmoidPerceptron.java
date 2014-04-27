package ru.ifmo.enf.kogan.t16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class SigmoidPerceptron {

    private final List<Double> weights;

    /* Initialize perceptron with specified weights.*/
    public SigmoidPerceptron(final List<Double> weights) {
        this.weights = weights;
    }

    /* Initialize perceptron with random weights.*/
    public SigmoidPerceptron(final int numberOfInputs) {
        final Random random = new Random();
        weights = new ArrayList<>();
        for (int i = 0; i < numberOfInputs; i++) {
            weights.add(random.nextDouble());
        }
    }

    public List<Double> getWeights() {
        return weights;
    }

    public Double getWeight(final int index) {
        return weights.get(index);
    }

    public Double setWeight(final int index, final Double weight) {
        return weights.set(index, weight);
    }

    public int getInputCount() {
        return weights.size();
    }

    /* Calculates sigmoid function from inputs. */
    public double getOutput(final List<Double> inputValues) {
        final Iterator<Double> inputValuesIterator = inputValues.iterator();
        final Iterator<Double> weightsIterator = getWeights().iterator();
        double res = 0;
        while (inputValuesIterator.hasNext() && weightsIterator.hasNext()) {
            res += inputValuesIterator.next() * weightsIterator.next();
        }
        return 1 / (1 + Math.exp(-res));
    }

    public String toString() {
        return "Perceptron{" +
                "weights=" + weights +
                '}';
    }
}
