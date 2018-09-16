package ru.geekbrains.algjava.lesson5.online;

public class MainClass {

    public static int countDown(int n) {
        System.out.println(n);
        if (n == 1){
            return 1;
        }
        return countDown(n - 1);
    }




}

