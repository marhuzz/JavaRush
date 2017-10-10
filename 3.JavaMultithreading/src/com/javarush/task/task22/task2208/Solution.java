package com.javarush.task.task22.task2208;

import java.util.Iterator;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        Iterator<Map.Entry<String,String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> pair = iterator.next();
            if (pair.getValue()!=null){
                stringBuilder.append(pair.getKey()+" = '"+pair.getValue()+"'");
                if (count<params.size()-1){
                    stringBuilder.append(" and ");
                }
            }
            count++;
        }
        return stringBuilder.toString();
    }
}
