package ru.ifmo.enf.kogan.t11;

import java.util.Iterator;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class DistanceCalculator implements СlusteringAlgorithm.DistanceCalculator {

    @Override
    public double getDistance(final СlusteringAlgorithm.Entity e1, final СlusteringAlgorithm.Entity e2) {
        double distance = 0;
        for (DoublePair doublePair : new Provider(e1, e2)) {
            distance += (doublePair.d1 - doublePair.d2) * (doublePair.d1 - doublePair.d2);
        }
        return Math.sqrt(distance);
    }

    private static final class Provider implements Iterable<DoublePair> {

        private final СlusteringAlgorithm.Entity e1;
        private final СlusteringAlgorithm.Entity e2;

        private Provider(final СlusteringAlgorithm.Entity e1, final СlusteringAlgorithm.Entity e2) {
            this.e1 = e1;
            this.e2 = e2;
        }

        @Override
        public Iterator<DoublePair> iterator() {
            return new Iterator<DoublePair>() {

                double[] d1 = e1.getCoordinates();
                double[] d2 = e2.getCoordinates();

                int i = 0;

                @Override
                public boolean hasNext() {
                    return i < d1.length;
                }

                @Override
                public DoublePair next() {
                    final DoublePair doublePair = new DoublePair(d1[i], d2[i]);
                    i++;
                    return doublePair;
                }
            };
        }
    }

    private static final class DoublePair {
        private final double d1;
        private final double d2;

        private DoublePair(final double d1, final double d2) {
            this.d1 = d1;
            this.d2 = d2;
        }
    }
}
