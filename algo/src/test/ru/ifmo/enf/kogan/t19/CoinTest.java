package ru.ifmo.enf.kogan.t19;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by arsenykogan on 24/05/14.
 */
public class CoinTest extends Assert {

    @Test
    public void testCoin() throws Exception {
        final CoinChanger.Coin coin = new Coin(1);
        assertEquals(1, coin.getValue());
    }

}
