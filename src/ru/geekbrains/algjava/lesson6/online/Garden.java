package ru.geekbrains.algjava.lesson6.online;

public class Garden {
    public static void main(String[] args) {
        Tree t = new Tree();


        t.insert(new Person("ivan3", 30));
        t.insert(new Person("ivan1", 10));
        t.insert(new Person("ivan2", 20));
        t.insert(new Person("ivan5", 50));
        t.insert(new Person("ivan4", 40));
        t.insert(new Person("ivan6", 60));

        t.displayTreeToConsole();
    }
}
