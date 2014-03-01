package ru.ifmo.enf.kogan.t05;

/**
 * Created by arsenykogan on 01/03/14.
 */
public class NodeFactor implements DecisionTree.Factor {

    private final String name;
    private final String key;
    private final String factorValue;

    public NodeFactor(final String name, final String key, final String factorValue) {
        this.name = name;
        this.key = key;
        this.factorValue = factorValue;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean is(final DecisionTree.Entity entity) {
        return entity.getAttributeValue(key).equals(factorValue);
    }
}
