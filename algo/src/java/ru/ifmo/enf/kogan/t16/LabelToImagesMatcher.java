package ru.ifmo.enf.kogan.t16;

import ru.ifmo.enf.kogan.t14.ImageDataReader;
import ru.ifmo.enf.kogan.t14.TestDataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class LabelToImagesMatcher {

    private final Collection<TrainingImageData> trainingImages;
    private Integer numberOfImages = null;

    public LabelToImagesMatcher() {
        trainingImages = new ArrayList<TrainingImageData>();
    }

    public LabelToImagesMatcher(final int numberOfImages) {
        this.numberOfImages = numberOfImages;
        trainingImages = new ArrayList<TrainingImageData>();
    }

    public Collection<TrainingImageData> matchLabelsToImages(final String imagesFilename, final String labelsFilename) throws FileNotFoundException {
        /* Read labels here. */
        final LabelsDataReader labelsDataReader = new LabelsDataReader(numberOfImages);
        final Collection<Integer> labels = labelsDataReader.readLabelData(new FileInputStream(labelsFilename));
        /* Read images here. */
        final TestDataReader testDataReader = new TestDataReader(numberOfImages);
        final Collection<ImageDataReader.ImageData> images = testDataReader.readImageData(new FileInputStream(imagesFilename));

        final Iterator<ImageDataReader.ImageData> imagesIterator = images.iterator();
        final Iterator<Integer> labelsIterator = labels.iterator();

        while (imagesIterator.hasNext() && labelsIterator.hasNext()) {
            trainingImages.add(new TrainingImageData(imagesIterator.next(), labelsIterator.next()));
        }

        return trainingImages;
    }
}
