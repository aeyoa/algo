package ru.ifmo.enf.kogan.t19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by arsenykogan on 24/05/14.
 */
public class CoinChangerImpl implements CoinChanger {

    private final Set<Coin> coins;
    private final List<Coin> sortedCoins;

    public CoinChangerImpl(final Set<Coin> coins) {
        this.coins = coins;
        this.sortedCoins = new ArrayList<>();
        sortedCoins.addAll(coins);
        Collections.sort(sortedCoins, ru.ifmo.enf.kogan.t19.Coin.getComparator());
        Collections.reverse(sortedCoins);
    }

    @Override
    public List<Coin> change(final int value) {
        int currentValue = value;
        final List<Coin> res = new ArrayList<>();
        for (Coin coin : sortedCoins) {
            int numberOfCoins = currentValue / coin.getValue();
            for (int i = 0; i < numberOfCoins; i++) {
                res.add(coin);
                currentValue -= coin.getValue();
            }
        }
        if (currentValue > 0) {
            throw new IllegalArgumentException("Can't change this amount of money with these coins. ");
        }
        return res;
    }

    @Override
    public Set<Coin> getAvailableCoins() {
        return coins;
    }

}
