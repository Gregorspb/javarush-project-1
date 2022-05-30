package ru.javarush.gbogomolov.module1;


import java.io.*;
import java.util.Scanner;

public class FileProcess {
    
    public static String ReadText(String fileName) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream(fileName));
        String line = "";

        while(scanner.hasNextLine()){
                line = scanner.nextLine();
        }

        scanner.close();
        return line;
    }
    public static void WriteTextToFile(String encodedText , String decodedText) throws IOException{
        try(PrintWriter writer = new PrintWriter("C:\\Users\\bogom\\Desktop\\javarush-project-1\\src\\ru\\javarush\\gbogomolov\\module1\\final cipher.txt"))
        {
            writer.println(encodedText);
            writer.println(decodedText);
        }
    }
}
