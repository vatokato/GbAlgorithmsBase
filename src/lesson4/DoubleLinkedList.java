package lesson4;

import java.util.Objects;

public class DoubleLinkedList<T> {
    private class Node<T> {
        T c;
        Node<T> next;
        Node<T> prev;
        public Node(T c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return c.toString();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<T> node = (Node) o;
            return Objects.equals(c, node.c);
        }
    }

    private Node<T> head;

    public DoubleLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T c) {
        Node<T> n = new Node<>(c);
        n.next = head; // if (head == null) n.next = null;
        if(head!=null)  head.prev = n;
        head = n;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T temp = head.c;
        head = head.next;
        head.prev = null;
        return temp;
    }

    public boolean contains(T c) {
        Node<T> n = new Node<>(c);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public T delete(String name) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!(((Cat)current.c).getName()).equals(name)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
            head.prev = null;
        }
        else {
            previous.next = current.next;
            if(current.next!=null)
                current.next.prev = previous;

        }


        return current.c;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(" prev: "+current.prev+" ");
            sb.append(current);
            sb.append(" next: "+current.next+" ");
            current = current.next;
            sb.append((current == null) ? "]" : "| ");
        }
        return sb.toString();
    }

    public MyIterator iterator() {
        return new MyIterator(this);
    }

    class MyIterator {
        private DoubleLinkedList<T> ddl;
        private Node<T> current;

        public MyIterator (DoubleLinkedList<T> list) {
            this.ddl=list;
            this.current=list.head;
        }

        public boolean hasNext() {
            return this.current!=null;
        }

        public Node<T> next() {
            Node<T> temp = this.current;
            this.current = this.current.next;
            return temp;
        }
    }
}
