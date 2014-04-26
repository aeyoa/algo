package ru.ifmo.enf.kogan.t16;

import junit.framework.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class LabelToImagesMatcherTest extends Assert {

    final String dir = "src/test/ru/ifmo/enf/kogan/t14/";
    final String labelsFile = dir + "train-labels-idx1-ubyte";
    final String imagesFile = dir + "train-images-idx3-ubyte";

    @Test
    public void rightLabelsTest() throws FileNotFoundException {
        final LabelToImagesMatcher matcher = new LabelToImagesMatcher(10);
        final Collection<TrainingImageData> trainingImageData = matcher.matchLabelsToImages(imagesFile, labelsFile);
        for (TrainingImageData imageData : trainingImageData) {
            System.out.println(imageData.getLabel());
        }
    }
}
