package ru.ifmo.enf.kogan.t04;

import java.util.Random;

/**
 * Created by arsenykogan on 28/02/14.
 */
public class PrimalityTestImpl implements ProbablyPrimeCalculator {

    final Random random = new Random();

    public PrimalityTestImpl() {

    }

    @Override
    public boolean isProbablyPrime(final long n) {
        if (n % 2 == 0 || n <= 1) {
            return false;
        }

        long t = n - 1;
        int s = 0;
        // While t is even, divide t by 2
        while (t % 2 == 0) {
            t = t / 2;
            s++; // Increase power of 2
        }

        // To do precise test we need to make log2(n) rounds
        int rounds = (int) (Math.log(n) / Math.log(2));

        // Trying to find required quantity of prime witnesses
        for (int i = 0; i < rounds; i++) {
            long a = nextLong(n - 2) + 2;
            if (!isWitness(n, a, t, s)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWitness(final long n, final long a, final long t, final long s) {
        if (powerMod(a, t, n) == 1) {
            return true;
        }
        for (int k = 0; k < s; k++) {
            int res = (int) powerMod(a, (long) Math.pow(2, k) * t, n);
            if (res == n - 1) {
                return true;
            }
        }
        return false;
    }

    private long nextLong(final long n) {
        long bits, val;
        do {
            bits = (random.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0L);
        return val;
    }

    private long powerMod(final long a, final long b, final long m) {
        long t;
        if (b == 0) {
            t = 1;
        } else if (b == 1) {
            t = a;
        } else {
            long temp = powerMod(a, b / 2, m);
            if (b % 2 == 0) {
                t = (temp * temp) % m;
            } else {
                t = ((temp * temp) % m) * a % m;
            }
        }
        return t % m;
    }


    /////////////////////////////////////////////////////////
    // Simple brute force impl for small numbers and testing
    public boolean bruteForceIsPrime(final long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
