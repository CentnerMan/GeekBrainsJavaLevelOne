package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Message;
import ru.lebedev.se.chat.server.model.Session;

import java.util.List;
import java.util.Scanner;

public class ClientCommandRead extends AbstractClientCommand {

    public ClientCommandRead(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        final List<Message> messages = chatService.getMessages(session);
        for (final Message message : messages) {
            System.out.println("** INCOME MESSAGE **");
            System.out.println("FROM: " + message.source);
            System.out.println("TEXT: " + message.text);
        }
    }
}