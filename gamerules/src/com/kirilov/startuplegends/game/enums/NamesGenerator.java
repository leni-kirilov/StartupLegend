package com.kirilov.startuplegends.game.enums;

import java.util.Random;

/**
 * Created by Leni on 18.8.2014 г..
 */
public class NamesGenerator {
    private static final String[] names = {"Cool Dude", "Bitch", "Slacker", "Master", "Bai Ivan", "Neo", "Ursula", "Gandalf"};
    private static final Random r = new Random(System.currentTimeMillis());

    public static String getRandomName() {
        int randomInt = r.nextInt(names.length);
        return names[randomInt];
    }
}
