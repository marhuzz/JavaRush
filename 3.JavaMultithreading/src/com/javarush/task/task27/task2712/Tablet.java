package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Marhuz on 28.03.2017.
 */
public class Tablet {
    final int number;
    protected static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void createOrder(){
        try{
            Order order= new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        }
        catch (IOException e){
            logger.log(Level.SEVERE,"Console is unavailable");
        }
    }

    @Override
    public String toString()
    {
        try {
        if (ConsoleHelper.getAllDishesForOrder().isEmpty()) {
            return "";
        } else {
            return "Tablet{number=" + number + "}";
        }
    }
    catch (IOException e){
        return e.toString();
    }
    }
}
