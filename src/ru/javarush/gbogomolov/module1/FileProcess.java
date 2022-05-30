package ru.javarush.gbogomolov.module1;


import java.io.*;
import java.util.Scanner;

public class FileProcess {

    public static String ReadFile() throws FileNotFoundException {

        System.out.println("Укажите путь к файлу: ");

        Scanner scanner = new Scanner(System.in);
        System.out.flush();
        String filename = scanner.nextLine();

        Scanner file = new Scanner(filename);
        scanner.close();

        Scanner textFile = new Scanner(new FileInputStream(filename));
        String line = "";

        while(textFile.hasNextLine()){
            line = textFile.nextLine();
        }

        textFile.close();
        return line;
    }



    public static void WriteTextToFile(String encodedText , String decodedText) throws IOException{
        try(PrintWriter writer = new PrintWriter("final cipher.txt"))
        {
            writer.println(encodedText);
            writer.println(decodedText);
        }
    }


}
