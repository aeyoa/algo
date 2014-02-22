package ru.ifmo.enf.kogan.t03;

/**
 * Created by arsenykogan on 22/02/14.
 */

public interface ParadoxModel {

    ProbabilityPair getProbability(int repeats);

    interface ProbabilityPair {
        double getIfChange();

        double getIfNotChange();
    }
}
