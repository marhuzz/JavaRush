package com.javarush.task.task27.task2712.kitchen;

import java.util.ArrayList;

/**
 * Created by Marhuz on 28.03.2017.
 */
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        ArrayList<Dish> list = new ArrayList<>();
        for (Dish dish : Dish.values()){
            list.add(dish);
        }
        return list.toString();
    }
}
