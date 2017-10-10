package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Marhuz on 07.03.2017.
 */
public class Server {
    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();

    public Server(Map<String, Connection> connectionMap) {
        this.connectionMap = connectionMap;
    }

    public static void main (String[] args){
        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){
        ConsoleHelper.writeMessage("Server start!");

        while (true){
            Socket socket = serverSocket.accept();
            Handler handler = new Handler(socket);
            handler.start();
        }
        }
        catch (IOException e){
            ConsoleHelper.writeMessage("Exception server!");
        }


    }

    public static void sendBroadcastMessage(Message message){
        for (String s : connectionMap.keySet()){
            try{
                connectionMap.get(s).send(message);
            }
            catch (IOException e){
                ConsoleHelper.writeMessage("Сообщение не доставлено");
            }
        }

    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler (Socket socket){
            this.socket = socket;
        }

        private String serverHandshake (Connection connection) throws IOException,ClassNotFoundException{
            boolean accepted = false;
            String name = null;
            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String string : connectionMap.keySet()){
                if (!string.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED,string));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT,String.format("%s: %s", userName,message.getData())));
                }
                else {
                    ConsoleHelper.writeMessage("Ошибка!");
                }
            }
        }

        public void run(){
            Connection connection = null;
            String userName = null;
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection,userName);
                serverMainLoop(connection,userName);

            }
            catch (IOException e){
                ConsoleHelper.writeMessage(e.getMessage());
            }
            catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (userName != null){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            }
            ConsoleHelper.writeMessage("Закрыто соединение " + socket.getRemoteSocketAddress());
        }
    }
}
