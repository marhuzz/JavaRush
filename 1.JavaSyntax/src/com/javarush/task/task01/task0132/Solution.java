package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String s = Integer.toString(number);
        String[] strings = s.split("");
        int result = 0;

        for (int i= 0; i < strings.length;i++){
            result += Integer.parseInt(strings[i]);
        }
        return result;//напишите тут ваш код
    }
}