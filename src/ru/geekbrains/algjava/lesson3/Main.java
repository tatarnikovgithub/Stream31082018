package ru.geekbrains.algjava.lesson3;

public class Main {
    public static void main(String[] args) {
        String str = "q{q[q(q<q>q}q{q}q<q>q{q{q}q}q{q(q(q)q)q}";

        System.out.println(Brackets.check(str));
    }
}
