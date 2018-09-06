package ru.geekbrains.algjava.lesson1;

public class MyClass extends Object{
    private int a = 15;

    public MyClass(){
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyClass)) return false;
        MyClass outer = (MyClass)obj;
        return outer.a == this.a;
    }

    void method1(){
        System.out.println(a);
    }

}
