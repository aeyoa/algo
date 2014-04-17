package ru.ifmo.enf.kogan.t13;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by arsenykogan on 12/04/14.
 */
public class PerceptronTrainingImpl implements PerceptronTraining {

    private Perceptron perceptron;
    private final Random random = new Random();

    public PerceptronTrainingImpl() {
        perceptron = null;
    }

    @Override
    public Perceptron train(final double trainingSpeed, final Iterable<TrainingData> trainingDataSet) {
        initializeWithRandom(trainingDataSet.iterator().next().getInput().size());

        boolean weightChanged = true;
        while (weightChanged) {

            weightChanged = false;
            final Iterator<TrainingData> trainingDataIterator = trainingDataSet.iterator();
            while (trainingDataIterator.hasNext()) {
                final TrainingData trainingData = trainingDataIterator.next();
                final java.util.List<Double> weights = perceptron.getWeights();
                for (int i = 0; i < weights.size(); i++) {
                    double change = trainingSpeed *
                            (trainingData.retResult() - perceptron.getOutput(trainingData.getInput())) * trainingData.getInput().get(i);
                    weights.set(i, weights.get(i) + change);
                    // (weightChanged is true) IF (change is not zero) OR (weightChanged already is true)
                    weightChanged = (change != 0) || weightChanged;
                }
            }
        }
        return perceptron;
    }

    private void initializeWithRandom(final int numberOfInputs) {
        final Double[] weights = new Double[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++) {
            weights[i] = random.nextDouble() + 0.5;
        }
        weights[0] = weights[0] * (-1);
        perceptron = new ru.ifmo.enf.kogan.t13.Perceptron(Arrays.asList(weights));
    }
}
