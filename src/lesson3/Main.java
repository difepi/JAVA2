package lesson3;

public class Main {
    public static final String TEXTCOLOR = "\u001B[33m";
    public static final String TEXTCOLOR2 = "\u001B[36m";
    public static final String TEXTCOLOR_RESET = "\u001B[0m";

    public static void main(String[] args) {

        System.out.println(TEXTCOLOR + "Задание 1. Урок 3. Курс Java 2." + TEXTCOLOR_RESET);
        //Задание 1.
        String[] word = {"ракета", "ракета", "радость", "счастье", "улыбка", "красота", "чудо", "ракета", "кайф", "отдых",
                "праздник", "cокровища", "позитив", "отпуск", "тригонометрия", "блаженство", "окрыленность",
                "тригонометрия", "сникерс", "сникерс", "сникерс", "сеновал", "ракета"};
        SetOfWords setOfWords = new SetOfWords(word);
        setOfWords.outUniqueWords();
        System.out.println(TEXTCOLOR2);
        setOfWords.repOnWords();
        //Задание 2.

        System.out.println(TEXTCOLOR + "\n\nЗадание 1. Урок 3. Курс Java 2." + TEXTCOLOR_RESET);
        PhoneBook book = new PhoneBook();
        book.add("Шершуков", "89093657745");
        book.add("Самохвалова", "8905345334");
        book.add("Павлова", "774456555345 ");
        book.add("Оверченков", "89023433355");
        book.add("Фельдман", "+79084563219");
        book.add("Афанасьев", "+79803699049");
        book.add("Заварова", "+79536144107");
        book.add("Фельдман", "89093554672");
        book.add("Шенкевич", "8(4862)78-03-70");
        book.add("Афанасьев", "тел. 89092348895");

        System.out.println("найден следующий телефонный номер (Заварова): " + book.get("Заварова"));

        book.add("Фельдман", "89997773467");
        book.add("Заварова", "+7 (953) 614-41-07");
        System.out.println("Найдены следующие телефонные номера (Фельдман) " + book.get("Фельдман"));
        System.out.println("Найдены следующие телефонные номера (Захарова) " + book.get("Заварова"));
        System.out.println("Найдены следующие телефонные номера (Афанасьев) " + book.get("Афанасьев"));
    }
}
