package ru.ifmo.enf.kogan.t13;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arsenykogan on 12/04/14.
 */
public class PerceptronImplTest extends Assert {

    @Test
    public void simpleTest() {
        final PerceptronTrainingImpl perceptronTraining = new PerceptronTrainingImpl();
        final ArrayList trainingDataList = new ArrayList<PerceptronTraining.TrainingData>() {
            {
                add(new TrainingData(Arrays.asList(1d, 0d, 1d), 1));
                add(new TrainingData(Arrays.asList(1d, 1d, 0d), 1));
//                add(new TrainingData(Arrays.asList(1d, 1d, 1d), 1));
//                add(new TrainingData(Arrays.asList(1d, 0d, 0d), 0));
            }
        };
//        System.out.println(p.getOutput(Arrays.asList(1d, 1d, 0d)));
//        System.out.println(p.getOutput(Arrays.asList(1d, 1d, 0d)));
//        System.out.println(p.getOutput(Arrays.asList(1d, 0d, 1d)));
//        System.out.println(p.getOutput(Arrays.asList(1d, 1d, 1d)));
//        System.out.println(p);

        for (int i = 0; i < 1000; i++) {
            final PerceptronTraining.Perceptron p = perceptronTraining.train(.1, trainingDataList);
            assertEquals(1.0, p.getOutput(Arrays.asList(1d, 1d, 0d)));
            assertEquals(1.0, p.getOutput(Arrays.asList(1d, 0d, 1d)));
        }
    }
}
