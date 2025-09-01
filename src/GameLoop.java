

public class GameLoop {


    static String CheckTheletterCorrectness(boolean ThisOneLetter, boolean ThisLetterContainsRassianAlphabet, boolean ThisLetterRepid, String letter) {
        while (!ThisOneLetter || !ThisLetterContainsRassianAlphabet || ThisLetterRepid) {
            System.out.println("Некорректный ввод:");
            if (!ThisOneLetter) {
                System.out.println("-Введено больше одного символа");
            }

            if (!ThisLetterContainsRassianAlphabet && ThisOneLetter) {
                System.out.println("-Символ не принадлежит к русскому алфавиту");
            }

            if (ThisLetterRepid) {
                System.out.println("Напоминаю что вы уже вводили буквы: " + Input.listOfEnteredLetters);
                System.out.println("Попробуйте ввести другую букву");
            }
            letter = Input.acceptCharacterFromKeyboard();
            if (letter.equalsIgnoreCase("ё")) {
                letter = "е";
            }
            ThisOneLetter = Input.checkLenghtLetter(letter);
            ThisLetterContainsRassianAlphabet = Input.checkForContainsRassianAlphabet(letter);
            ThisLetterRepid = Input.checkLetterRepeatability(letter);
        }
        return letter;
    }

    static boolean letterContainsMagicWord(String letter, String magicWord) {
        return magicWord.toLowerCase().contains(letter.toLowerCase());
    }

    static void start_game() {

        THE_END_OR_START_GAME:
        while (Input.startOrEndGame()) {

            Annotation.showRulesGame();//объяснить правила

            String magicWord = Magiс.guessAWord();//загадать слово

            if (magicWord == null) {
                break;// конец игры, проверить корректность словаря
            }

            int countError = 0;

            StringBuilder tablo = Magiс.makeABlankTablo(magicWord);// создать пустое табло

            GAME_LOOP:
            while (true) {

                //ввести букву с клавиатуры
                String letter = Input.acceptCharacterFromKeyboard();

                if (letter.equalsIgnoreCase("ё")) {
                    letter = "е";
                }

                boolean ThisOneLetter = Input.checkLenghtLetter(letter);

                boolean ThisLetterContainsRassianAlphabet = Input.checkForContainsRassianAlphabet(letter);

                boolean ThisLetterRepid = Input.checkLetterRepeatability(letter);

                letter = CheckTheletterCorrectness(ThisOneLetter, ThisLetterContainsRassianAlphabet, ThisLetterRepid, letter);

                Input.listOfEnteredLetters.add(letter.toLowerCase());

                boolean ThisLetterContainseMagicWord = letterContainsMagicWord(letter, magicWord);

                if (!ThisLetterContainseMagicWord) {

                    countError++;

                    System.out.println("Сожалею, но у вас не получилось отгадать букву");

                    Graphics.showHangman(countError);

                    if (countError == 6) {
                        Annotation.theEndGame();
                        System.out.println(magicWord);
                        System.out.println("""
                                                                \s
                                                                \s
                                \s
                                """);
                        Input.listOfEnteredLetters.clear();
                        break GAME_LOOP;
                    }

                    System.out.printf("Попробуйте еще раз, у вас осталось попыток: %d%n", 6 - countError);

                } else {

                    tablo = Magiс.showTheTabloBasedOnTheGuessedLetter(letter, magicWord, tablo);

                    Annotation.showTablo(tablo);

                    if (tablo.toString().equals(magicWord)) {
                        Annotation.theWinGame();
                        Input.listOfEnteredLetters.clear();
                        break GAME_LOOP;
                    }

                }

            }

        }
        System.out.println("Конец игры, пока!");
    }

    public static void main(String[] args) {

        start_game();

    }
}
