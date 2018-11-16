package ru.lebedev.se.chat.server.api;

import ru.lebedev.se.chat.server.model.Message;
import ru.lebedev.se.chat.server.model.Session;
import ru.lebedev.se.chat.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ChatService {

    @WebMethod
    boolean register(@WebParam String login, @WebParam String password);

    @WebMethod
    List<String> getListLogin();

    @WebMethod
    boolean isLoginExists(@WebParam String login);

    @WebMethod
    Session signIn(@WebParam String login, @WebParam String password);

    @WebMethod
    User getUser(@WebParam Session session);

    @WebMethod
    void signOut(@WebParam Session session);

    @WebMethod
    List<Message> getMessages(@WebParam Session session);

    @WebMethod
    void sendBroadcast(@WebParam Session session, @WebParam String message);

    @WebMethod
    void sendMessage(@WebParam Session session, @WebParam String login, @WebParam String message);

    @WebMethod
    void clearMessages(@WebParam Session session);
}
