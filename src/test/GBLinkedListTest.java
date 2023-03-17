package src.test;

import src.gb.linkedList.GBLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GBLinkedListTest {

    @Test
    void addFirstTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addFirst(10);
        assertEquals(1, expectedTest.size());
        expectedTest.addFirst(15);
        expectedTest.addFirst(1);
        expectedTest.addFirst(30);
        assertEquals(30, expectedTest.get(0));
        assertEquals(1, expectedTest.get(1));
        assertEquals(15, expectedTest.get(2));
        assertEquals(10, expectedTest.get(3));
        assertEquals(5, expectedTest.size());
    }

    @Test
    void addFirstNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addFirst(10);
        expectedTest.addFirst(15);
        expectedTest.addFirst(1);
        expectedTest.addFirst(30);
        assertNotEquals(10, expectedTest.get(0));
        assertNotEquals(30, expectedTest.get(1));
        assertNotEquals(10, expectedTest.get(2));
        assertNotEquals(15, expectedTest.get(3));
    }

    @Test
    void addLastTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addLast(15);
        expectedTest.addLast(25);
        expectedTest.addLast(50);
        assertEquals(50, expectedTest.get(expectedTest.size() - 1));
        assertEquals(25, expectedTest.get(1));
        assertEquals(15, expectedTest.get(0));

    }

    @Test
    void addLastNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addLast(15);
        expectedTest.addLast(25);
        expectedTest.addLast(50);
        assertNotEquals(15, expectedTest.get(expectedTest.size() - 1));
        assertNotEquals(50, expectedTest.get(1));
        assertNotEquals(25, expectedTest.get(0));
    }
    @Test
    void addByIndexTest(){
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(0, 20);
        assertEquals(1, expectedTest.size());
        expectedTest.add(1, 25);
        expectedTest.add(2, 15);
        assertEquals(20, expectedTest.get(0));
        assertEquals(25, expectedTest.get(1));
        assertEquals(15, expectedTest.get(2));
    }
    @Test
    void addByIndexNegativeTest(){
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(0, 20);
        assertNotEquals(0, expectedTest.size());
        expectedTest.add(1, 25);
        expectedTest.add(2, 15);
        assertNotEquals(10, expectedTest.get(0));
        assertNotEquals(25, expectedTest.get(1));
        assertNotEquals(15, expectedTest.get(2));
    }

    @Test
    void removeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(11);
        expectedTest.add(44);
        expectedTest.add(88);
        expectedTest.add(33);
        expectedTest.add(22);
        assertEquals(5, expectedTest.size());
        expectedTest.remove(2);
        assertEquals(4, expectedTest.size());
    }

    @Test
    void removeNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(11);
        expectedTest.add(44);
        expectedTest.add(88);
        expectedTest.add(33);
        expectedTest.add(22);
        assertEquals(5, expectedTest.size());
        expectedTest.remove(2);
        assertNotEquals(5, expectedTest.size());
    }

    @Test
    void getByIndexTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(39);
        expectedTest.add(19);
        expectedTest.add(89);
        assertEquals(39, expectedTest.get(0));
        assertEquals(19, expectedTest.get(1));
        assertEquals(89, expectedTest.get(2));
    }

    @Test
    void getByIndexNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(39);
        expectedTest.add(19);
        expectedTest.add(89);
        assertNotEquals(19, expectedTest.get(0));
        assertNotEquals(19, expectedTest.get(2));
        assertNotEquals(39, expectedTest.get(1));
    }

    @Test
    void sizeTest() {
        GBLinkedList expectedTest = new GBLinkedList();
        expectedTest.add(15);
        expectedTest.add(20);
        expectedTest.add(11);
        assertEquals(3, expectedTest.size());
    }

    @Test
    void sizeNegativeTest() {
        GBLinkedList expectedTest = new GBLinkedList();
        expectedTest.add(15);
        expectedTest.add(20);
        expectedTest.add(11);
        assertNotEquals(4, expectedTest.size());
    }

}