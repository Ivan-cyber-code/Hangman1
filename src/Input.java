import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> listOfEnteredLetters = new ArrayList<>();

    public static boolean startOrEndGame() {
        System.out.println("""
                Приветсвую тебя!
                Нажмите 1 если хотите начать и 2 если хотите выйти.
                """);
        String number = scanner.next();
        if (number.equals("1") || number.equals("2")) {

            switch (number) {
                case "1":
                    return true;
                case "2":
                    return false;
            }
        } else {
            boolean flag = true;
            while (true) {
                System.out.println("""
                        Некорретный ввод.
                        Нужно ввести число от 1 до 2.
                        Нажмите 1 если хотите начать и 2 если хотите выйти.
                        """);
                number = scanner.next();
                switch (number) {
                    case "1":
                        return true;
                    case "2":
                        return false;
                }
            }
        }
        return true;
    }

    public static String acceptCharacterFromKeyboard() {
        System.out.println("Введите символ:  ");
        return scanner.next();
    }

    public static boolean checkForContainsRassianAlphabet(String s) {
        return "А, Б, В, Г, Д, Е, Ё, Ж, З, И, Й, К, Л, М, Н, О, П, Р, С, Т, У, Ф, Х, Ц, Ч, Ш, Щ, Ъ, Ы, Ь, Э, Ю, Я".contains(s.toUpperCase());
    }

    public static boolean checkLenghtLetter(String s) {
        return s.length() == 1;
    }


public static boolean checkLetterRepeatability(String s) {
        return listOfEnteredLetters.contains(s.toLowerCase());
    }
}

