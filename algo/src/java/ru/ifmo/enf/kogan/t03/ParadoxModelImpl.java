package ru.ifmo.enf.kogan.t03;

import java.util.Random;

/**
 * Created by arsenykogan on 22/02/14.
 */
public class ParadoxModelImpl implements ParadoxModel {

    @Override
    public ProbabilityPair getProbability(int repeats) {

        int successCounterChange = 0;
        int successCounterNotChange = 0;
        for (int i = 0; i < repeats; i++) {
            successCounterChange += startModeling(true) ? 1 : 0;
            successCounterNotChange += startModeling(false) ? 1 : 0;
        }

        return new ru.ifmo.enf.kogan.t03.ProbabilityPair(successCounterChange / repeats, successCounterNotChange / repeats);
    }

    private boolean startModeling(final boolean doChange) {

        final int numberOfDoors = 3;

        final Random random = new Random();
        final int prizeDoor = random.nextInt(numberOfDoors); // Prize is behind one of the doors
        final int firstDecision = random.nextInt(numberOfDoors);
        final int openedDoor = prizeDoor + 1 % numberOfDoors;
        final int secondDecision = (openedDoor + random.nextInt(numberOfDoors - 1) + 1) % numberOfDoors;
        if (doChange) {
            return secondDecision == prizeDoor;
        }
        return firstDecision == prizeDoor;
    }

}
