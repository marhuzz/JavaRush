package com.javarush.task.task26.task2603;

import java.beans.Customizer;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }
    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int i = 0;
            for (Comparator<T> comparator : comparators){
                i = comparator.compare(o1, o2);
                if (i != 0){
                    break;
                }
            }
            return i;
        }
    }
}
