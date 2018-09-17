package lesson7;

import lesson3.Queue;
import lesson3.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }

        @Override
        public String toString() {
            return "V:" + label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph(int size) {
        this.MAX_VERTICES = size;
        this.vertices = new Vertex[MAX_VERTICES];
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size=0;
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

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertices[v].wasVisited = true;
                showVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    public void widthTravers(){
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()){
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                showVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }

    public LinkedList<Vertex> widthFind(char from, char to){
        //создадим лист с путем
        LinkedList<Vertex> way = new LinkedList<>();
        //поищем индекс начальной точки
        int fromIndex=-1;
        int toIndex=-1;
        for (int i = 0; i < size; i++) {
            if (vertices[i].label == from) {
                fromIndex = i;
            }
            if (vertices[i].label == to) {
                toIndex = i;
            }
        }
        //если не нашли индекс - выходим
        if(fromIndex<0 || toIndex <0) {
            System.err.println("одна из точек указана не верно");
            return way;
        }
        // создадим массив, куда будем складывать: ключ - это индекс узла, а значение - его родитель.
        int[] childParent = new int[MAX_VERTICES];
        //созадим очередь для обхода
        Queue queue = new Queue(MAX_VERTICES);
        vertices[fromIndex].wasVisited = true;
        queue.insert(fromIndex);
        outer: while (!queue.isEmpty()){
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                childParent[vNext]=vCurr; // добавим текущему узлу родителя
                //если мы встретили искомый лейбл, выходим
                if(vertices[vNext].label==to) {
                    break outer;
                }
                vertices[vNext].wasVisited = true;
                queue.insert(vNext);
            }
        }
        while(true) {
            way.addFirst(vertices[toIndex]);
            if(toIndex==fromIndex) break;
            toIndex = childParent[toIndex];
        }
        resetFlags();
        return way;
    }

    public String printAdjMatrix() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < adjMatrix.length; i++) {
            str.append((i<10 ? " "+i : i) +": ");
            for (int j = 0; j <  adjMatrix.length; j++) {
                str.append(adjMatrix[i][j]+" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
