package ru.lebedev.se.chat.server.api;

import ru.lebedev.se.chat.server.model.Contact;
import ru.lebedev.se.chat.server.model.ContactBox;

public interface ContactService {

    ContactBox contacts(String login);

    Contact create(String source, String target);

    void remove(String source, String target);

    void removeAll(String login);
}
