package ru.ifmo.enf.kogan.t11;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class Entity implements СlusteringAlgorithm.Entity {

    final String name;
    final double[] coordinates;

    public Entity(final String name, final double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }


    @Override
    public String name() {
        return null;
    }

    @Override
    public double[] getCoordinates() {
        return coordinates;
    }
}
