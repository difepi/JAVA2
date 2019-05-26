package lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException(String s) {
        super(s + "\nОбратитесь к программисту, чтобу снять ограничения.\ndf@mymedech.ru");
    }
}
