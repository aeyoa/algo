package ru.ifmo.enf.kogan.t03;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by arsenykogan on 22/02/14.
 */
public class ParadoxModelImpl implements ParadoxModel {

    final Random random;

    public ParadoxModelImpl() {
        this.random = new Random();
    }

    public ParadoxModelImpl(final long randomSeed) {
        this.random = new Random(randomSeed);
        random.setSeed(randomSeed);
    }

    @Override
    public ProbabilityPair getProbability(int repeats) {

        double successCounterChange = 0;
        double successCounterNotChange = 0;
        for (int i = 0; i < repeats; i++) {
            successCounterChange += startModeling(true) ? 1 : 0;
            successCounterNotChange += startModeling(false) ? 1 : 0;
        }

        return new ru.ifmo.enf.kogan.t03.ProbabilityPair(successCounterChange / repeats, successCounterNotChange / repeats);
    }

    private boolean startModeling(final boolean doChange) {

        final int numberOfDoors = 3;

        final int prizeDoor = random.nextInt(numberOfDoors); // Prize is behind one of the doors
        final int firstDecision = random.nextInt(numberOfDoors);
        final int openedDoor = avoidTheseNumbers(numberOfDoors, new Integer[]{firstDecision, prizeDoor});

        if (!doChange) {
            return firstDecision == prizeDoor;
        } else {
            int secondDecision = avoidTheseNumbers(numberOfDoors, new Integer[]{firstDecision, openedDoor});
            return secondDecision == prizeDoor;
        }
    }

    private int avoidTheseNumbers(final int range, final Integer[] avoid) {
        for (int i = 0; i < range; i++) {
            if (!Arrays.<Integer>asList(avoid).contains(i)) {
                return i;
            }
        }
        throw new IllegalStateException();
    }

}
