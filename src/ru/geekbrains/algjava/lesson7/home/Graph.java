package ru.geekbrains.algjava.lesson7.home;

import ru.geekbrains.algjava.lesson3.online.Queue;
import ru.geekbrains.algjava.lesson3.online.Stack;

public class Graph {
    private class Vertex {
        char label; // anything useful
        boolean wasVisited; // meta
        Vertex parent;

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

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void showVertex(int vertex) {
        System.out.println(vertices[vertex]);
    }

    private int getUncheckedVertex(int v) {
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
        showVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUncheckedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertices[v].wasVisited = true;
                showVertex(v);
                stack.push((char) v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public Queue widthTraversPath(char from, char to) {
        int start = getIndex(from);
        int stop = getIndex(to);

        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        queue.insert(0);
        boolean done = false;
        int vNext;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            int v2;
            while ((v2 = getUncheckedVertex(v1)) != -1) {
                vertices[v2].wasVisited = true;
                if (v2 == stop) {
                    done = true;
                    break;
                }
                queue.insert(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
        if (done)
            return queue;
        else
            return null;
    }

    private int getIndex(char c) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].label == c)
                return i;
        }
        return -1;
    }

    Stack shortWay(char from, char to) {
        Stack result = new Stack(MAX_VERTICES);
        Queue queue = new Queue(MAX_VERTICES);

        int start = getIndex(from);
        int stop = getIndex(to);
        if (start == -1 || stop == -1 || start == stop)
            return null;

        vertices[start].wasVisited = true;
        queue.insert(start);
        while (!queue.isEmpty()) {
            int vCur = queue.remove();
            int vNxt;
            while ((vNxt = getUncheckedVertex(vCur)) != -1) {
                vertices[vNxt].parent = vertices[vCur];
                vertices[vNxt].wasVisited = true;
                if (vNxt == stop) break;
                queue.insert(vNxt);
            }
            if (vNxt == stop) break;
        }
        if (!vertices[stop].wasVisited) return null;

        result.push(vertices[stop].label);
        int current = stop;
        while (vertices[current].parent != null) // идем обратно к старту по родительским нодам
            for (int i = 0; i < vertices.length; i++)
                if (vertices[current].parent == vertices[i]) {
                    result.push(vertices[i].label);
                    current = i;
                    break;
                }

        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
            vertices[i].parent = null;
        }
        return result;
    }


}
