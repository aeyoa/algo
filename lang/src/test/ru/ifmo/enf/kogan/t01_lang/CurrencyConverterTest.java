package ru.ifmo.enf.kogan.t01_lang;

import junit.framework.Assert;
import org.junit.Test;
import ru.ifmo.enf.kogan.t02_lang.CurrencyConverter;

import java.util.HashMap;

/**
 * Created by arsenykogan on 25/03/14.
 */
public class CurrencyConverterTest extends Assert {

    @Test
    public void convert() {
        final HashMap<String, Double> rates = new HashMap<String, Double>() {
            {
                put("rur", 1.);
                put("eur", 49.7042);
                put("usd", 35.9316);
            }
        };

        final CurrencyConverter converter = new CurrencyConverter(rates);
        assertEquals(20., converter.convert(20, "rur", "rur"));
        assertEquals(1., converter.convert(49.7042, "rur", "eur"));
        assertEquals(1., converter.convert(35.9316, "rur", "usd"));
        assertEquals(138.330, converter.convert(100., "eur", "usd"), 0.01);
    }
}
