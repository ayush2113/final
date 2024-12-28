package com.studentmanagementsystem.service.impl;

import java.util.Random;

public class RandomNameGenerator {
    private String randomName(int letters, int length) {
        StringBuffer name = new StringBuffer();

        for (int i = 1; i <= length; i++) {
            name.append(
                    (char)(new Random().nextInt(letters)+'A')
            );
        }

        return name.toString();
    }

    private String randomInteger(Integer totalNumbers, Integer length) {
        StringBuilder name = new StringBuilder();

        for (int i = 1; i <= length; i++) {
            name.append(
                    new Random().nextInt(totalNumbers)
            );
        }

        return name.toString();
    }

    public String next(int letters, int length) {
        return randomName(letters, length);
    }

    public int nextInt(int totalNumber, int length) {

        return Integer.parseInt(randomInteger(totalNumber, length));
    }

    public String nextIntString(int totalNumber, int length) {
        return randomInteger(totalNumber, length);
    }
}
