package com.company.strings;

import java.util.*;

public class MyStrings {
    //exercises with strings
    private final static Scanner scanner = new Scanner(System.in);

    //exercise 8
    public static void nonEmptySubStr(){
        System.out.println("read text and print nonempty substring");
        System.out.print("input text : ");
        String inputText = scanner.nextLine();

        List<String> subStr = new ArrayList<>();
        subStr.addAll(Arrays.asList(inputText.split(" ")));

        subStr.removeIf((String str) -> str.contains(" ") || str.equals(""));

        for(String o : subStr){
            System.out.println(o);
        }
    }

    //exercise 9
    public static void equalsStrings(){
        System.out.println("s1 != s2 but s1 equals s2");
        String s1 = new String("Hello world");
        String s2 = new String("Hello world");

        System.out.println("s1.equals(s2) : "+s1.equals(s2));
        System.out.println("s1 == s2 : "+(s1 == s2));


        // or use any methods that return new String
        System.out.println("other way");
        String s3 = "Hello";
        String s4 = s3.replaceAll("","");

        System.out.println("s3.equals(s4) : "+s3.equals(s4));
        System.out.println("s3 == s4 : "+(s3 == s4));
    }

    //exercise 10
    public static void randomString(){
        System.out.println("random long to base36 string");
        long num =  new Random().nextLong();
        if(num < 0){
            num *= -1;
        }
        System.out.println(num);

        String str = Long.toString(num,36);
        System.out.println(str);
    }

    //exercise 11
    public static void printNotASCII(){
        //€♣⊕dasdas⇔ℜ312!!9540)@*#!@&Å¶¶¥
        System.out.println("print not ASCII characters");
        System.out.print("print text : ");
        String text = scanner.nextLine();

        char[] chars = text.toCharArray();

        for(char o : chars){
            if(o > 127) {
                System.out.println(o + " " + (int) o);
            }
        }
    }

    //exercise 12
}
