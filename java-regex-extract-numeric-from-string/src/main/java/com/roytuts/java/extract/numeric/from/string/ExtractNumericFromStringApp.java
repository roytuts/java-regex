package com.roytuts.java.extract.numeric.from.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumericFromStringApp {

    public static void main(String[] args) {
        String number1 = getFirstContinousNumericFromString("AB: [C D] 4110007.325");
        System.out.println("number1 : " + number1);
        
        String number2 = getFirstContinousNumericFromString("209ca56b-deea-4874-81d6-e9cdaa74a7c7");
        System.out.println("number2 : " + number2);
        
        String number3 = getFirstContinousNumericFromString("AB: [C D] 4110007.325 1253");
        System.out.println("number3 : " + number3);
        
        String number4 = getFirstContinousNumericFromString("ca56b-deea-4874-81d6-e9cdaa74a7c7");
        System.out.println("number4 : " + number4);

        number4 = getAllNumericFromString("ca56b-deea-4874-81d6-e9cdaa74a7c7");
        System.out.println("number4 all : " + number4);
        
        String number5 = getAllNumericFromString("c%56b-de$a-4874-81d6-e9cd$#74a7c7");
        System.out.println("number5 all : " + number5);
    }

    public static String getFirstContinousNumericFromString(String string) {
        Pattern pattern = Pattern.compile("(\\d+\\.+\\d+)|(\\d+)");
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        return matcher.group();
    }

    public static String getAllNumericFromString(String string) {
        Pattern pattern = Pattern.compile(
                "(\\d+\\.+\\d+)|\\w+(\\d+)\\.(\\d+)|(\\d+)\\.\\w+(\\d+)|\\w+(\\d+)\\.\\w+(\\d+)|\\w+(\\d+)\\w+(\\d+)|(\\d+)\\w+|\\w+(\\d+)");
        Matcher matcher = pattern.matcher(string);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.find()) {
                sb.append(matcher.group());
                // System.out.println(matcher.group());
            }
        }

        // System.out.println(sb.toString());

        String numeric = sb.toString().replaceAll("[a-zA-Z\\s]", "");

        return numeric;
    }

}
