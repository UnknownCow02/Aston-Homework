import Homework2.MyArrayList;

public static void main(String[] args) {
    MyArrayList<Integer> list = new MyArrayList<>();

    // Добавление элементов в список
    list.add(1);
    list.add(11);
    list.add(2);
    list.add(5);
    list.add(9);
    list.add(0, 8);
    System.out.println("Add: " + list);

    //Размер списка
    System.out.println("Size: " + list.size());

    //Получение элемента из списка
    System.out.println("Get: "+list.get(2));

    //Удаление элемента из списка
    list.remove(3);
    System.out.println("Remove: " + list);

    //Обычная сортировка
    list.sort(Integer::compareTo);
    System.out.println("Sort: " + list);

    //Алгоритм quicksort
    MyArrayList<Integer> listForQuicksort = new MyArrayList<>();
    listForQuicksort.add(12);
    listForQuicksort.add(3);
    listForQuicksort.add(9);
    listForQuicksort.add(5);
    listForQuicksort.quicksort(Integer::compareTo);
    System.out.println("Quicksort: " + listForQuicksort );

    //Отчистка списка
    list.clear();
    System.out.println("Clear: " + list);

}