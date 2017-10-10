package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        if (args[0].compareTo("-c") == 0){

        }
        //start here - начни тут
    }
}
