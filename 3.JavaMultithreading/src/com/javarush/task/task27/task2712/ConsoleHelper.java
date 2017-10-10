package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marhuz on 28.03.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{
       return reader.readLine().toString();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> list = new ArrayList<>();
        writeMessage("Выберите блюда:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда:");
        /*if (reader.readLine().isEmpty()){
            writeMessage("Вы ничего не ввели. пожялуйста введите название блюда");
        }*/
        String input;
        while (!(input = readString()).equalsIgnoreCase("exit")){
            if (input.isEmpty()){
                writeMessage("Вы ввели пустую строку.");
            }
            else {
                try{
                    list.add(Dish.valueOf(input));
                }
                catch (IllegalArgumentException e){
                    writeMessage("Этого нет в меню!");
                }
            }
        }
        return list;
    }
}
