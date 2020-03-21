package com.company.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputReader {
    private Scanner scanner;

    public UserInputReader(String filePath){
        File inputFile = new File(filePath);
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Object> readNumbers(int exerciseNumber){
        String readedStr = read(exerciseNumber);

        String[] numbers = readedStr.split(",");

        List<Object> list = new ArrayList<>();
        for(String o : numbers) {
            list.add(Integer.parseUnsignedInt(o));
        }

        return list;
    }

    public String readString(int exerciseNumber){
        return read(exerciseNumber);
    }

    private String read(int exerciseNumber){

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String prefix = str.substring(0, str.indexOf(")")+1);

            //if str is not comment
            String exerciseNumberS = exerciseNumber + ")";
            if (!prefix.equals("//")) {

                if (prefix.equals(exerciseNumberS)) {
                    return str.substring(str.indexOf(")")+1);
                }
            }
        }

        return null;
    }
}
