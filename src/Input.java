import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Input {

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> list_input_letter = new ArrayList<>();

    public static boolean startGame() {
        System.out.println("Приветсвую тебя!");
        System.out.println("Нажмите 1 если хотите начать и 2 если хотите выйти.");
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
                System.out.println("Некорретный ввод.");
                System.out.println("Нужно ввести число от 1 до 2.");
                System.out.println("Нажмите 1 если хотите начать и 2 если хотите выйти.");
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

    public static String input() {
        System.out.println("Введите символ:  ");
        return scanner.next();
    }

    public static boolean input_chek_alfavit(String s){
        return "А, Б, В, Г, Д, Е, Ё, Ж, З, И, Й, К, Л, М, Н, О, П, Р, С, Т, У, Ф, Х, Ц, Ч, Ш, Щ, Ъ, Ы, Ь, Э, Ю, Я".contains(s.toUpperCase());
    }

    public static boolean input_chek_letter_lenght(String s){
        if(s.length()==1){
            return true;
        } else {
            return false;
        }
    }

    public static boolean input_chek_letter_new(String s){
        if(!list_input_letter.contains(s.toLowerCase())){
            return true;
        } else {
            return false;
        }
    }


}
