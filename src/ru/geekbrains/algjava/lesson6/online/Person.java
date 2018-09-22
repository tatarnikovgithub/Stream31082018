package ru.geekbrains.algjava.lesson6.online;

public class Person {
    private static int id = 0;
    String name;
    int age;
    int uid;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.uid = ++id;
    }
}
