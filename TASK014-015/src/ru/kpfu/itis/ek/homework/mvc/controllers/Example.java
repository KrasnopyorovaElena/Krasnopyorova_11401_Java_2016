package ru.kpfu.itis.ek.homework.mvc.controllers;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) throws IOException{
        String str = "ghb     \r\n hjbj vybhuj \r\nvbhjn cfgvhjn. gbh";
        Matcher m = Pattern.compile("(\\b([A-Za-z]+)\\b)+[\b]*\\r\\n").matcher(str.replace(" ",""));
        int counter = 0;
        while (m.find()) {
            counter++;
        }


        System.out.println(counter);
    }
}
