package ru.ifmo.enf.kogan.t05;

import java.util.HashMap;

/**
 * Created by arsenykogan on 02/03/14.
 */
public class Entity<E extends Enum<E>> implements DecisionTree.Entity {

    private final HashMap<String, String> attributes;
    private final E category; // If known

    // Unknown category entity constructor
    public Entity(final HashMap<String, String> attributes) {
        this.attributes = attributes;
        this.category = null;
    }

    // Entity with known category constructor
    public Entity(final E category, final HashMap<String, String> attributes) {
        this.attributes = attributes;
        this.category = category;
    }

    @Override
    public String getAttributeValue(final String key) {
        return attributes.get(key);
    }
}
