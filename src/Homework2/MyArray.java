package Homework2;

import java.util.Comparator;

/**
 * Интерфейс для создания пользовательских списков.
 *
 * @param <E> Тип элементов, хранимых в списке.
 */
public interface MyArray<E> extends Iterable<E> {
    void add(E e);
    void add(int index, E e);
    void remove(int index);
    E get(int index);
    void clear();
    void sort(Comparator<E> comparator);
    int size();
}
