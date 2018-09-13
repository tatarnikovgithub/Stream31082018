package ru.geekbrains.algjava.lesson3.online;

public class Queue {
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getQueue() {
        return queue;
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    private int maxSize;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Queue(int size) {
        this.maxSize = size;
        this.queue = new int[size];
        this.head = 0;
        this.tail = -1;
        this.items = 0;
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == maxSize;
    }

    public int size(){
        return items;
    }

    public void insert(int i){
        if (isFull()) {
            maxSize *=2;
            int[] temp = new int[maxSize];
            if (tail >= head){
                System.arraycopy(queue, 0, temp, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, temp, 0, tail + 1);
                System.arraycopy(queue, head, temp,
                        size() - (queue.length - head),
                        queue.length - head);
                    head = maxSize - head - 1;
            }
            queue = temp;
        }

        if (tail == maxSize - 1)
            tail = -1;
        queue[++tail] = i;
        items++;
    }

    public int remove(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        if (head == maxSize)
            head = 0;
            items--;
            return temp;
    }

    public int peekFront(){
        return queue[head];
    }
}
