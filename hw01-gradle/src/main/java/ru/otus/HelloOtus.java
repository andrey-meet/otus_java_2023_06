package ru.otus;

import com.google.common.collect.Lists;
import java.util.List;

@SuppressWarnings("java:S106")
public class HelloOtus {
    public static void main(String[] args) {

        int first = 10;
        int second = 20;

        Integer[] rest = {30, 40, 50};

        // Список содержит ''first' элемент, за которым следуют элементы
        // массив 'rest'
        List<Integer> firstList = Lists.asList(first, rest);
        System.out.println(firstList);

        // Список содержит ''first' и 'second' элементы, за которыми следует
        // элементы массива 'rest'
        List<Integer> secondList = Lists.asList(first, second, rest);
        System.out.println(secondList);

        // Список содержит элементы массива 'rest'
        List<Integer> list = Lists.asList(null, rest).subList(1, rest.length + 1);
        System.out.println(list);
    }
}
