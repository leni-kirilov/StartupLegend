package com.kirilov.startuplegends.game.model;

import java.util.Random;

/**
 * Created by Leni on 18.8.2014 г..
 */
public class Employee {
    private String name;
    //    private long[] stats;
    private int skill = 5; //1 - low ; 10 - master
    private String[] characteristics; //trais - slack, innovator
    private String mood = "Happy";

    private long salaryPerIteration = new Random().nextInt(1000);

    public long getSalaryPerIteration() {
        return salaryPerIteration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayStats() {
        if (mood != "X") {
            System.out.printf("%s $%d {%s}\n", name, salaryPerIteration, mood);
        }
    }

    public int getSkill() {
        return skill;
    }

    public double getMoodModifier() {
        double modifier = 0;
        switch (mood) {
            case "Happy": {
                modifier = 1.2f;
                break;
            }
            case "Neutral": {
                modifier = 1f;
                break;
            }
            case "Sad": {
                modifier = 0.3f;
                break;
            }
            case "X": {
                modifier = 0f;
                break;
            }
        }
        return modifier;
    }

    public void decreaseMood() {
        switch (mood) {
            case "Happy": {
                mood = "Neutral";
                break;
            }
            case "Neutral": {
                mood = "Sad";
                break;
            }
            case "Sad": {
                mood = "X";
                break;
            }
        }
    }

    public void increaseMood() {
        switch (mood) {
            case "Neutral": {
                mood = "Happy";
                break;
            }
            case "Sad": {
                mood = "Neutral";
                break;
            }
            case "X": {
                mood = "Sad";
                break;
            }
        }
    }

    // mood happiness, motivation,
}
