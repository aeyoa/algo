package ru.ifmo.enf.kogan.t01;

import java.util.Random;

/**
 * Created by arsenykogan on 21/02/14.
 */
public class RandomizedStatisticsCalculator<E extends Comparable<E>> implements StatisticsCalculator<E> {

    final E[] items;
    int key;

    public RandomizedStatisticsCalculator(final E[] items) {
        this.items = items;
    }

    @Override
    public E getStatistics(int k) {
        this.key = k;
        quickSort(items, 0, items.length - 1);
        return items[k];
    }

    private void quickSort(final Comparable[] items, final int leftIndex, final int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = getRandomIndex(leftIndex, rightIndex);
            pivotIndex = split(items, leftIndex, rightIndex, pivotIndex);
            if (pivotIndex > key) {
                quickSort(items, leftIndex, pivotIndex - 1);
            }
            if (pivotIndex < key) {
                quickSort(items, pivotIndex + 1, rightIndex);
            }
        }
    }

    /**
     * This method will split this part of array into two parts:
     * SMALLER and EQUAL to pivot,
     * GREATER than pivot.
     * And then concatenate in that order:
     * (SMALLER and EQUAL, PIVOT, GREATER)
     */
    private int split(final Comparable[] items, final int leftIndex, final int rightIndex, final int pivotIndex) {
        final Comparable pivotValue = items[pivotIndex];
        swap(items, rightIndex, pivotIndex); // Make pivot last item in array.
        int filter = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (items[i].compareTo(pivotValue) <= 0) {
                swap(items, i, filter);
                filter++;
            }
        }
        swap(items, filter, rightIndex);
        return filter;
    }

    private void swap(final Comparable[] items, final int index1, final int index2) {
        if (index1 != index2) {
            Comparable temp = items[index1];
            items[index1] = items[index2];
            items[index2] = temp;
        }
    }

    private int getRandomIndex(final int leftIndex, final int rightIndex) {
        return leftIndex + new Random().nextInt(rightIndex - leftIndex + 1);
    }
}
