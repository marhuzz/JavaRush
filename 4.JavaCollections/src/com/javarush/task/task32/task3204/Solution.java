package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Random random = new Random();
        try{
            stream.write(lower.charAt(random.nextInt(26)));
            stream.write(upper.charAt(random.nextInt(26)));
            stream.write(digits.charAt(random.nextInt(10)));
            stream.write(lower.charAt(random.nextInt(26)));
            stream.write(upper.charAt(random.nextInt(26)));
            stream.write(digits.charAt(random.nextInt(10)));
            stream.write(lower.charAt(random.nextInt(26)));
            stream.write(upper.charAt(random.nextInt(26)));

        }
        catch (Exception e){}
        return stream;
    }
}