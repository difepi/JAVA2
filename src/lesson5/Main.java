package lesson5;

public class Main {
    static final int size = 10_000_000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr = new float[size];

        noMulti(arr);
        try {
            multi(arr);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private static void noMulti(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println("Выполнение в одном потоке " + Double.toString(System.currentTimeMillis() - a));

    }


    private static void multi(float[] arr) throws InterruptedException {
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
                for (int i = 0; i < h; i++) {
                    twoarr[i] = (float) (twoarr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }

            }
        });

        myThreadyOne.start();
        myThreadyOne.join();
        myThreadyTwo.start();
        myThreadyTwo.join();


        System.arraycopy(onearr, 0, arr, 0, h);
        System.arraycopy(twoarr, 0, arr, h, h);

        System.out.println("Выполнение в двух потоках " + Double.toString(System.currentTimeMillis() - a));

    }
}
