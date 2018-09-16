package ru.geekbrains.algjava.lesson5.online;

public class Factorial {
    //4! = 1*2*3*4=24

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int n){
        if (n == 1)
            return 1;
        return n*factorial(n - 1);
    }

    // РЕАЛИЗМЕ
    // ИЗРАИЛЕМ

    // cat cta atc act tca tac
    // 1 55 00



}
