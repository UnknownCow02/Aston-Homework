package Homework2;

import java.util.Iterator;

/**
 * Итератор для класса MyArrayList.
 * Позволяет обходить элементы списка, пропуская null.
 *
 * @param <E> Тип элементов, хранимых в списке.
 */
public class MyArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] elements;

    /**
     * Создаёт итератор для переданного массива.
     *
     * @param elements Массив, элементы которого будут перебираться.
     */
    MyArrayIterator(E[] elements){
        this.elements = elements;
    }

    /**
     * Проверяет, есть ли в списке следующий элемент, не равный null.
     *
     * @return true, если есть следующий элемент, иначе false.
     */
    @Override
    public boolean hasNext() {
        while (index < elements.length && elements[index] == null) {
            index++;
        }

        return index < elements.length;
    }

    /**
     * Возвращает следующий элемент списка.
     *
     * @return Следующий элемент.
     */
    @Override
    public E next() {
        return elements[index++];
    }
}
