package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Marhuz on 11.03.2017.
 */
public class BotClient extends Client {
    public static void main(String[] args){
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        int a = 0; // Начальное значение диапазона - "от"
        int b = 100; // Конечное значение диапазона - "до"

        int random_number = a + (int) (Math.random() * b);
        return "date_bot_"+random_number;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String string[] = message.split(": ");
            if (string.length == 2){
            String name = string[0];
            String text = string[1].toLowerCase();
            String simpleDateFormat = null;

            switch (text){
                case "дата":
                    simpleDateFormat = "d.MM.YYYY";
                    break;
                case "день":
                    simpleDateFormat = "d";
                    break;
                case "месяц":
                    simpleDateFormat = "MMMM";
                    break;
                case "год":
                    simpleDateFormat = "YYYY";
                    break;
                case "время":
                    simpleDateFormat = "H:mm:ss";
                    break;
                case "час":
                    simpleDateFormat = "H";
                    break;
                case "минуты":
                    simpleDateFormat = "m";
                    break;
                case "секунды":
                    simpleDateFormat = "s";
                    break;
            }
            if (simpleDateFormat != null){
                String s = String.format("Информация для %s: %s",name,new SimpleDateFormat(simpleDateFormat).format(Calendar.getInstance().getTime()));
                sendTextMessage(s);
            }
            }


        }
    }
}
