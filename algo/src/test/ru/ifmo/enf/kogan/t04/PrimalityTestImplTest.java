package ru.ifmo.enf.kogan.t04;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenykogan on 28/02/14.
 */
public class PrimalityTestImplTest extends Assert {

    @Test
    public void firstPrimeNumbers() {
        final PrimalityTestImpl primalityTest = new PrimalityTestImpl();
        final List<Long> bruteForceNumbers = new ArrayList<Long>();
        final List<Long> probabilityNumbers = new ArrayList<Long>();
        for (int i = 0; i < 100; i++) {
            if (primalityTest.bruteForceIsPrime(i)) {
                bruteForceNumbers.add(new Long(i));
            }
            if (primalityTest.isProbablyPrime(i)) {
                probabilityNumbers.add(new Long(i));
            }
            for (Long probabilityNumber : probabilityNumbers) {
                assertTrue(bruteForceNumbers.contains(probabilityNumber));
            }
        }
    }

    @Test
    public void primeNumbersFrom1000to3000() {
        final ProbablyPrimeCalculator primeCalculator = new PrimalityTestImpl();
        final long[] primeNumbers = {1009, 1013, 1019,
                1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069,
                1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129,
                1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213,
                1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279,
                1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321,
                1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427,
                1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481,
                1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543,
                1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601,
                1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663,
                1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733,
                1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801,
                1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877,
                1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951,
                1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017,
                2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087,
                2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143,
                2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239,
                2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297,
                2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371,
                2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423,
                2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521,
                2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593,
                2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663, 2671,
                2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713,
                2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789,
                2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851,
                2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927,
                2939, 2953, 2957, 2963, 2969, 2971, 2999};
        for (long primeNumber : primeNumbers) {
            assertTrue(primeCalculator.isProbablyPrime(primeNumber));
        }
    }

    @Test
    public void bigPrimeNumbers() {
        final ProbablyPrimeCalculator primeCalculator = new PrimalityTestImpl();
        final long[] bigPrimeNumbers = {1299437, 1299439, 1299449, 1299451, 1299457, 1299491, 1299499, 1299533, 1299541,
                1299553, 1299583, 1299601, 1299631, 1299637, 1299647, 1299653, 1299673, 1299689, 1299709, 1299721, 1299743,
                1299763, 1299791, 1299811, 1299817, 1299821, 861797, 861799, 861803, 861823, 861829, 861853, 861857, 861871,
                861877, 861881, 861899, 861901, 861907, 861929, 861937, 861941, 861947, 861977, 861979, 861997, 862009, 862013,
                862031, 862033, 862061, 862067, 862097, 862117, 862123, 862129, 862139, 862157, 862159, 862171, 862177, 862181,
                862187, 862207, 862219, 862229, 862231, 862241, 862249, 862259, 862261, 862273, 862283, 862289, 862297, 862307,
                862319, 862331, 862343, 862369, 862387, 862397, 862399, 862409, 862417, 862423, 862441, 862447};
        for (long bigPrimeNumber : bigPrimeNumbers) {
            assertTrue(primeCalculator.isProbablyPrime(bigPrimeNumber));
        }
    }

}
