package ru.geekbrains.algjava.lesson5.home;

public class TheBag {
    static int[] weigth = new int[] {10, 3, 16, 15, 4};
    static int[] values = new int[] {28, 42, 7, 1, 89};
    static int w = 25;

    private static int bag(int i, int w) {
        if (i < 0)
            return 0;
        if (weigth[i] > w) {
            return bag(i - 1, w);
        } else {
            return Math.max(bag(i - 1, w), bag(i - 1, w - weigth[i]) + values[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(bag(values.length - 1, w));
    }

}
