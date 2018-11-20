package ru.lebedev.se.chat.server.model;

import java.util.*;

public final class Session {
    public long timestamp = System.currentTimeMillis();
    public String id = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        final boolean checkTimeStamp = Objects.equals(timestamp, session.timestamp);
        final boolean checkSessionId = Objects.equals(id, session.id);
        return checkTimeStamp && checkSessionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, id);
    }
}
