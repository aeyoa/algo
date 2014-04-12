package ru.ifmo.enf.kogan.t13;

import java.util.List;

/**
 * Created by arsenykogan on 12/04/14.
 */
public class TrainingData implements PerceptronTraining.TrainingData {

    private final List<Double> values;
    private final double result;

    public TrainingData(final List<Double> values, final double result) {
        this.values = values;
        this.result = result;
    }

    @Override
    public List<Double> getInput() {
        return values;
    }

    @Override
    public double retResult() {
        return result;
    }
}
