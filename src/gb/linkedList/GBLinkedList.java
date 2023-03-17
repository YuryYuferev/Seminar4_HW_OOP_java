package src.gb.linkedList;

import src.gb.impl.GBDeque;
import src.gb.impl.GBList;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T>, GBDeque<T> {
    // модификатор transient указывает на то, что данное свойство класса нельзя сериализировать
    transient int size = 0;
    transient Node<T> first = null;
    transient Node<T> last = null;

    public GBLinkedList() {
    }
    //    В рамках нашего класса нам понадобится вспомогательный приватный Класс Node, вложенный в GBLinkedList.
    //    Он хранит в себе текущий элемент и ссылки на предыдущий и следующий элементы.
    private static class Node<T> {
        T currentEl;
        Node<T> next;
        Node<T> prev;
        //    При каждом добавлении объекта в список создается один новый узел, а также изменяются значения полей связанного
        //    списка (size, first, last) в классе BGLinkedList.
        Node(Node<T> prev, T currentEl, Node<T> next) {
            this.currentEl = currentEl;
            this.next = next;
            this.prev = prev;
        }
    }
    //    Добавляем новый элемент в начало списка - нам нужно объявить временную переменную типа Node<T> и присвоить ей указатель
    //    первый узел(т.е. ссылку на предыдущий элемент, на null).
    //    Далее создаем новый узел(node) где ссылка на предыдущий элемент-это null. Текущему элементу присваиваем значение объекта,
    //    который мы вставляем в список. Ссылке на следующий элемент присваиваем значение переменной temp.
    @Override
    public boolean addFirst(T type) {
        try {
            final Node<T> temp = first;
            final Node<T> newNode = new Node<>(null, type, temp);
            first = newNode;
            if (temp == null)
                last = newNode;
            else
                temp.prev = newNode;
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//    Метод добавления элемента в конец списка.
//    Временной переменной типа Node<T> мы присваиваем указатель на последний элемент.
//    Создаем новый узел, обновляем значения предыдущей ссылки, текущего элемента и ссылки на следующий элемент.
//    Увеличиваем размер списка на 1.
    @Override
    public boolean addLast(T type) {
        try {
            final Node<T> temp = last;
            final Node<T> newNode = new Node<>(temp, type, null);
            last = newNode;
            if (temp == null)
                first = newNode;
            else
                temp.next = newNode;
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // За добавление элемента в конкретную ячейку по индексу отвечает метод add():
    public void add(int index, T type) {
        if (index == size) addLast(type);
        else addBefore(type, node(index));
    }
    // Мы проверяем на то, что индекс, по которому происходит вставка, не выходит за границы списка:
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
    // Метод node() принимает в качестве аргумента индекс, по которому мы хотим вставить элемент и
    //возвращает (ненулевой) узел с указанным индексом элемента.
    Node<T> node(int index) {
        if (index < (size - 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    // После того как найден элемент, перед которым будет вставлен новый элемент, вызывается addBefore()
    private void addBefore(T type, Node<T> succ) {
        Node<T> pred = succ.prev;
        Node<T> newNode = new Node<>(pred, type, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }
    // Mетод удаления по индексу remove()
    @Override
    public void remove(int index) {
        checkPositionIndex(index);
        unlink(node(index));
    }
    // 1. Проверяем на то, что индекс, по которому происходит вставка, не выходит за границы списка. Для
    // этого у нас уже есть метод checkPositionIndex().
    // 2. После этого находится удаляемый элемент с помощью уже знакомого метода node().
    // 3. Далее, в зависимости от расположения элемента, идет 'разлинковка', т.е перебрасывание ссылок,
    // в методе unlink(), который принимает в качестве параметра узла искомого элемента.
    T unlink(Node<T> x) {
        final T element = x.currentEl;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.currentEl = null;
        size--;
        return element;
    }
    // Метод получения значения по индексу get().
    // Проверяем корректность индекса, т.е. находится ли он в пределах нашего списка и через метод node() возвращаем
    // значение необходимого элемента.
    @Override
    public boolean add(T type) {
        addLast(type);
        return true;
    }

    @Override
    public T get(int index) {
        checkPositionIndex(index);
        return node(index).currentEl;
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }
}

