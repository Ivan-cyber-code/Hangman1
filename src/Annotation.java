public class Annotation {

    public static void show_rules_game() {
        System.out.println("Добро пожаловать в игру виселица");
        System.out.println("Правила игры:");
        System.out.println("Нужно отгадать слово.");
        System.out.println("У тебя есть только 6 попыток что бы ошибиться.");
        System.out.println("ПРИМЕЧАНИЕ: буква 'ё' приравнивается к букве 'е'");
    }

    public static void the_end_game(){
        System.out.println("Сожалею, но вы проиграли.");
        System.out.print("Было загадано слово: ");
    }

    public static void the_win_game(){
        System.out.println("Поздравляю!");
        System.out.println("Ты выйграл!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public static void show_tablo(StringBuilder tablo){
        System.out.println("Поздравляю вы отгадали букву!");
        System.out.println("Внимание на табло!");
        System.out.println(tablo);
    }
}
