package ru.ifmo.enf.kogan.t11;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class DistanceCalculatorTest extends Assert {

    @Test
    public void distanceIn2d() {
        assertEquals(0.0, new DistanceCalculator().getDistance(
                new Entity("A", new double[]{1, 1}),
                new Entity("B", new double[]{1, 1})));

        assertEquals(Math.sqrt(2), new DistanceCalculator().getDistance(
                new Entity("A", new double[]{0, 0}),
                new Entity("B", new double[]{1, 1})));

        assertEquals(1., new DistanceCalculator().getDistance(
                new Entity("A", new double[]{0, 0}),
                new Entity("B", new double[]{0, 1})));

        assertEquals(Math.sqrt(9 + 4), new DistanceCalculator().getDistance(
                new Entity("A", new double[]{5, 3}),
                new Entity("B", new double[]{2, 1})));
    }

    @Test
    public void distanceNd() {
        assertEquals(Math.sqrt(970), new DistanceCalculator().getDistance(
                new Entity("A", new double[]{10, 11, 12, 13}),
                new Entity("B", new double[]{32, 12, 34, 12})));

        assertEquals(Math.sqrt(105), new DistanceCalculator().getDistance(
                new Entity("A", new double[]{3, 1, 4, 1, 5, 9}),
                new Entity("B", new double[]{2, 7, 1, 8, 2, 8})));
    }

}
