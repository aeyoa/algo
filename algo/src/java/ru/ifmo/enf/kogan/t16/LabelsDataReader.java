package ru.ifmo.enf.kogan.t16;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class LabelsDataReader {

    private long magicNumber;
    private Integer imagesToRead;

    public LabelsDataReader() {
        imagesToRead = null;
    }

    public LabelsDataReader(final int imagesToRead) {
        this.imagesToRead = imagesToRead;
    }

    public Collection<Integer> readLabelData(final InputStream in) {

        final List<Integer> labels = new ArrayList<Integer>();
        try {

            /* Read some auxiliary data: magic number
            and number of images to read */
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

            /* Read labels here. */
            for (int i = 0; i < imagesToRead; i++) {

                /* Convert unsigned byte to int. */
                final Integer imageLabel = in.read() & 0xFF;
                labels.add(imageLabel);
            }

            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return labels;
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
