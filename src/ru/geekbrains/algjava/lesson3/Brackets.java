package ru.geekbrains.algjava.lesson3;

public class Brackets {
    private static void error(char ch, int i) {
        System.out.println("Error: " + ch + " at: " + i);
    }

    public static boolean check(String input) {
        int size = input.length();
        Stack st = new Stack(size);
        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);
            if (ch == '{' || ch == '[' ||
                    ch == '(' || ch == '<') {
                st.push(ch);
            } else if (ch == '}' || ch == ']' ||
                    ch == ')' || ch == '>') {
                if (st.isEmpty()) {
                    error(ch, i);
                    return false;
                }
                char c = (char) st.pop();
                if (!((c == '{' && ch == '}') ||
                        (c == '[' && ch == ']') ||
                        (c == '(' && ch == ')') ||
                        (c == '<' && ch == '>'))) {
                    error(ch, i);
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            error((char) st.pop(), size - 1);
        }
    return true;
    }
}
