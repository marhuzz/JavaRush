package com.javarush.task.task19.task1927;


import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int categoryHotelCount = scanner.nextInt()/5;
        int numHotel = scanner.nextInt();
        int[] rating = new int[numHotel];


        //Вводим рейтинги с консоли
        for (int i = 0; i < numHotel; i++){
            rating[i] = scanner.nextInt();
        }

        //находим максимальный рейтинг
        int maxRating = 0;
        for ( int i = 0; i < numHotel; i++ ) {
            if (rating[i] > rating[maxRating]) {
                maxRating = i;
            }
        }
        //
        for ( int i = 0; i < numHotel; ++i ) {
            double rate = (double)rating[i] / rating[maxRating];
            int stars = ( rate > 0.8 ) ? 5 : ( rate > 0.6 ) ? 4 : ( rate > 0.4 ) ? 3 : ( rate > 0.2 ) ? 2 : 1;

        }

        System.out.println();
        scanner.close();

        }

}
