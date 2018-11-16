package ru.lebedev.se.chat.server.service;

import ru.lebedev.se.chat.server.api.UserService;
import ru.lebedev.se.chat.server.model.User;

import java.util.*;

public final class UserServiceBean implements UserService {

    private final Map<String, User> users = new HashMap<>();


    @Override
    public boolean register(String login, String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        if (users.containsKey(login)) return false;
        createUser(login, password);
        return true;
    }

    @Override
    public List<String> getListLogin() {
        return new ArrayList<>(users.keySet());
    }

    @Override
    public User getUser(String login) {
        if (login == null || login.isEmpty()) return null;
        return users.get(login);
    }

    @Override
    public void createUser(final String login, final String password) {
        if (login == null || login.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        if (users.containsKey(login)) return;
        final User user = new User();
        user.login = login;
        user.password = password;
        users.put(login, user);
    }

    @Override
    public int getCountUser() {
        return users.size();
    }

    @Override
    public void removeAll() {
        users.clear();
    }

    @Override
    public boolean isLoginExists(String login) {
        return users.containsKey(login);
    }

    @Override
    public void removeUser(String login) {
        users.remove(login);

    }
}
