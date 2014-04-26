package ru.ifmo.enf.kogan.t16;

import ru.ifmo.enf.kogan.t14.ImageDataReader;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class TrainingImageData {

    private final ImageDataReader.ImageData imageData;
    private final Integer label;

    public TrainingImageData(final ImageDataReader.ImageData imageData, final Integer label) {
        this.imageData = imageData;
        this.label = label;
    }

    public ImageDataReader.ImageData getImageData() {
        return imageData;
    }

    public Integer getLabel() {
        return label;
    }
}
