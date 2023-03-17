package src;

import src.gb.linkedList.GBLinkedList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GBLinkedList<Integer> gbLList = new GBLinkedList<>();
        gbLList.addLast(2);
        gbLList.addLast(3);
        gbLList.addLast(4);
        gbLList.addLast(5);
        gbLList.addFirst(1);
        gbLList.addLast(15);
        gbLList.add(0, 100);
        gbLList.remove(0);

        for (Integer integer : gbLList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("Размер списка: " + gbLList.size());

        System.out.println(gbLList.get(0));

        Iterator iterator = gbLList.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}