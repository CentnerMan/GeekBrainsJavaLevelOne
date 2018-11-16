package ru.lebedev.se.chat.server.service;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.api.MessageService;
import ru.lebedev.se.chat.server.api.SessionService;
import ru.lebedev.se.chat.server.api.UserService;
import ru.lebedev.se.chat.server.model.Message;
import ru.lebedev.se.chat.server.model.Session;
import ru.lebedev.se.chat.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface = "ru.lebedev.se.chat.server.api.ChatService")
public final class ChatServiceBean implements ChatService {

    private final UserService userService = new UserServiceBean();

    private final MessageService messageService = new MessageServiceBean(userService);

    private final SessionService sessionService = new SessionServiceBean(userService);

    @Override
    @WebMethod
    public boolean register(final String login, final String password) {
        return userService.register(login, password);
    }

    @Override
    @WebMethod
    public List<String> getListLogin() {
        return userService.getListLogin();
    }

    @Override
    @WebMethod
    public boolean isLoginExists(final String login) {
        return userService.isLoginExists(login);
    }

    @Override
    @WebMethod
    public Session signIn(String login, String password) {
        return sessionService.signIn(login, password);
    }

    @Override
    @WebMethod
    public User getUser(final Session session) {
        return sessionService.getUser(session);
    }

    @Override
    @WebMethod
    public void signOut(final Session session) {
        sessionService.signOut(session);
    }

    @Override
    @WebMethod
    public List<Message> getMessages(final Session session) {
        final User user = sessionService.getUser(session);
        return messageService.getMessage(user.login);
    }

    @Override
    @WebMethod
    public void sendBroadcast(final Session session, final String message) {
        final User user = sessionService.getUser(session);
        messageService.sendBroadCast(user.login, message);
    }

    @Override
    @WebMethod
    public void sendMessage(final Session session, final String login, final String message) {
        final User source = sessionService.getUser(session);
        final User target = userService.getUser(login);
        messageService.sendMessage(source.login, target.login, message);
    }

    @Override
    @WebMethod
    public void clearMessages(Session session) {
        final User user = sessionService.getUser(session);
        messageService.cleanMessage(user.login);
    }
}
