package com.company.utils;

import java.io.*;
import java.util.*;

public class UserInputReader  {
    private final String inputFileHat = "//each exercise line begin with exercise number + \")\"\n" +
            "//exercises with numbers, use only \",\" for separation of numbers, don't use space or other characters";
    private Scanner scanner;
    private File inputFile;


    public UserInputReader(String filePath){
        inputFile = new File(filePath);
        if(!inputFile.exists()){
            try {
                inputFile.createNewFile();
                FileWriter fileWriter = new FileWriter(inputFile);
                fileWriter.write(inputFileHat);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void reset(){
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> readNumbers(int exerciseNumber){
        String readedStr = read(exerciseNumber);

        if(readedStr != null) {
            String[] numbers = readedStr.split(",");

            List<Integer> list = new ArrayList<>();
            for (String o : numbers) {
                try {
                    list.add(Integer.parseUnsignedInt(o));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }

            return list;
        }else {
            return null;
        }
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
                    reset();
                    return str.substring(str.indexOf(")")+1);
                }
            }
        }

        reset();
        return null;
    }
}
