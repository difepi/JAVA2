package lesson5;

import java.util.Arrays;

public class Main {
    static final int size = 10_000_000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr = new float[size];
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];

        arr1 = Arrays.copyOf(noMulti(arr), size);
        arr2 = Arrays.copyOf(multi(arr), size);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Массивы идентичны");
        } else {
            System.out.println("Массивы не идентичны");
        }

    }


    private static float[] noMulti(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println("Выполнение в одном потоке: " + Double.toString(System.currentTimeMillis() - a));

        return arr;

    }


    private static float[] multi(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        float[] onearr = new float[h];
        float[] twoarr = new float[h];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, onearr, 0, h);
        System.arraycopy(arr, h, twoarr, 0, h);

        Thread myThreadyOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    onearr[i] = (float) (onearr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
            }
        });


        Thread myThreadyTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = h; i < size; i++) {
                    twoarr[i - h] = (float) (twoarr[i - h] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
            }
        });
        try {
            myThreadyOne.start();
            myThreadyTwo.start();
            myThreadyTwo.join();
            myThreadyOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(onearr, 0, arr, 0, h);
        System.arraycopy(twoarr, 0, arr, h, h);

        System.out.println("Выполнение в двух потоках: " + Double.toString(System.currentTimeMillis() - a));

        return arr;

    }
}
