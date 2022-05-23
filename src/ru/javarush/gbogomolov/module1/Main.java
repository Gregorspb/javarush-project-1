package ru.javarush.gbogomolov.module1;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'};

    public static String encoding(String text , int key)
    {
    StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String stringALPHABET = new String(ALPHABET);
            int charIndex = stringALPHABET.indexOf(text.charAt(i));
            int newIndex = (charIndex + key) % 44;
            char cipherChar = stringALPHABET.charAt(newIndex);
            cipher.append(cipherChar);
        }

    return cipher.toString();
}
    public static String decoding(String text, int key)
    {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String stringALPHABET = new String(ALPHABET);
            int charIndex = stringALPHABET.indexOf(text.charAt(i));
            int newIndex = (charIndex - key) % 44;
            if( newIndex < 0 )
            {
            newIndex = stringALPHABET.length() + newIndex;
            }
            char cipherChar = stringALPHABET.charAt(newIndex);
            cipher.append(cipherChar);
        }
        return cipher.toString();
    }




    public static void main(String[] args) throws IOException {
    String text = TextScanner.ReadText("C:\\Users\\bogom\\Desktop\\javarush-project-1\\src\\ru\\javarush\\gbogomolov\\module1\\cipher.txt");

        Scanner scanner = new Scanner(System.in);

        int key = scanner.nextInt();

        String cipherText = encoding(text, key);

        System.out.println("Ваш секрет зашифрован:" + cipherText);

        System.out.println("Расшифрована тайна:" + decoding(cipherText, key));
        }
    }
