package ru.geekbrains.algjava.lesson2.home;

import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[1_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        System.out.println(Arrays.toString(arr));

    }
}
