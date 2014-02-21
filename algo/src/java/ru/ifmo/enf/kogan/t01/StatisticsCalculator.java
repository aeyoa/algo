package ru.ifmo.enf.kogan.t01;

/**
 * Created by arsenykogan on 21/02/14.
 */
public interface StatisticsCalculator<E extends Comparable<E>> {
    E getStatistics(int k);
}
