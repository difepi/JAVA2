package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        try {
            filling(array);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException("Превышен размер массива!");
        }
        Handler handler = new Handler(array);
        System.out.println("Сумма элементов масива = " + handler.sumArrayString() + ".");
    }

    public static void filling(String[][] array) throws ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность для массива. \n [4][4] - для работы программы без ошибок." +
                "\t  Более [4][4] - для генерации ошибки MyArraySizeExeption.\n");
        System.out.print("i = ");
        int maxi = (int) Integer.parseInt(scanner.nextLine());
        System.out.print("j = ");
        int maxj = (int) Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < maxi; i++) {
            for (int j = 0; j < maxj; j++) {
                System.out.print("Введите " + "[" + i + "]" + "[" + j + "] " + "элемент " +
                        "массива 4х4: ");
                array[i][j] = scanner.nextLine();
            }

        }
        System.out.println("Массив заполнен.");
        scanner.close();
    }



}
