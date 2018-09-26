package ru.geekbrains.algjava.lesson7;

import ru.geekbrains.algjava.lesson3.online.Queue;
import ru.geekbrains.algjava.lesson3.online.Stack;

public class Graph {
    private class Vertex {
        char label; // anything useful
        boolean wasVisited; // meta

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "Vertex: " + label;
        }
    }

    private static final int MAX_VERTICES = 32;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph() {
        this.vertices = new Vertex[MAX_VERTICES];
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addAdjacency(int start, int end, int weight) {
        adjMatrix[start][end] = weight;
        adjMatrix[end][start] = weight;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertices[vertex]);
    }

    private int getUnvisitedVertex(int v) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[v][i] == 1 &&
                    !vertices[i].wasVisited)
                return i;
        }
        return -1;
    }

    public void depthTravers() {
        Stack stack = new Stack(size);
        vertices[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertices[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void widthTravers(){
        Queue queue = new Queue(size);
        vertices[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int vNext;
        while(!queue.isEmpty()){
            int vCurr = queue.remove();
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                displayVertex(vNext);
                queue.insert(vNext);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }


}
