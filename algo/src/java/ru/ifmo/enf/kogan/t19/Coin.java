package ru.ifmo.enf.kogan.t19;

import java.util.Comparator;

/**
 * Created by arsenykogan on 24/05/14.
 */
public class Coin implements CoinChanger.Coin {

    private final int value;

    public Coin(final int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }


    static Comparator<CoinChanger.Coin> getComparator() {
        return new Comparator<CoinChanger.Coin>() {
            @Override
            public int compare(final CoinChanger.Coin o1, final CoinChanger.Coin o2) {
                int res = (o1.getValue() > o2.getValue()) ? 1 : -1;
                if (o1.getValue() == o2.getValue()) {
                    res = 0;
                }
                return res;

            }
        };
    }
}
