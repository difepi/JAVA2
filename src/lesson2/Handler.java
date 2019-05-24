package lesson2;

public class Handler {
    private String[][] array = new String[][]{{"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"}};
    private int i;
    private int j;


    {
        try {
            System.out.println(sumArrayString(array));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException("Превышение границ массива!!!");
        } finally {
            System.out.println("sdsd");
        }

    }

    private int sumArrayString(String[][] arr) throws ArrayIndexOutOfBoundsException {
        int summarray = 0;

        try {
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 4; j++) {
                    summarray += (int) Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке [" + i + "] " + "[" + j + "]" +
                    " лежит символ или текст вместо числа!!!!");
        }
        return summarray;
    }
}
