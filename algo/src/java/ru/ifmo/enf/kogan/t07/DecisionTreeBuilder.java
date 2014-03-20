package ru.ifmo.enf.kogan.t07;

import ru.ifmo.enf.kogan.t05.DecisionTree;

import java.util.List;

/**
 * Created by arsenykogan on 15/03/14.
 */
public interface DecisionTreeBuilder<E extends Enum<E>> {

    DecisionTree<E> buildTree(List<DataItem<E>> dataItems, List<DecisionTree.Factor> factors);

    public interface DataItem<E extends Enum<E>> {
        DecisionTree.Entity entity();

        E category();
    }
}
