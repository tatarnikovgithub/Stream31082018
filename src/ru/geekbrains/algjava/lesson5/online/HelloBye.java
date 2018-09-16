package ru.geekbrains.algjava.lesson5.online;

public class HelloBye {
    public static void main(String[] args) {
//        a();
        hello("Михаил");
    }

//    public static void a(){
//        b();
//    }
//
//    public static void b(){
//        c();
//    }
//
//    public static void c(){
//        System.out.println("method c");;
//    }

    public static void hello(String name){
        System.out.println("Hello, " + name + "!");
        bye(name);
    }

    public static void bye(String name){
        System.out.println("Good bye, " + name + "!");
    }



}
