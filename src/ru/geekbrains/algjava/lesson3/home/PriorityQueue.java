package ru.geekbrains.algjava.lesson3.home;

import ru.geekbrains.algjava.lesson3.online.Queue;

public class PriorityQueue extends Queue{
    public PriorityQueue(int size){
        super(size);
    }

    @Override
    public int remove() {
        int temp = getQueue()[0];
        System.arraycopy(getQueue(), 1, getQueue(), 0, size());
        setMaxSize(size() - 1);
        return temp;
    }

    @Override
    public void insert(int newVal) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        int i;
        for (i = 0; i < size(); i++)
            if (getQueue()[i] > newVal) break;

        System.arraycopy(getQueue(), i, getQueue(), i + 1, size());
        getQueue()[i] = newVal;
        setMaxSize(size() + 1);
    }
}
