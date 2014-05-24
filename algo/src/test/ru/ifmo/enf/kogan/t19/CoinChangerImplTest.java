package ru.ifmo.enf.kogan.t19;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by arsenykogan on 24/05/14.
 */
public class CoinChangerImplTest extends Assert {

    @Test
    public void testGetCoins() throws Exception {

        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(1));
        coins.add(new Coin(5));
        coins.add(new Coin(10));
        coins.add(new Coin(50));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        assertEquals(coins, coinChanger.getAvailableCoins());

    }

    @Test
    public void testSimpleChange1() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(1));
        coins.add(new Coin(5));
        coins.add(new Coin(10));
        coins.add(new Coin(50));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(106);
        assertEquals(50, changedCoins.get(0).getValue());
        assertEquals(50, changedCoins.get(1).getValue());
        assertEquals(5, changedCoins.get(2).getValue());
        assertEquals(1, changedCoins.get(3).getValue());
    }

    @Test
    public void testSimpleChange2() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(1));
        coins.add(new Coin(5));
        coins.add(new Coin(10));
        coins.add(new Coin(50));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(1);
        assertEquals(1, changedCoins.get(0).getValue());
    }

    @Test
    public void testSimpleChange3() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(1));
        coins.add(new Coin(5));
        coins.add(new Coin(10));
        coins.add(new Coin(50));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(12);
        assertEquals(10, changedCoins.get(0).getValue());
        assertEquals(1, changedCoins.get(1).getValue());
        assertEquals(1, changedCoins.get(2).getValue());
    }

    @Test
    public void zeroChange() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(1));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(0);
        assertTrue(changedCoins.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUnrealChange1() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(2));
        coins.add(new Coin(4));
        coins.add(new Coin(8));
        coins.add(new Coin(16));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(37);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUnrealChange2() throws Exception {
        final Set<CoinChanger.Coin> coins = new HashSet<>();
        coins.add(new Coin(2));
        final CoinChanger coinChanger = new CoinChangerImpl(coins);
        List<CoinChanger.Coin> changedCoins = coinChanger.change(3);
    }

}
