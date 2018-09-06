package ru.geekbrains.algjava.lesson1;

public class Home {
    private static int power(int base, int sign){
        int result = 1;
        for (int i = 0; i < sign; i++) {
            result *=base;
        }
        return result;
    }

    private static int arrMin(int[] arr){
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result)
                result = arr[i];
        }
        return result;
    }

    private static float arrMean(int[] arr){
        float result = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            result +=arr[i];
        }
        return result/size;
    }
}
