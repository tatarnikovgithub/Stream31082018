package ru.geekbrains.algjava.lesson2.home;

import java.util.Random;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        long t = System.currentTimeMillis();
        //
//        Random rand = new Random();
//        rand.nextInt();
//        System.out.println(System.currentTimeMillis() - t);
    }
    private int[] arr;
    private int size;

    int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(String.format("Requested %d of size %d", index, size));
        return arr[index];
    }

    void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(String.format("Requested %d of size %d", index, size));
        arr[index] = value;
    }

    int length() {
        return size;
    }


    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public Array(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    void insert(int value) {
        if (this.size >= this.arr.length - 1) {
            int[] tempArr = this.arr;
            this.arr = new int[this.size * 2];
            System.arraycopy(tempArr, 0, this.arr, 0, size);
        }
        this.arr[this.size++] = value;
    }

    boolean deleteAll(int value) {          // while we have something to delete = we succeed
        boolean success = false;
        while (delete(value)) {
            success = true;
        }
        return success;
    }

    boolean delete(int value) {
        int index = getPosition(value);
        if (index != -1) {
            System.arraycopy(this.arr, index + 1,
                    this.arr, index, this.size - index - 1);
            this.size--;
            return true;
        }
        return false;
    }

    int getPosition(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value)
                return i;
        }
        return -1;
    }

    boolean isInArray(int val) { //O(n);
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == val)
                return true;
        }
        return false;
    }

    public int binSearch(int value) { //O(logN)
        int left = 0;
        int right = this.size - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (value == this.arr[mid]) {
                return mid;
            } else {
                if (value < this.arr[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    private void swap(int a, int b) {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public void sortBubble() { //O(n^2)
        for (int i = 0; i < this.size; i++) {
            boolean flag = false;                           // check swaps
            for (int j = 0; j < this.size - 1 - i; j++) {   // last is always sorted
                if (this.arr[j] > this.arr[j + 1]) {
                    swap(j, j + 1);
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    public void sortSelect() {
        int p;
        for (int out = 0; out < this.size; out++) {
            p = out;
            for (int in = out; in < this.size; in++) {
                if (this.arr[in] < this.arr[p])
                    p = in;
            }
            swap(out, p);
        }
    }

    public void sortInsert() {
        int in;
        int out;
        for (out = 1; out < this.size; out++) {
            int temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1] >= temp) {
                this.arr[in] = this.arr[in - 1];
                in--;
            }
            this.arr[in] = temp;
        }
    }

    int getMax() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r < arr[i])
                r = arr[i];
        }
        return r;
    }

    int getMin() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r > arr[i])
                r = arr[i];
        }
        return r;
    }
}

