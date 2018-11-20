package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;

public class ClientCommandSend extends AbstractClientCommand {

    public ClientCommandSend(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        System.out.println("ENTER LOGIN: ");
        final String login = scanner.nextLine();
        System.out.println("ENTER MESSAGE: ");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }
}
