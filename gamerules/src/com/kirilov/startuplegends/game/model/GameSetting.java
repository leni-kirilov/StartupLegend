package com.kirilov.startuplegends.game.model;

/**
 * Created by Leni on 18.8.2014 г..
 */
public class GameSetting {

    private int lengthInIterations;
    private int currentIteration = 0;

    public int getGameLengthInIterations() {
        return lengthInIterations;
    }

    public void setLengthInIterations(int lengthInIterations) {
        this.lengthInIterations = lengthInIterations;
    }

    public int getCurrentIteration() {
        return currentIteration;
    }

    /**
     * @return -1 for last iteration
     */
    public int moveToNextIteration() {
        int nextIteration = currentIteration + 1;
        if (nextIteration > lengthInIterations) {
            return -1;
        } else {
            currentIteration = nextIteration;
            return currentIteration;
        }
    }
}
