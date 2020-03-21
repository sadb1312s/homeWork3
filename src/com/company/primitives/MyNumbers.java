package com.company.primitives;

import com.company.utils.UserInputReader;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class MyNumbers {
    //exercises with primitives
    private UserInputReader reader;

    public MyNumbers(UserInputReader reader){
        this.reader = reader;
    }

    public void doExercise(){
        //ex 1
        int x1 = (int) reader.readNumbers(1).get(0);
        intPrint(x1);

         //ex 2
        x1 = (int) reader.readNumbers(2).get(0);
        degree(x1);

        //ex 3
        List list = reader.readNumbers(3);
        System.out.println(list.size());
        x1 = (int) list.get(0);
        int x2 = (int) list.get(1);
        int x3 = (int) list.get(2);
        intMax(x1,x2,x3);

        //exs 4,5,6
        doubleMimMax();
        largeDoubleToInt();
        factorial(1000);

        //ex 7
        list = reader.readNumbers(7);
        x1 = (int) list.get(0);
        x2 = (int) list.get(1);
        intWithOutSign(x1,x2);

        //ex 13
        lottery();

        //ex 14
        list = reader.readNumbers(14);
        magicalSquare(formArray(list));

        //ex 15
        x1 = (int) reader.readNumbers(15).get(0);
        pascalTriangle(x1);
    }

    //exercise 1
    public void intPrint(int x){
        System.out.println("read int and print it in other number system");
        System.out.println("User input : "+x);

        System.out.println(x+" in binary : "+Integer.toBinaryString(x));
        System.out.println(x+" in octal : "+Integer.toOctalString(x));
        System.out.println(x+" in hexadecimal : "+Integer.toHexString(x));
        System.out.println(x+" reverse hex : "+Double.toHexString(Integer.reverse(x)));

        System.out.println();
    }

    //exercise 2
    public void degree(int inputDegree){
        System.out.println("angle to value between 0 adn 359 degree");
        System.out.println("User input : "+inputDegree);

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
        System.out.println();
    }

    //exercise 3
    public void intMax(int x1, int x2, int x3){
        System.out.println("read three int and print max");
        System.out.println("User input : "+x1+" ,"+x2+" ,"+x3);

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
        System.out.println();
    }

    //exercise 4
    public void doubleMimMax(){
        //what? // Math.nextUp()
        System.out.println("smallest and largest double");

        System.out.println("smallest double value = "+Double.MIN_VALUE);
        System.out.println("largest double value = "+Double.MAX_VALUE);
        System.out.println();
    }

    //exercise 5
    public void largeDoubleToInt(){
        System.out.println("cast large double to int");
        //int x = Integer.MAX_VALUE;

        //max int = 2147483647
        //double maxDouble = 2147483649l;
        System.out.println(Integer.MAX_VALUE);
        double maxDouble = 2147483647 + 1;

        int x = (int)maxDouble;
        System.out.println(x);
        System.out.println();
    }

    //exercise 6
    public void factorial(int number){
        System.out.println("factorial");
        BigInteger bigInteger = BigInteger.valueOf(1);

        for(int i = 2; i <= number; i++){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println("factorial = "+bigInteger);
        System.out.println();
    }

    //exercise 7
    public void intWithOutSign(int x1, int x2){
        System.out.println("int unsigned");
        System.out.println("User input : " + Integer.toUnsignedString(x1) + " ," + Integer.toUnsignedString(x2));


        BigInteger b1 = new BigInteger(Integer.toUnsignedString(x1));
        BigInteger b2 = new BigInteger(Integer.toUnsignedString(x2));

        BigInteger b3 = b1.add(b2);
        System.out.println("sum = "+b3);

        b3 = b1.subtract(b2);
        System.out.println("difference = "+b3);

        b3 = b1.multiply(b2);
        System.out.println("produce = "+b3);

        b3 = b1.divide(b2);
        System.out.println("quotient = "+b3);
        System.out.println();
    }

    //exercise 13
    public void lottery(){
        System.out.println("lottery");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 49; i++)
            numbers.add(i);

        System.out.println(numbers);

        int[] wishNumber = new int[6];

        Random random = new Random();


        for(int j = 0; j < 6; j++) {
            int size = numbers.size();

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(size);
                wishNumber[i] = numbers.get(index);
                size--;
                numbers.remove((Integer) index);
            }

            Arrays.sort(wishNumber);
            System.out.println(Arrays.toString(wishNumber));

        }
        System.out.println();
    }

    //exercise 14
    public void magicalSquare(int[][] array){
        System.out.println("magicalSquare");
        System.out.println("user input : "+Arrays.deepToString(array));

        if(
                linesCheck(array) &&
                        columnCheck(array) &&
                        diagonalsCheck(array)
        ){
            System.out.println("square is magical");
        }else {
            System.out.println("square is not magical");
        }


        System.out.println();
    }

    //ex 14 helps methods
    private int[][] formArray(List<Integer> list){
        double arraySize = Math.sqrt(list.size());
        if(arraySize % 2d > 0.000001d){
            try {
                throw new Exception("Array size is not even");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        int[][] array = new int[(int)arraySize][(int)arraySize];


        int i = 0;
        int j = 0;
        for(Integer o : list){
            array[i][j] = o;
            i++;

            if(i == 4){
                i = 0;
                j++;
            }
        }

        return array;
    }

    //can in one method
    private boolean linesCheck(int[][] array){
        int prevSum = 0;
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                sum += array[i][j];
            }

            if(i != 0){
                if(sum != prevSum){
                    return false;
                }
            }else {
                prevSum = sum;
            }
            sum = 0;
        }

        return true;
    }

    private boolean columnCheck(int[][] array){
        int prevSum = 0;
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                sum += array[j][i];
            }

            if(i != 0){
                if(sum != prevSum){
                    return false;
                }
            }else {
                prevSum = sum;
            }
            sum = 0;
        }

        return true;
    }

    private boolean diagonalsCheck(int[][] array){

        int sum1 = 0;
        for (int i = 0; i < array.length; i++){
            sum1 += array[i][i];
        }

        int sum2 = 0;
        for (int i = array.length - 1; i >= 0; i--){
            sum2 += array[i][array.length - 1 - i];
        }


        return sum1 == sum2;
    }

    //exercise 15
    public void pascalTriangle(int size){
        System.out.println("pascalTriangle");
        List<List<Integer>> lists = new ArrayList();

        for(int i = 0; i < size; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);

            if(i == 0){
                lists.add(list);
                continue;
            }

            if(i == 1){
                list.add(1);
                lists.add(list);
                continue;
            }

            for(int j = 0; j < i - 1; j++){
                int x1 = lists.get(i-1).get(j);
                int x2 = lists.get(i-1).get(j+1);
                list.add(x1 + x2);
            }
            list.add(1);
            lists.add(list);
        }

        for(List<Integer> o : lists){
            System.out.println(o);
        }
        System.out.println();
    }
}
