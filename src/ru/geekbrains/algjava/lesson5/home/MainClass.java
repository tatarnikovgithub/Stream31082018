package ru.geekbrains.algjava.lesson5.home;

public class MainClass {
    private static int power(int base, int sign){
        return (sign == 0) ? 1 : power(base, sign - 1) * base;
    }
    //n^k = n^k-1 * n
    static int operations = 0;
    static void put(int from, int to){
        System.out.printf("%d -> %d | ", from, to);
        if (++operations % 10 == 0) System.out.printf("\n");
    }

    // sack relations
    // m[0,w] = 0;
    // m[i,w] = m[i-1, w], если w[i] > w;
    // m[i,w] = max(m[i-1,w],m[i-1,w-w[i]] + v[i]), если w[i] <=w;

    private static void tower(int height, int from, int to){
        int temp = from ^ to; // 1^2=3; 1^3=2; 2^3=1
        if (height == 1){
            put(from, to);
        } else{
            tower(height - 1, from, temp);
            put(from, to);
            tower(height - 1, temp, to);
        }
    }


    public static void main(String[] args) {
        System.out.println(power(2,10));
        tower(8,1,3);
        System.out.println("\n" + operations);
    }
}


