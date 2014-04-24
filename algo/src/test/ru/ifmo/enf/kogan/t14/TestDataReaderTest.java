package ru.ifmo.enf.kogan.t14;

import junit.framework.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * Created by arsenykogan on 19/04/14.
 */
public class TestDataReaderTest extends Assert {

    final String dir = "src/test/ru/ifmo/enf/kogan/t14/";
    final String file = dir + "train-images-idx3-ubyte";

    @Test
    public void writeImages() throws FileNotFoundException {
        final ImageDataReader imageDataReader = new TestDataReader(10);
        final Collection<ImageDataReader.ImageData> images =
                imageDataReader.readImageData(new FileInputStream(file));

        int index = 0;
        for (ImageDataReader.ImageData image : images) {
            image.persist(dir + "images/" + "img-" + index++ + ".png");
        }
    }

    @Test
    public void magicNumberTest() throws FileNotFoundException {
        final TestDataReader dataReader = new TestDataReader(1);
        dataReader.readImageData(new FileInputStream(file));
        assertEquals(2051, dataReader.getMagicNumber());
    }

    @Test
    public void widthAndHeightTest() throws FileNotFoundException {
        final ImageDataReader imageDataReader = new TestDataReader(10);
        final Collection<ImageDataReader.ImageData> images =
                imageDataReader.readImageData(new FileInputStream(file));

        for (ImageDataReader.ImageData image : images) {
            assertEquals(28, image.getHeight());
            assertEquals(28, image.getWidth());
        }
    }
}
