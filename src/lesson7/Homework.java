package lesson7;

import lesson3.Queue;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        Graph q = new Graph(12);
        q.addVertex('a');
        q.addVertex('b');
        q.addVertex('c');
        q.addVertex('d');
        q.addVertex('e');
        q.addVertex('f');
        q.addVertex('g');
        q.addVertex('h');
        q.addVertex('i');
        q.addVertex('j');

        q.addEdge(0,1);
        q.addEdge(0,2);
        q.addEdge(1,3);
        q.addEdge(1,4);
        q.addEdge(3,0);
        q.addEdge(2,5);
        q.addEdge(5,6);
        q.addEdge(3,7);
        q.addEdge(6,8);
        q.addEdge(6,9);
        q.addEdge(7,9);

        //q.addEdge(3,6);
        q.addEdge(4,8);

        //System.out.println(q.printAdjMatrix());
        System.out.println( q.widthFind('a', 'i') );
    }
}
