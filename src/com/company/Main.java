package com.company;

import com.company.primitives.MyNumbers;
import com.company.strings.MyStrings;
import com.company.utils.UserInputReader;

public class Main {

    public static void main(String[] args) {
        UserInputReader reader = new UserInputReader("F://NetCracker//homeWork3//userInput.txt");

        MyNumbers numbers = new MyNumbers(reader);
        numbers.doExercise();

        MyStrings strings = new MyStrings(reader);
        strings.doExercise();
    }
}
