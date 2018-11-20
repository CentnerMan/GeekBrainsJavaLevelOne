package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;

public class ClientCommandLogin extends AbstractClientCommand {

    public ClientCommandLogin(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("ENTER LOGIN: ");
        final String login = scanner.nextLine();
        System.out.println("ENTER PASSWORD: ");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = session != null ? "OK" : "ERROR";
        System.out.println("AUTH: " + msg);

    }
}
