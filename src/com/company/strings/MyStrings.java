package com.company.strings;

import com.company.utils.UserInputReader;

import java.util.*;

public class MyStrings {
    //exercises with strings
    private UserInputReader reader;

    public MyStrings(UserInputReader reader) {
        this.reader = reader;
    }

    public void doExercise(){
        //ex 8
        String str = reader.readString(8);
        if(str != null) {
            nonEmptySubStr(str);
        }

        //ex 9
        equalsStrings();

        //ex 10
        randomString();

        //ex 11
        str = reader.readString(11);
        if(str != null){
            printNotASCII(str);
        }
    }

    //exercise 8
    public void nonEmptySubStr(String inputText){
        System.out.println("read text and print nonempty substring");
        System.out.println("User input : "+inputText);

        List<String> subStr = new ArrayList<>();
        subStr.addAll(Arrays.asList(inputText.split(" ")));

        subStr.removeIf((String str) -> str.contains(" ") || str.equals(""));

        for(String o : subStr){
            System.out.println(o);
        }

        System.out.println();
    }

    //exercise 9
    public void equalsStrings(){
        System.out.println("s1 != s2 but s1 equals s2");
        String s1 = new String("Hello world");
        String s2 = new String("Hello world");

        System.out.println("s1.equals(s2) : "+s1.equals(s2));
        System.out.println("s1 == s2 : "+(s1 == s2));

        System.out.println("other way");
        String s3 = "Hello";
        String s4 = s3 + "";

        System.out.println("s3.equals(s4) : "+s3.equals(s4));
        System.out.println("s3 == s4 : "+(s3 == s4));

        System.out.println();
    }

    //exercise 10
    public void randomString(){
        System.out.println("random long to base36 string");
        long num =  new Random().nextLong();
        if(num < 0){
            num *= -1;
        }
        //System.out.println(num);

        String str = Long.toString(num,36);
        System.out.println(str);
        System.out.println();
    }

    //exercise 11
    public void printNotASCII(String inputText){
        System.out.println("print not ASCII characters");
        System.out.println("User input : "+inputText);

        char[] chars = inputText.toCharArray();

        for(char o : chars){
            if(o > 127) {
                System.out.println(o + " " + (int) o);
            }
        }
        System.out.println();
    }
}
