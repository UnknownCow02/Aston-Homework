package Homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Реализация динамического списка (аналог ArrayList).
 *
 * @param <E> Тип элементов, хранимых в списке.
 */
public class MyArrayList<E> implements MyArray<E> {
    private E[] elements;
    private int size = 0;

    private final int DEFAULT_CAPACITY = 10;

    /**
     * Создаёт новый список с начальной ёмкостью по умолчанию.
     */
    public MyArrayList() {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Увеличивает ёмкость массива в два раза, если текущая ёмкость недостаточна.
     */
    public void increaseCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент, который нужно добавить.
     */
    @Override
    public void add(E element) {
        increaseCapacity();
        elements[size++] = element;
    }

    /**
     * Вставляет элемент на указанную позицию в списке.
     * Сдвигает последующие элементы вправо.
     *
     * @param index Индекс, куда будет вставлен элемент.
     * @param element Элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы массива.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        increaseCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Удаляет элемент из списка по указанному индексу.
     * Сдвигает последующие элементы влево.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы массива.
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }

        elements[--size] = null;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент на указанной позиции.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы массива.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    /**
     * Удаляет все элементы из списка. После вызова размер списка будет равен 0.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует элементы списка, используя переданный компаратор.
     *
     * @param comparator Компаратор для определения порядка сортировки.
     */
    @Override
    public void sort(Comparator<E> comparator) {
        Arrays.sort(elements, 0, size, comparator);
    }

    /**
     * Сортирует элементы списка при помощи алгоритма quicksort, используя переданный компаратор.
     *
     * @param comparator Компаратор для определения порядка сортировки.
     */
    public void quicksort(Comparator<E> comparator){
        QuickSort.sort(elements,size, comparator);
    }

    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return Количество элементов.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает итератор для перебора элементов списка.
     * Пропускает элементы, равные null.
     *
     * @return Итератор списка.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<>(elements);
    }

    /**
     * Возвращает строковое представление списка.
     * Только заполненные элементы отображаются в строке.
     *
     * @return Строковое представление списка.
     */
    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements,size)) +
                '}';
    }
}
