public class Annotation {

    public static void showRulesGame() {
        System.out.println("""
                Добро пожаловать в игру виселица:
                Правила игры:
                Нужно отгадать слово.
                У тебя есть только 6 попыток что бы ошибиться.
                ПРИМЕЧАНИЕ: буква "ё" приравнивается к букве "е"
                """);
    }

    public static void theEndGame() {
        System.out.print("""
                Сожалею, но вы проиграли.
                Было загадано слово:""");
    }

    public static void theWinGame() {
        System.out.println("""
                Поздравляю!
                Ты выйграл!  
                
               
                """);
    }

    public static void showTablo(StringBuilder tablo) {
        System.out.println("""
                Поздравляю вы отгадали букву!
                Внимание на табло!
                """);
        System.out.println(tablo);
    }
}
