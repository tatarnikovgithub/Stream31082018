package ru.geekbrains.algjava.lesson2;

import java.util.Arrays;

public class Online {
    public static void main(String[] args) {
        int[] arr; //int arr[]
        int arr2[] = {1,2,3,4,5,6};
        arr = new int[5];
        arr[0] = 6;

//        Array a = new Array(5);
//        for (int i = 0; i < 6; i++) {
//            a.insert(i);
//        }

        System.out.println(Arrays.toString(arr2));
//        arr2 = Arrays.copyOf(arr2, 5);
        System.arraycopy(arr2, 3, arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));

        //Arrays
        System.out.println(Arrays.toString(arr));

    }
}
