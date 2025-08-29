import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MagiсWordAndTablo {

    public static String guess_a_word() {

        Random randomaize = new Random();

        ArrayList<String> dictionary = new ArrayList<>();

        try {
            Scanner file = new Scanner(new File("src\\Словарь.txt"));
            while (file.hasNextLine()) {
                String str = file.nextLine().trim();
                if (!str.isEmpty()) {
                    dictionary.add(str);
                }
//                file.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Список слов не найден");
            System.out.println("Нет ассортимента слов для загадывания");
            System.out.println("Проверьте правильность названия и расположения файла со словами");
            return null;
        }

        if (dictionary.isEmpty()) {
            System.out.println("Список найден, но он пуст");
            System.out.println("Нет ассортимента слов для загадывания");
            System.out.println("Добавьте в список слова и вернитесь к игре снова");
            return null;
        }

        return dictionary.get(randomaize.nextInt(dictionary.size()));
    }

    public static StringBuilder make_new_tablo(String letter, String magic_word, StringBuilder tablo) {

        for (int i = 0; i < magic_word.length(); i++) {
            if (String.valueOf(magic_word.charAt(i)).equalsIgnoreCase(letter)) {
                tablo.setCharAt(i,magic_word.charAt(i));// попоробовать использовать стринг под табло
            }
        }

        return tablo;
    }

    public static StringBuilder make_start_tablo(String magic_word){
        StringBuilder tablo = new StringBuilder();
        for (int i = 0; i < magic_word.length(); i++) {
            tablo.append("_");
        }
        return tablo;
    }


}
