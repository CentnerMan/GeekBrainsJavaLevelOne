package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;

public class ClientCommandLogout extends AbstractClientCommand {

    public ClientCommandLogout(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        chatService.signOut(session);
    }
}

