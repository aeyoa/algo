package ru.ifmo.enf.kogan.t16;

import junit.framework.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by arsenykogan on 26/04/14.
 */
public class LabelsDataReaderTest extends Assert {

    final String dir = "src/test/ru/ifmo/enf/kogan/t14/";
    final String file = dir + "train-labels-idx1-ubyte";

    @Test
    public void firstNumbersTest() throws FileNotFoundException {
        final LabelsDataReader labelsDataReader = new LabelsDataReader(5);
        final Collection<Integer> labels = labelsDataReader.readLabelData(new FileInputStream(file));
        assertTrue(Arrays.equals(labels.toArray(), new Integer[] {5, 0, 4, 1, 9}));
    }
}
