package ru.ifmo.enf.kogan.t03;

/**
 * Created by arsenykogan on 22/02/14.
 */
public class ProbabilityPair implements ParadoxModel.ProbabilityPair {

    final double ifChange;
    final double ifNotChange;

    public ProbabilityPair(double ifChange, double ifNotChange) {
        this.ifChange = ifChange;
        this.ifNotChange = ifNotChange;
    }

    @Override
    public double getIfChange() {
        return 0;
    }

    @Override
    public double getIfNotChange() {
        return 0;
    }
}
