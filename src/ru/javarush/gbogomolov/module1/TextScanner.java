package ru.javarush.gbogomolov.module1;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextScanner {
    public static String ReadText(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        String line = "";
        while(scanner.hasNextLine()){
                line = scanner.nextLine();
        }

        scanner.close();
        return line;
    }
}
