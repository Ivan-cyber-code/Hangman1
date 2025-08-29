

public class GameLoop {


    static String check_condition(boolean f1, boolean f2, boolean f3, String letter) {
        while (!f1 || !f2 || !f3) {
            System.out.println("Некорректный ввод:");
            if (!f1) {
                System.out.println("-Введено больше одного символа");
            }

            if (!f2) {
                System.out.println("-Символ не принадлежит к русскому алфавиту");
            }

            if (!f3) {
                System.out.println("-Вы уже вводили эту букву");
            }
            letter = Input.input();
            f1 = Input.input_chek_letter_lenght(letter); //введен только один символ
            f2 = Input.input_chek_alfavit(letter);  //проверить корретиность ввода на принадлежность к русскому алфавиту
            f3 = Input.input_chek_letter_new(letter);
        }
        return letter;
    }

    static boolean letter_contins_magicWord(String letter, String magicWord) {
        if (magicWord.toLowerCase().contains(letter.toLowerCase())) {
            return true;
        } else {
            return false;
        } // внести изменение с учетом регистра буквы
    }

    static void start_game() {

        THE_END_OR_START_GAME:
        while (Input.startGame()) {

            Annotation.show_rules_game();//объяснить правила

            String magicWord = MagiсWordAndTablo.guess_a_word();//загадать слово

            if (magicWord == null) {
                break;// конец игры, проверить корректность словаря
            }

            int count_error = 0;

            StringBuilder tablo = MagiсWordAndTablo.make_start_tablo(magicWord);// создать пустое табло

            GAME_LOOP:
            while (true) {

                //ввести букву с клавиатуры
                String letter = Input.input();

                boolean flag1 = Input.input_chek_letter_lenght(letter);     //введен только один символ

                boolean flag2 = Input.input_chek_alfavit(letter);  //проверить корретиность ввода на принадлежность к русскому алфавиту

                boolean flag3 = Input.input_chek_letter_new(letter);     //вводили мы уже эту букву?

                letter = check_condition(flag1, flag2, flag3, letter);

                Input.list_input_letter.add(letter.toLowerCase());  //внести корретный ввод в список

                boolean flag4 = letter_contins_magicWord(letter, magicWord); // 1. проверить символ содержится ли в магическо слове

                if (flag4 == false) {

                    // 2. Если нет то открываем счётчик ошибок, рисуем виселицу. Просим ввести повторно.
                    // 2.1 После получения колличества ошибок проверяем на допустимое значение и в случае выхода за границу начинаем новый итерейшен.

                    count_error++;

                    System.out.println("Сожалею, но у вас не получилось отгадать букву");

                    Graphics.show_gsllows(count_error);

                    if (count_error == 6) {
                        Annotation.the_end_game();
                        Input.list_input_letter.clear();
                        break GAME_LOOP;
                    }

                    System.out.println(String.format("Попробуйте еще раз, у вас осталось попыток: %d", 6 - count_error));

                } else {
                    // 3. Еесли да, открываем табло в формате ****А*А. Просим ввести повторно.
                    //// 3.1 После открытия буквы проверяем табло == загаданному слову: если да начинаем новй итерейшен цикла, если нет просим ввести повторно.

                    tablo = MagiсWordAndTablo.make_new_tablo(letter, magicWord, tablo);

                    Annotation.show_tablo(tablo);

                    if (tablo.toString().equals(magicWord)) {
                        Annotation.the_win_game();
                        Input.list_input_letter.clear();
                        break GAME_LOOP;
                    }

                }

            }

        }
        System.out.println("Конец игры, пока!");
    }

    public static void main(String[] args) {

        start_game();

//        System.out.println(String.format("Попробуйте еще раз, у вас осталось попыток: %d", 0+1));
//        System.out.println(MagiсWord.make_tablo("ffff"));
//        System.out.println(MagiсWord.show_tablo("a","aba",new StringBuilder("___")));
//        Graphics.show_gsllows(5);//test
//        System.out.println(letter_contins_magicWord("a", "amc")); // test
//        System.out.println(MagiсWord.guess_a_word()); // test
//        System.out.println("abc".contains("A".toLowerCase())); // test
    }
}
