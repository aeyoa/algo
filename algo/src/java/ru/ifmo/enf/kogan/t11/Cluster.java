package ru.ifmo.enf.kogan.t11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class Cluster implements СlusteringAlgorithm.Cluster {

    final List<СlusteringAlgorithm.Entity> entities;

    public Cluster() {
        this.entities = new ArrayList<>();
    }

    public void add(final СlusteringAlgorithm.Entity entity) {
        entities.add(entity);
    }

    public void addCluster(final СlusteringAlgorithm.Cluster cluster) {
        entities.addAll(cluster.getEntities());
    }

    @Override
    public List<СlusteringAlgorithm.Entity> getEntities() {
        return null;
    }
}
