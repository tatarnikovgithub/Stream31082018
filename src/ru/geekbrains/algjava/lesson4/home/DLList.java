package ru.geekbrains.algjava.lesson4.home;

public class DLList<T> {
    private static class Node<Tt> {
        Tt payload;
        Node<Tt> prev;
        Node<Tt> next;

        Node(Tt value) {
            payload = value;
        }
    }

    public class Iterator {
        private Node<T> current;
        void reset() {
            current = head;
        }

        void next() {
            current = current.next;
        }

        Node currentLink() {
            return current;
        }

        boolean atEnd() {
            return current.next == null;
        }

        boolean atStart() {
            return current.prev == null;
        }

        void insertAfter(T value){
            Node<T> temp = new Node<>(value);
            if (!atEnd()) {
                temp.next = current.next;
                current.next.prev = temp;
            } else {
                tail = temp;
            }
            current.next = temp;
            temp.prev = current;
            size++;
        }

        void insertBefore(T value) {
            Node<T> temp = new Node<>(value);
            if (!atStart()) {
                temp.prev = current.prev;
                current.prev.next = temp;
            } else {
                head = temp;
            }
            current.prev = temp;
            temp.next = current;
            size++;
        }

        Node deleteCurrent(){
            Node<T> temp = current;
            if (atStart()) {
                head = current.next;
                head.prev = null;
                reset();
            } else if (atEnd()) {
                tail = current.prev;
                tail.next = null;
                current = current.next;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
            return temp;
        }
    }

    public Iterator iterator;
    private int size;
    private Node<T> head;
    private Node<T> tail;

    DLList() {
        size = 0;
        head = null;
        tail = null;
        iterator = new Iterator();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node<T> current = this.head;
        StringBuilder sb = new StringBuilder("( ");
        while(current != null) {
            sb.append(current.payload);
            sb.append((current.next == null) ? " )" : ", ");
            current = current.next;
        }
        return (sb.toString().equals("( ")) ? null : sb.toString();
    }

    public void insertHead(T value) {
        Node<T> temp = new Node<>(value);
        temp.next = this.head;
        if (!isEmpty())
            this.head.prev = temp;
        else {
            this.tail = temp;
        }
        this.head = temp;
        size++;
    }

    public void insertTail(T value) {
        Node<T> temp = new Node<>(value);
        temp.prev = this.tail;
        if (!isEmpty())
            this.tail.next = temp;
        else {
            this.head = temp;
        }
        this.tail = temp;
        size++;
    }

    public T removeHead() {
        Node<T> temp = this.head;
        if (!isEmpty()) {
            this.head.prev = null;
            this.head = head.next;
            size--;
        }
        if (isEmpty()) {
            this.head = null;
            this.tail = null;
        }
        return temp.payload;
    }

    public T removeTail() {
        Node<T> temp = this.tail;
        if (!isEmpty()) {
            this.tail.next = null;
            this.tail = tail.prev;
            size--;
        }

        if (isEmpty()) {
            this.head = null;
            this.tail = null;
        }
        return temp.payload;
    }


}
