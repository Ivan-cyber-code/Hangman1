import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Magic {

    static String guessAWord() {

        Random randomaize = new Random();

        ArrayList<String> dictionary = new ArrayList<>();

        try {
            Scanner file = new Scanner(new File("src\\Словарь.txt"));
            while (file.hasNextLine()) {
                String str = file.nextLine().trim();
                if (!str.isEmpty()) {
                    dictionary.add(str);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("""
                    Список слов не найден.
                    Нет ассортимента слов для загадывания.
                    Проверьте правильность названия и расположения файла со словами.
                    """);
            return null;
        }

        if (dictionary.isEmpty()) {
            System.out.println("""
                    Список найден, но он пуст.
                    Нет ассортимента слов для загадывания.
                    Добавьте в список слова и вернитесь к игре снова
                    """);
            return null;
        }

        return dictionary.get(randomaize.nextInt(dictionary.size()));
    }

    static StringBuilder showTheTabloBasedOnTheGuessedLetter(String letter, String magicWord, StringBuilder tablo) {

        for (int i = 0; i < magicWord.length(); i++) {
            if (String.valueOf(magicWord.charAt(i)).equalsIgnoreCase(letter)) {
                tablo.setCharAt(i, magicWord.charAt(i));// попоробовать использовать стринг под табло
            }
        }

        return tablo;
    }

    static StringBuilder makeABlankTablo(String magicWord) {
        StringBuilder tablo = new StringBuilder();
        return tablo.append("_".repeat(magicWord.length()));
    }


}
