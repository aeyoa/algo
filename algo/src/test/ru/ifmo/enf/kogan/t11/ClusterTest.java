package ru.ifmo.enf.kogan.t11;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by arsenykogan on 05/04/14.
 */
public class ClusterTest extends Assert {

    @Test
    public void createCluster() {
        final Cluster cluster = new Cluster();
        cluster.add(new Entity("A", new double[]{1, 1}));
        cluster.add(new Entity("B", new double[]{2, 2}));
        cluster.add(new Entity("C", new double[]{3, 3}));
        System.out.println(cluster);
        assertEquals(3, cluster.getEntities().size());
    }

    @Test
    public void addCluster() {
        final Cluster cluster = new Cluster();
        cluster.add(new Entity("A", new double[]{1, 1}));
        cluster.add(new Entity("B", new double[]{2, 2}));
        cluster.add(new Entity("C", new double[]{3, 3}));

        cluster.addCluster(new Cluster() {
            {
                add(new Entity("D", new double[]{1, 1}));
                add(new Entity("E", new double[]{1, 1}));
            }
        });

        System.out.println(cluster);
        assertEquals(5, cluster.getEntities().size());
    }
}
