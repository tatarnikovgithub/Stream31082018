package ru.geekbrains.algjava.lesson4.online.link;

public class RelatedList {
    private Node head;
    public int size;

    RelatedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(String name, int age){
        Node newNode = new Node(name, age);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Node pop(){
     if (isEmpty()) return null;
     Node temp = head;
     head = head.next;
     size--;
     return temp;
    }

    public Node find(String name, int age){
        Node n = new Node(name, age);
        Node current = head;
        while (!current.equals(n)){
            if (current.next == null) return null;
            else current = current.next;
        }
        return current;
    }

    public Node delete(String name, int age){
        Node n = new Node(name, age);
        Node current = head;
        Node previous = head;
        while (!current.equals(n)){
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;
        return current;
    }

    @Override
    public String toString() {
       Node current = head;
       StringBuilder sb = new StringBuilder("[ ");
       while(current !=null){
           sb.append(current.toString());
           current = current.next;
           sb.append((current == null) ? " ]": ", ");
       }
       return sb.toString();
    }

}
