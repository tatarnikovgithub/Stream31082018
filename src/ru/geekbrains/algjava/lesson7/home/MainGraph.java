package ru.geekbrains.algjava.lesson7.home;



import ru.geekbrains.algjava.lesson2.home.Array;
import ru.geekbrains.algjava.lesson3.online.Queue;
import ru.geekbrains.algjava.lesson3.online.Stack;

import java.util.Arrays;

public class MainGraph {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');
        g.addVertex('i');
        g.addVertex('j');
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(3,0);
        g.addEdge(2,5);
        g.addEdge(5,6);
        g.addEdge(3,7);
        g.addEdge(6,8);
        g.addEdge(6,9);
        g.addEdge(7,9);
        System.out.println();
        System.out.println("-----------");
        g.depthTravers();
        System.out.println();
        System.out.println("-----------");

        Stack shortWay = g.shortWay('a','i');
        if (shortWay != null)
            while (!shortWay.isEmpty()){
                System.out.print((char)shortWay.pop());
                System.out.print((shortWay.isEmpty()) ? "" : "-> ");
            }

        System.out.println();
        Queue q = g.widthTraversPath('a', 'i');
        System.out.println(Arrays.toString(q.getQueue()));

    }
}
