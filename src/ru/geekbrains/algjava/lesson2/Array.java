package ru.geekbrains.algjava.lesson2;

public class Array {
    private int[] arr;
    private int size;

    public Array(int size){
        this.size = 0;
        this.arr = new int[size];
    }

    void insert(int value){
        if (this.size >= this.arr.length - 1){
            int[] tempArr = this.arr;
            this.arr = new int[this.size * 2];
            System.arraycopy(tempArr, 0, this.arr, 0, size);
        }
        this.arr[this.size++] = value;
    }

    boolean delete(int value){
        int index = getPosition(value);
        if (index != -1){
            System.arraycopy(this.arr, index+1, this.arr, index, this.size-index-1);
            this.size--;
            return true;
        }
        return false;
    }

    int getPosition(int value){
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value)
                return i;
        }
        return -1;
    }

    boolean isInArray(int val){
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == val)
                return true;
        }
        return false;
    }

    public int binSearch(int value){ // O(logN)
        int left = 0;
        int right = this.size - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if (value == this.arr[mid]){
                return mid;
            } else{
                if (value < this.arr[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
    
    private void swap(int a, int b){
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }
    
    public void sortBubble(){ // O(n^2)
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if (this.arr[j] > this.arr[j + 1])
                    swap(j, j + 1);
            }
        }
    }
    public void sortSelect(){
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

    public void sortInsert(){
        int in;
        int out;
        for (out = 1; out < this.size; out++) {
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in - 1] >= temp){
                this.arr[in] = this.arr[in - 1];
                in--;
            }
            this.arr[in] = temp;
        }
    }
}
