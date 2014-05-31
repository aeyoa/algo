package ru.ifmo.enf.kogan.finaltask;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by arsenykogan on 31/05/14.
 */
public class EditDistanceCalculatorImpl implements EditDistanceCalculator {

    @Override
    public int getEditDistance(final String s1, final String s2) {
        final int l1 = s1.length();
        final int l2 = s2.length();
        final int[][] distances = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            distances[i][0] = i;
        }

        for (int i = 0; i <= l2; i++) {
            distances[0][i] = i;
        }

        for (int j = 1; j <= l2; j++) {
            for (int i = 1; i <= l1; i++) {
                if (s1.substring(0, i).equals(s2.substring(0, j))) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    int delete = distances[i - 1][j] + 1;
                    int insert = distances[i][j - 1] + 1;
                    int replace = distances[i - 1][j - 1] + 1;
                    distances[i][j] = Collections.min(Arrays.asList(delete, insert, replace));
                    System.out.println(delete + " " + insert + " " + replace + " : " + distances[i][j]);
                }
            }

        }
        return distances[l1][l2];
    }
}
