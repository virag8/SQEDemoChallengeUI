package com.sample.test.demo.utils;

import java.util.Random;

public class Randoms {
    private static Random rnd = new Random();

    private Randoms() {
    }

    public static int getRandomNumber(int min, int max) {
        return rnd.nextInt(max - min) + min;
    }

    public static int getRandomNumber(int max) {
        return rnd.nextInt(max);
    }
}
