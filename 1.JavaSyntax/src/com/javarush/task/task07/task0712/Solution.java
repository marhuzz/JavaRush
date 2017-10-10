package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,String> stringList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            stringList.put(i,scanner.nextLine());
        }
        String big = stringList.get(0);
        String small = stringList.get(0);
        int keyB = 0;
        int keyS = 0;

        for (Map.Entry<Integer,String> pair : stringList.entrySet()){
            int key = pair.getKey();
            String value = pair.getValue();
            if (big.length() < value.length()){
                big = value;
                keyB = key;
            }
            if (small.length() > value.length()) {
                small = value;
                keyS = key;
            }
        }

        if (keyB > keyS){
            System.out.println(big);
        }
        else if (keyB < keyS){
            System.out.println(small);
        }
        //напишите тут ваш код
    }
}
