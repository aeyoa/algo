package ru.ifmo.enf.kogan.t03;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by arsenykogan on 22/02/14.
 */
public class ParadoxModelImplTest extends Assert {

    final double TWO_THIRDS = 2d / 3d;
    final double ONE_THIRD = 1d / 3d;

    @Test
    public void probabilityTest1() {
        final int repeats = 100;
        final double delta = 0.1;
        final ParadoxModel.ProbabilityPair pair = new ParadoxModelImpl(1).getProbability(repeats);
        assertEquals(TWO_THIRDS, pair.getIfChange(), delta);
        assertEquals(ONE_THIRD, pair.getIfNotChange(), delta);
    }

    @Test
    public void probabilityTest2() {
        final int repeats = 10000;
        final double delta = 0.01;
        final ParadoxModel.ProbabilityPair pair = new ParadoxModelImpl(1).getProbability(repeats);
        assertEquals(TWO_THIRDS, pair.getIfChange(), delta);
        assertEquals(ONE_THIRD, pair.getIfNotChange(), delta);
    }   
}
