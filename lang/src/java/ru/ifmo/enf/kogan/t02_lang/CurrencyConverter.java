package ru.ifmo.enf.kogan.t02_lang;

import java.util.HashMap;

/**
 * Created by arsenykogan on 25/03/14.
 */
public class CurrencyConverter {

    private String from = "RUR";
    private String to = "EUR";

    private final HashMap<String, Double> rates;

    public CurrencyConverter(final HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public double convert(final double originalMoney) {
        return originalMoney * rates.get(from) / rates.get(to);
    }

    public double convert(final double originalMoney, final String from, final String to) {
        return originalMoney * rates.get(from) / rates.get(to);
    }


    public void setFrom(final String from) {
        this.from = from;
    }

    public void setTo(final String to) {
        this.to = to;
    }
}
