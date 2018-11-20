package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;

public class ClientCommandHelp extends AbstractClientCommand {

    public ClientCommandHelp(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("** COMMAND HELP **");
        System.out.println("login (login)");
        System.out.println("logout (logout)");
        System.out.println("users (list of users)");
        System.out.println("send (send a message to another user)");
        System.out.println("broadcast (send message to all users)");
        System.out.println("read (read your messages)");
        System.out.println("contacts (list of contacts)");
        System.out.println("contact-create (create contact)");
        System.out.println("contact-remove (remove contact)");
        System.out.println("contacts-remove (remove all contacts)");
        System.out.println("exit (exit from chat)");
        System.out.println("help (this text)");
        System.out.println("------------------");

    }
}
