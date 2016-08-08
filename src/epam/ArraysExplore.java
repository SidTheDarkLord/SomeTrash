package epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysExplore {

    //Задание 1.4.1
    void modArrays() {

        //играемся с modifiable и unmodifiable коллекциями

        //коллекции ArrayList модифицируемы
        List<Integer> ar1 = new ArrayList<>();
        ar1.add(5);
        ar1.add(10);
        ar1.add(15);

        for (Integer i : ar1) {
            System.out.print(i + " ");
        }

        System.out.println();
        //создание немодифицируемого списка, при попытке добавления выдает UnsupportedOperationException
        List<Integer> ar2 = Collections.unmodifiableList(ar1);
        ar2.add(20);
        for (Integer i : ar2) {
            System.out.print(i + " ");
        }
    }

   //Задание 2.1
    void singleObList() {

        MyArrayList<Integer> myArray = new MyArrayList<>();

        myArray.add(10);
        myArray.add(15);
        myArray.add(20);

        //не работает итератор, for each тоже не работает
        //работает toString и get(только если перекрыть в MyArrayList)
        System.out.print(myArray);

    }



}
