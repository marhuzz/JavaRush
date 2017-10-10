package com.javarush.task.task33.task3308;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marhuz on 24.04.2017.
 */
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public Shop(Goods goods, int count, double profit, String[] secretData) {
        this.goods = goods;
        this.count = count;
        this.profit = profit;
        this.secretData = secretData;
    }

    public static class Goods{
        List<String> names = new ArrayList<>();
    }
}
