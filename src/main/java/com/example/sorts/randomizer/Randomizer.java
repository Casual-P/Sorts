package com.example.sorts.randomizer;

public class Randomizer {
    public static void fillRandom(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
    }
}
