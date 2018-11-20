package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;

public class ClientCommandBroadcact extends AbstractClientCommand {

    public ClientCommandBroadcact(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("ENTER MESSAGE: ");
        final String message = scanner.nextLine();
        chatService.sendBroadcast(session, message);
    }
}
