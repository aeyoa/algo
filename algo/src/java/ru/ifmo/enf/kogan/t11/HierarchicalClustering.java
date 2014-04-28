package ru.ifmo.enf.kogan.t11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class HierarchicalClustering implements СlusteringAlgorithm {

    private List<Cluster> clusterList;

    public HierarchicalClustering() {
    }

    @Override
    public List<Cluster> getClusters(final Iterable<Entity> entities, final DistanceCalculator distanceCalculator, final int maxClusters) {

        /* Create singe-clusters for all entities. */
        clusterList = new ArrayList<Cluster>();
        for (Entity entity : entities) {
            clusterList.add(new ru.ifmo.enf.kogan.t11.Cluster() {
                {
                    add(entity);
                }
            });
        }


        return null;
    }

    private List<Cluster> splitIntoClusters(final double t) {

        for (Cluster cluster : clusterList) {

        }
        return clusterList;
    }

    private Entity centerOfCluster(final Cluster cluster) {
        final int dim = cluster.getEntities().get(0).getCoordinates().length;
        final double[] coordinates = new double[dim];

        for (int i = 0; i < dim; i++) {
            double sum = 0;
            for (Entity entity : cluster.getEntities()) {
                sum += entity.getCoordinates()[i];
            }
            coordinates[i] = sum / cluster.getEntities().size();
        }
        return new ru.ifmo.enf.kogan.t11.Entity("center", coordinates);
    }
}
