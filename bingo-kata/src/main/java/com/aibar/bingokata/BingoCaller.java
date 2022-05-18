package com.aibar.bingokata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BingoCaller {

    private List<Integer> numbers = new ArrayList<>();
    public int callANumber() {
        int number = 0;
        do{
            number = (int) (Math.random() * 75) + 1;
        }while (numbers.contains(number));
        numbers.add(number);
        return number;
    }
}
