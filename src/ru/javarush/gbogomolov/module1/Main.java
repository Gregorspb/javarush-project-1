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
            if(charIndex ==-1)
            {
                continue;
            }
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
            if(charIndex ==-1)
            {
                continue;
            }
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
        System.out.println("Добро пожаловать!");
        System.out.println("Выберите режим:");

        System.out.println("1.Зашифровать текст");
        System.out.println("2.Расшифровать текст");

        Scanner scanMode = new Scanner(System.in);
        int mode = scanMode.nextInt();

        System.out.println("Укажите ключ для сдвига: ");
        Scanner scanKey = new Scanner(System.in);
        int key = scanKey.nextInt();

        String text = FileProcess.ReadFile();

        String cipherText = encoding(text, key);
        String decodedText = decoding(text , key);

        if (mode == 1) {
            System.out.println("Ваш секрет зашифрован:" + cipherText);

        }else if(mode == 2){
            System.out.println("Расшифрована тайна:" + decodedText);
        }
        FileProcess.WriteTextToFile(cipherText, decodedText);
        }
    }
