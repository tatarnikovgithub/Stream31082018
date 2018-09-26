package ru.geekbrains.algjava.lesson7;

public class Graphs {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');

        graph.addAdjacency(0,1,1);
        graph.addAdjacency(0,2,1);
        graph.addAdjacency(1,3,1);

        graph.depthTravers(); // a->b->d->*a->c
        System.out.println("-----------");
        graph.widthTravers();
    }
}
