package ru.ifmo.enf.kogan.t05;

/**
 * Created by arsenykogan on 01/03/14.
 */
public interface DecisionTree<E extends Enum<E>> {

    E getCategory(Entity entity);

    public interface Factor {
        String name();

        boolean is(Entity entity);
    }

    public interface Entity {
        String getAttributeValue(String key);
    }


}
