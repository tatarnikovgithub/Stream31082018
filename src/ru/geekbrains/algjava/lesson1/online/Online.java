package ru.geekbrains.algjava.lesson1.online;

public class Online {
    static void methodA(int i){ // int i; i = 10;
        // do something
    }

    static void methodB(int[] a){ // int[] a = @123abc
        a[0] = 10;
    }

    static int findMax(int[] arr){ // O(n)
        int r = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (r < arr[i]) r = arr[i];
            for (int j = 0; j < arr.length; j++) {

            }
        }
//        1_000_000 O(1300000000+130000000)
//        for (int i = 0; i < arr.length; i++) {
//            if (r < arr[i]) r = arr[i];
//        }
        return r;
    }



    public static void main(String[] args) {
        int i = 10;
        int j = 15;
        System.out.println(i == j); // 10 == 15



        MyClass m = new MyClass(); // @123abc
        MyClass n = new MyClass(); // @456def
        System.out.println(m == n);
        m.method1();



//        methodA(i); // i ->10; methodA(10);
//
//        int[] arr = {1,2,3,4,5};
//        methodB(arr); // arr -> @123abc; methodB(@123abc)



//        int[] arr = new int[]{1,2,3};
//        int[] a = {1, 2, 3};
//        int[] b = {4, 5, 6};
//        a = b;
//        b[1] = 3;
//        b[2] = 8;
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
    }
}
