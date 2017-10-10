package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i < 10; i++){
            map.put("Rotanov" + i,500);
        }
        return map;//напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() < 500) {
                it.remove();
            }
        }//напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}