package ru.javarush.gbogomolov.module1;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextScanner {
    public static String ReadText(String fileName) throws IOException {
        File file = new File("cipher.txt");

        Scanner scanner = new Scanner(new FileInputStream(fileName));
        String line = "";

        while(scanner.hasNextLine()){
                line = scanner.nextLine();
        }

        scanner.close();
        return line;
    }
}
