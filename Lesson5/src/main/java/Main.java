import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] arr2 = new float[SIZE];
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1f;
            arr2[i] = 1f;
        }

        fillArray(arr);
        fillArrayThread(arr2);

    }

    public static void fillArray(float[] array){
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long stop = System.currentTimeMillis();
        System.out.println("Время выполнения прямого прохождения по списку: " + (stop-start));
    }

    public static void fillArrayThread(float[] array) throws InterruptedException {
        long start = System.currentTimeMillis();
        float[] arrayHalfOne = new float[array.length/2];
        float[] arrayHalfTwo = new float[array.length/2];
        System.arraycopy(array,0, arrayHalfOne,0, array.length/2);
        System.arraycopy(array,array.length/2, arrayHalfTwo,0, array.length/2);
        Thread thread1 = new Thread(() -> {
           resultNumbers(arrayHalfOne);
        });
        Thread thread2 = new Thread(() -> {
            resultNumbers(arrayHalfTwo);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arrayHalfOne, 0, array, 0, array.length/2);
        System.arraycopy(arrayHalfTwo, 0, array, array.length/2,array.length/2);
        long stop = System.currentTimeMillis();
        System.out.println("Время выполнения при разбитии на два потока: " + (stop-start));
    }

    public static void resultNumbers(float[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
