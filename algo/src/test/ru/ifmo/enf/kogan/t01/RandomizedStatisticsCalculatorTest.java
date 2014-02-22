package ru.ifmo.enf.kogan.t01;

import junit.framework.Assert;
import org.junit.Test;
import ru.ifmo.enf.kogan.t01.RandomizedStatisticsCalculator;
import ru.ifmo.enf.kogan.t01.StatisticsCalculator;

/**
 * Created by arsenykogan on 21/02/14.
 */
public class RandomizedStatisticsCalculatorTest extends Assert {

    @Test
    public void normalArray1() {
        final Integer[] array = {10, 5, 112, 1, 2, 3};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(3), statisticsCalculator.getStatistics(2));

    }

    @Test
    public void normalArray2() {
        final Integer[] array = {1, 2, 3, 4, 5};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(0));
        assertEquals(new Integer(2), statisticsCalculator.getStatistics(1));
        assertEquals(new Integer(3), statisticsCalculator.getStatistics(2));
        assertEquals(new Integer(4), statisticsCalculator.getStatistics(3));
        assertEquals(new Integer(5), statisticsCalculator.getStatistics(4));
    }


    @Test
    public void normalArray2Inverted() {
        final Integer[] array = {5, 4, 3, 2, 1};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(0));
        assertEquals(new Integer(2), statisticsCalculator.getStatistics(1));
        assertEquals(new Integer(3), statisticsCalculator.getStatistics(2));
        assertEquals(new Integer(4), statisticsCalculator.getStatistics(3));
        assertEquals(new Integer(5), statisticsCalculator.getStatistics(4));
    }


    @Test
    public void plainArray() {
        final Integer[] array = {1, 1, 1};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(0));
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(1));
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(2));
    }

    @Test
    public void stringArray() {
        final String[] array = {"Alpha", "Gamma", "Beta"};
        final StatisticsCalculator<String> statisticsCalculator = new RandomizedStatisticsCalculator<String>(array);
        assertEquals(new Integer("Alpha"), statisticsCalculator.getStatistics(0));
        assertEquals(new Integer("Beta"), statisticsCalculator.getStatistics(1));
        assertEquals(new Integer("Gamma"), statisticsCalculator.getStatistics(2));
    }


    @Test
    public void oneElemArray() {
        final Integer[] array = {1};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void outOfBounds() {
        final Integer[] array = {1};
        final StatisticsCalculator<Integer> statisticsCalculator = new RandomizedStatisticsCalculator<Integer>(array);
        assertEquals(new Integer(1), statisticsCalculator.getStatistics(2));
    }

}
