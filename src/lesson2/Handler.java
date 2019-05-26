package lesson2;

public class Handler {
    private String[][] array;
    private int i;
    private int j;

    public Handler(String[][] array) {
        this.array = array;
    }
    
    public int sumArrayString() {
        int summarray = 0;

        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[0].length; j++) {
                    summarray += (int) Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке [" + i + "] " + "[" + j + "]" +
                    " лежит символ или текст вместо числа, либо же массив не заполнен до конца!");
        }
        return summarray;
    }
}
