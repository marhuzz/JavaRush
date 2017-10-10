package com.javarush.task.task26.task2601;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double mediana = 0;
        if (array.length == 0){
            return array;
        }
        else if (array.length%2 == 0){
            mediana = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;
        }
        else {
            mediana = array[array.length/2];
        }

        final double finalMediana = mediana;
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1- finalMediana) - Math.abs(o2- finalMediana);
                if (value == 0)
                    value = o1 - o2;
                return (int)value;
            }
        });
        System.out.println(mediana);
        return array;
        //implement logic here

    }
}
