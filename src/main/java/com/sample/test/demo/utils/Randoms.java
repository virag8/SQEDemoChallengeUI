package com.sample.test.demo.utils;

import java.util.Random;

public class Randoms {

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
