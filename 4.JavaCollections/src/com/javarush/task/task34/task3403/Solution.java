package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public void recursion(int n) {
        if (n <= 1)
            return;
        for (int i = 2; i <= n; i++)
        {
            if (n % i == 0)
            {
                n = n/i;
                if (n > 1)
                {
                    System.out.print(i + " ");
                    recursion(n);
                    return;
                }
                else
                {
                    System.out.print(i);
                    return;
                }
            }
        }

    }
}
