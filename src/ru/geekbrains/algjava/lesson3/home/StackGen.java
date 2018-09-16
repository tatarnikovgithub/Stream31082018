package ru.geekbrains.algjava.lesson3.home;

// можно сделать стек универсальным с помощью обобщений Generics для тех, кто прошел Java 3.
// либо можно сделать заменив тип данных на char.
public class StackGen {
    private int maxSize;
    private char[] stack;
    private int head;

    public StackGen(int size) {
        this.maxSize = size;
        this.stack = new char[size];
        this.head = -1;
    }


    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        return head == maxSize - 1;
    }

    public void push(char value){
        if (isFull()) return; // throw new RuntimeException();
        stack[++head] = value;
    }

    public char pop(){
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[head--];
    }

    public char peek(){
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[head];
    }













}
