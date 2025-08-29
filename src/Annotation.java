public class Annotation {

    public static void show_rules_game() {
        System.out.println("Добро пожаловать в игру виселица");
        System.out.println("Правила игры:");
        System.out.println("Нужно отгадать загаданное слово за 5 попыток.");
        System.out.println("За каждую неверную введеную букву вы будете терять одну попытку");
    }

    public static void the_end_game(){
        System.out.println("Сожалею, но у вас не получилось отгадать слово.");
        System.out.println("Вы проиграли.");
        System.out.println("");
        System.out.println("");
        System.out.println("");
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
