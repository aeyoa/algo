package ru.ifmo.enf.kogan.t07;

import ru.ifmo.enf.kogan.t05.DecisionTree;
import ru.ifmo.enf.kogan.t05.Entity;

import java.util.HashMap;

/**
 * Created by arsenykogan on 19/03/14.
 */
public class DataItem<E extends Enum<E>> implements DecisionTreeBuilder.DataItem<E> {


    final DecisionTree.Entity entity;
    final E category;

    public DataItem(final DecisionTree.Entity entity, final E category) {
        this.entity = entity;
        this.category = category;
    }


    @Override
    public DecisionTree.Entity entity() {
        return entity;
    }

    @Override
    public E category() {
        return category;
    }
}
