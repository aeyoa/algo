package ru.ifmo.enf.kogan.t13;

import java.util.List;

/**
 * Created by arsenykogan on 12/04/14.
 */
public interface PerceptronTraining {

    /**
     * Обучает перцептрон
     *
     * @param trainingSpeed   константа скорости обучения
     * @param trainingDataSet набор тестовых данных для обучения
     * @return обученный перцептрон
     */
    Perceptron train(double trainingSpeed, Iterable<TrainingData> trainingDataSet);

    /**
     * данные для обучения перцептрона
     */
    interface TrainingData {

        /**
         * @return данные, подающиеся на входы перцептрона
         */
        List<Double> getInput();

        /**
         * @return значение срабатывания перцептронов на этих тестовых данных
         */
        double retResult();
    }

    /**
     * Модель перцептрона
     */
    interface Perceptron {

        /**
         * @return веса входов, в 0 позиции – лимит срабатывания
         */
        List<Double> getWeights();

        /**
         * @param inputValues значения на входах перцептрона
         * @return 1 если перцептрон срабатывает, иначе -1
         */
        double getOutput(List<Double> inputValues);
    }

}

