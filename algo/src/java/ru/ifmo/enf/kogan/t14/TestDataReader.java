package ru.ifmo.enf.kogan.t14;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by arsenykogan on 19/04/14.
 */
public class TestDataReader implements ImageDataReader {

    private long magicNumber;
    private Integer imagesToRead;

    public TestDataReader() {
        imagesToRead = null;
    }

    public TestDataReader(final int imagesToRead) {
        this.imagesToRead = imagesToRead;
    }

    @Override
    public Collection<ImageData> readImageData(final InputStream in) {

        final List<ImageData> images = new ArrayList<ImageData>();
        try {

            /* Read some auxiliary data: magic number,
            number of images to read,
            width and height. */
            magicNumber = mergeFourBytes(in);

            /* If number of images to read is not specified,
            * read ALL images. If specified — just skip read number. */
            if (imagesToRead == null) {
                imagesToRead = (int) mergeFourBytes(in);
            } else {
                int numberOfImages = (int) mergeFourBytes(in);
                /* Check the number of images to read. */
                if (numberOfImages < imagesToRead) {
                    imagesToRead = numberOfImages;
                }
            }

            /* Read width and height of the images. */
            final int width = (int) mergeFourBytes(in);
            final int height = (int) mergeFourBytes(in);

            /* Read images here. */
            for (int i = 0; i < imagesToRead; i++) {
                final byte[] imagePixelsBytes = new byte[width * height];
                final int[] imagePixels = new int[width * height];
                in.read(imagePixelsBytes);

                /* Convert unsigned byte to int. */
                for (int j = 0; j < imagePixels.length; j++) {
                    imagePixels[j] = (imagePixelsBytes[j] & 0xFF);
                }
                images.add(new ru.ifmo.enf.kogan.t14.ImageData(imagePixels, width, height));
            }

            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return images;
    }

    private long mergeFourBytes(final InputStream in) throws IOException {
        final int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.read();
        }
        long res = arr[0];
        res = (res << 8) | (arr[1] & 0xFF);
        res = (res << 8) | (arr[2] & 0xFFFF);
        res = (res << 8) | (arr[3] & 0xFFFFFF);
        return res;
    }

    /* Returns "magic number" to test proper file reading. */
    public long getMagicNumber() {
        return magicNumber;
    }
}
