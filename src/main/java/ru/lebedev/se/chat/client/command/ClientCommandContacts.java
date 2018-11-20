package ru.lebedev.se.chat.client.command;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Contact;
import ru.lebedev.se.chat.server.model.Session;

import java.util.Scanner;
import java.util.Set;

public class ClientCommandContacts extends AbstractClientCommand {

    public ClientCommandContacts(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        final Set<Contact> contacts = chatService.getContacts(session);
        for (final Contact contact : contacts) {
            if (contact == null) continue;
            System.out.println(contact.target);
        }
    }
}
