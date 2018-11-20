package ru.lebedev.se.chat.server.model;

import java.util.UUID;

public final class Message {
    public String id = UUID.randomUUID().toString();
    public long timestamp = System.currentTimeMillis();
    public String source;
    public String target;
    public String text;
}
