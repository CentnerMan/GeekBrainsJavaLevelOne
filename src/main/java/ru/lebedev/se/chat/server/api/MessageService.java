package ru.lebedev.se.chat.server.api;

import ru.lebedev.se.chat.server.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessage(String login);

    void sendBroadCast(String source, String text);

    void sendMessage(String source, String target, String text);

    void cleanMessage(String login);
}
