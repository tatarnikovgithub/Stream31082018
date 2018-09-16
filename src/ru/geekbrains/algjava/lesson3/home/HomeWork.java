package ru.geekbrains.algjava.lesson3.home;

public class HomeWork {
    private static String fancyReverse(String s){
        StackGen stack = new StackGen(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fancyReverse("HelloWorld"));
    }
}
