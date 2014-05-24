package ru.ifmo.enf.kogan.t19;

import java.util.List;
import java.util.Set;

/**
 * Created by arsenykogan on 24/05/14.
 */
public interface CoinChanger {

    /**
     * Размен суммы денег монетками
     *
     * @param value сумма для размена
     * @return набор монеток
     */
    List<Coin> change(int value);

    /**
     * @return доступные монеты (номиналы) для размена
     */
    Set<Coin> getAvailableCoins();

    interface Coin {
        /**
         * @return номинал монеты
         */
        int getValue();
    }
}
