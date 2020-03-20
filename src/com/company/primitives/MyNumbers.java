package com.company.primitives;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.SortedSet;

public class MyNumbers {
    //exercises with primitives
    private final static Scanner scanner = new Scanner(System.in);

    //exercise 1 -
    public static void intPrint(){
        System.out.println("read int and print it in other number system");

        System.out.print("input int value : ");
        int x = scanner.nextInt();


        System.out.print(x+" in binary : ");
        System.out.println(Integer.toBinaryString(x));

        System.out.print(x+" in octal : ");
        System.out.printf("%o",x);
        System.out.println();

        System.out.print(x+" in hexadecimal : ");
        System.out.printf("%x",x);
        System.out.println();
    }

    //exercise 2
    public static void degree(){
        System.out.println("angle to value between 0 adn 359 degree");

        System.out.print("input degree : ");

        int inputDegree = scanner.nextInt();

        if(inputDegree < 0){
            inputDegree *= -1;
        }

        int degree = inputDegree;
        //360 degree == 0 degree
        while (degree > 359) {
            degree = degree % 360;
        }

        System.out.println("with %");
        System.out.println("degree = " + degree);


        System.out.println("with floorMod");
        inputDegree = Math.floorMod(inputDegree,360);
        System.out.println("degree = " + inputDegree);
    }

    //exercise 3
    public static void intMax(){
        System.out.println("read three int and print max");
        int x1,x2,x3;
        System.out.print("input first int : ");
        x1 = scanner.nextInt();
        System.out.print("input second int : ");
        x2 = scanner.nextInt();
        System.out.print("input third int : ");
        x3 = scanner.nextInt();

        System.out.println("with if..else");
        if(x1 > x2){
            if(x1 > x3){
                System.out.println("largest int is "+x1);
            } else {
                System.out.println("largest int is "+x3);
            }
        } else {
            if(x2 > x3){
                System.out.println("largest int is "+x2);
            }else {
                System.out.println("largest int is "+x3);
            }
        }

        System.out.println("with Math.max()");
        System.out.println("largest int is "+Math.max(Math.max(x1,x2),x3));
    }

    //exercise 4
    public static void doubleMimMax(){
        //what? // Math.nextUp()
        System.out.println("smallest and largest double");

        System.out.println("smallest double value = "+Double.MIN_VALUE);
        System.out.println("largest double value = "+Double.MAX_VALUE);
    }

    //exercise 5
    public static void largeDoubleToInt(){
        System.out.println("cast large double to int");
        //int x = Integer.MAX_VALUE;

        //max int = 2147483647
        //double maxDouble = 2147483649l;
        System.out.println(Integer.MAX_VALUE);
        double maxDouble = 2147483647 + 1;



        int x = (int)maxDouble;
        System.out.println(x);
    }

    //exercise 6
    public static void factorial(int number){
        System.out.println("factorial");
        BigInteger bigInteger = BigInteger.valueOf(1);

        for(int i = 2; i <= number; i++){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println("factorial = "+bigInteger);
    }

    //exercise 7
    public static void intWithOutSign(){
        System.out.println("int unsigned");

        int min = 0;
        int max = 0b11111111_11111111_11111111_11111111;

        System.out.println("range : " + min +" and "+Integer.toUnsignedString(max));
        System.out.println(Integer.MAX_VALUE);
        int x1, x2;

        System.out.print("input first int : ");
        x1 = Integer.parseUnsignedInt(scanner.next());

        System.out.print("input second int : ");
        x2 = Integer.parseUnsignedInt(scanner.next());

        int sum = x1 + x2;
        System.out.println(Integer.toUnsignedString(sum));

        int difference = x1 - x2;
        System.out.println(Integer.toUnsignedString(difference));

        int produce = x1 * x2;
        System.out.println(Integer.toUnsignedString(produce));

        int quotient = x1 / x2;
        System.out.println(Integer.toUnsignedString(quotient));
    }
}
