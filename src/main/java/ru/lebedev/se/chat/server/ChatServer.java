package ru.lebedev.se.chat.server;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.service.ChatServiceBean;

import javax.xml.ws.Endpoint;

public class ChatServer {

    public static void main(String[] args) {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");
        service.register("user", "user");
        Endpoint.publish("http://localhost:8080/ChatService?wsdl",service);
    }
}
