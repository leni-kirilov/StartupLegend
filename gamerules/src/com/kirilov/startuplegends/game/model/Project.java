package com.kirilov.startuplegends.game.model;

import java.util.Random;

/**
 * Created by Leni on 18.8.2014 г..
 */
public class Project {
    private int complexity;
    private int percentageCompleted;
    private String name;
    private long profit = new Random().nextInt(10000) + 5000;
    //area

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getProfit() {
        return profit;
    }
}
