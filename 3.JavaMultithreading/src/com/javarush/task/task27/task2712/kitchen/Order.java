package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marhuz on 28.03.2017.
 */
public class Order {
    private final int number;
    protected List<Dish> dishes;
    private final Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        number = tablet.getNumber();
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty() || dishes == null){
            return "";
        }
        else {
            return String.format("Your order: [%s] of ",dishes.toString());
        }
    }
}
