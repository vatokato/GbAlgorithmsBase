package lesson4;

import java.util.*;

public class Relations {
    public static void main(String[] args) {
        RelatedList<Cat> rl = new RelatedList<>();
        rl.insert(new Cat(1, "Barsik"));
        rl.insert(new Cat(2, "Murzik"));
        rl.insert(new Cat(4, "Kissik"));
        System.out.println(rl);
        System.out.println(rl.remove());
        System.out.println(rl);
        System.out.println(rl.contains(new Cat(2, "Murzik")));

        DoubleLinkedList<Cat> dll = new DoubleLinkedList<>();
        dll.insert(new Cat(1, "Bars"));
        dll.insert(new Cat(1, "Murz"));
        dll.insert(new Cat(1, "Kiss"));
        System.out.println(dll.toString());

        DoubleLinkedList.MyIterator it = dll.iterator();
        System.out.println( "итератор DoubleLinkedList " );

        while(it.hasNext()) {
            System.out.println( it.next() );
        }


//        System.out.println("first: "+it.first());
//        System.out.println("last: "+it.last());


        LinkedList<Cat> ll = new LinkedList<>();
        ll.add(new Cat(1, "Bars"));
        ll.add(new Cat(1, "Murz"));
        ll.add(new Cat(1, "Kiss"));
        Iterator<Cat> iterat = ll.iterator();
        System.out.println( "итератор LinkedList " );

        while(iterat.hasNext()) {
            System.out.println(iterat.next().toString() );
        }


        HashMap<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getKey() + iter.next().getValue());
        }
    }
}
