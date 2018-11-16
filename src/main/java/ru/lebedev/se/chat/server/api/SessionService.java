package ru.lebedev.se.chat.server.api;

import ru.lebedev.se.chat.server.model.Session;
import ru.lebedev.se.chat.server.model.User;

public interface SessionService {

    Session signIn(String login, String password);

    User getUser(Session session);

    void signOut(Session session);

}
