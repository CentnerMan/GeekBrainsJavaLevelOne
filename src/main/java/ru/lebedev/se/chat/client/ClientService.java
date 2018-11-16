package ru.lebedev.se.chat.client;

import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Message;
import ru.lebedev.se.chat.server.model.Session;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.*;

public class ClientService {

    private static final String CMD_EXIT = "exit";

    private static final String CMD_LOGIN = "login";

    private static final String CMD_LOGOUT = "logout";

    private static final String CMD_READ = "read";

    private static final String CMD_SEND = "send";

    private static final String CMD_USERS = "users";

    private static final String CMD_BROADCAST = "broadcast";

    private static final String CMD_HELP = "help";

    private static final String LOCAL_PART = "ChatServiceBeanService";

    private static final String LOCAL_NAMESPACE = "http://service.server.chat.se.lebedev.ru/";

    private static final String WSDL = "http://localhost:8080/ChatService?wsdl";

    private final URL url;

    private final QName qname;

    private final Service service;

    private final ChatService chatService;

    private final Scanner scanner;

    private Session session = null;

    public ClientService() throws Exception {
        url = new URL(WSDL);
        qname = new QName(LOCAL_NAMESPACE, LOCAL_PART);
        service = Service.create(url, qname);
        chatService = service.getPort(ChatService.class);
        scanner = new Scanner(System.in);
    }

    public void run() {
        String cmd = "";
        while (!CMD_EXIT.equals(cmd)) {
            System.out.println("ENTER CMD: ");
            cmd = scanner.nextLine();
            switch (cmd) {
                case CMD_LOGIN:
                    login();
                    break;

                case CMD_LOGOUT:
                    logout();
                    break;

                case CMD_READ:
                    read();
                    break;

                case CMD_SEND:
                    send();
                    break;

                case CMD_USERS:
                    users();
                    break;

                case CMD_BROADCAST:
                    broadcast();
                    break;

                case CMD_HELP:
                    help();
                    break;
            }
            System.out.println();
        }
    }

    private void login() {
        System.out.println("ENTER LOGIN: ");
        final String login = scanner.nextLine();
        System.out.println("ENTER PASSWORD: ");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = session != null ? "OK" : "ERROR";
        System.out.println("AUTH: " + msg);
    }

    private void logout() {
        chatService.signOut(session);
    }

    private void send() {
        System.out.println("ENTER LOGIN: ");
        final String login = scanner.nextLine();
        System.out.println("ENTER MESSAGE: ");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }

    private void read() {
        final List<Message> messages = chatService.getMessages(session);
        for (final Message message : messages) {
            System.out.println("** INCOME MESSAGE **");
            System.out.println("FROM: " + message.source);
            System.out.println("TEXT: " + message.text);
        }
    }

    private void users() {
        System.out.println(chatService.getListLogin());
    }

    private void broadcast() {
        System.out.println("ENTER MESSAGE: ");
        final String message = scanner.nextLine();
        chatService.sendBroadcast(session, message);
    }

    private void help(){
        System.out.println("** COMMAND HELP **");
        System.out.println("login (login)");
        System.out.println("logout (logout)");
        System.out.println("users (list of users)");
        System.out.println("send (send a message to another user)");
        System.out.println("broadcast (send message to all users)");
        System.out.println("read (read your messages)");
        System.out.println("exit (exit from chat)");
        System.out.println("help (this text)");
        System.out.println("------------------");
    }
}
