package ru.lebedev.se.chat.client;

public class ChatClient {

    public static void main(String[] args) throws Exception{
        final ClientService service = new ClientService();
        service.run();
    }
}
