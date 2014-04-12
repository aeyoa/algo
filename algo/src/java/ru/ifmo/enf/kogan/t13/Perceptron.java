package ru.ifmo.enf.kogan.t13;

import java.util.Iterator;
import java.util.List;

/**
 * Created by arsenykogan on 12/04/14.
 */
public class Perceptron implements PerceptronTraining.Perceptron {

    private final List<Double> weights;

    public Perceptron(final List<Double> weights) {
        this.weights = weights;
    }

    @Override
    public List<Double> getWeights() {
        return weights;
    }

    @Override
    public double getOutput(final List<Double> inputValues) {
        final Iterator<Double> inputValuesIterator = inputValues.iterator();
        final Iterator<Double> weightsIterator = getWeights().iterator();
        double res = 0;
        while (inputValuesIterator.hasNext() && weightsIterator.hasNext()) {
            res += inputValuesIterator.next() * weightsIterator.next();
        }
        return (res > 0) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Perceptron{" +
                "weights=" + weights +
                '}';
    }
}
