package Homework2;

import java.util.Comparator;

/**
 * Класс, реализующий алгоритм быстрой сортировки QuickSort.
 * <p>Класс используется для сортировки любых массивов, используя компаратор для определения порядка сортировки.</p>
 */
public class QuickSort {

    /**
     * Сортирует массив с использованием алгоритма QuickSort.
     *
     * @param array Массив для сортировки.
     * @param size Количество элементов для сортировки.
     * @param comparator Компаратор для определения порядка сортировки.
     * @param <E> Тип элементов массива.
     */
    public static <E> void sort(E[] array, int size, Comparator<E> comparator) {
        if (array == null || size <= 1) {
            return;
        }
        quickSort(array, 0, size - 1, comparator);
    }

    /**
     * Приватный рекурсивный метод для сортировки с использованием QuickSort.
     *
     * @param array Массив для сортировки.
     * @param low Начальный индекс для сортировки.
     * @param high Конечный индекс для сортировки.
     * @param comparator Компаратор для определения порядка сортировки.
     * @param <E> Тип элементов массива.
     */
    private static <E> void quickSort(E[] array, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Разделение массива вокруг опорного элемента.
     *
     * @param array Массив для разделения.
     * @param low Начальный индекс.
     * @param high Конечный индекс.
     * @param comparator Компаратор для определения порядка сортировки.
     * @param <E> Тип элементов массива.
     * @return Индекс нового положения опорного элемента.
     */
    private static <E> int partition(E[] array, int low, int high, Comparator<E> comparator) {
        E pivot = array[high]; 
        int indexForSmallerElements = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                indexForSmallerElements++;
                swap(array, indexForSmallerElements, j);
            }
        }
        swap(array, indexForSmallerElements + 1, high);
        return indexForSmallerElements + 1;
    }

    /**
     * Метод для обмена двух элементов массива.
     *
     * @param array Массив, в котором происходит обмен.
     * @param i Индекс первого элемента.
     * @param j Индекс второго элемента.
     * @param <E> Тип элементов массива.
     */
    private static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}