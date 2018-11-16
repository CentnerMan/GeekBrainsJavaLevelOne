package ru.lebedev.se;

import org.junit.Assert;
import org.junit.Test;
import ru.lebedev.se.chat.server.api.ChatService;
import ru.lebedev.se.chat.server.model.Session;
import ru.lebedev.se.chat.server.service.ChatServiceBean;

public class ChatServerTest {

    @Test
    public void testRegister() {
        final ChatService service = new ChatServiceBean();
        Assert.assertTrue(service.register("admin", "admin"));
        Assert.assertFalse(service.register("admin", "admin"));
    }

    @Test
    public void testSignIn() {
        final ChatService service = new ChatServiceBean();
        Assert.assertNull(service.signIn("admin", "admin"));
        service.register("admin", "admin");
        Assert.assertNotNull(service.signIn("admin", "admin"));
    }

    @Test
    public void testSignOut() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");

        final Session sessionAdmin = service.signIn("admin", "admin");
        Assert.assertNotNull(sessionAdmin);
        Assert.assertNotNull(service.getUser(sessionAdmin));
        service.signOut(sessionAdmin);
        Assert.assertNull(service.getUser(sessionAdmin));
    }

    @Test
    public void testSendBroadcast() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");
        service.register("noname", "nopass");

        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendBroadcast(sessionAdmin, "Hello world!");
        Assert.assertTrue(service.getMessages(sessionAdmin).isEmpty());

        final Session sessionTest = service.signIn("test", "test");
        Assert.assertFalse(service.getMessages(sessionTest).isEmpty());
        Assert.assertTrue(service.getMessages(sessionTest).isEmpty());

        final Session sessionNoname = service.signIn("noname", "nopass");
        Assert.assertFalse(service.getMessages(sessionNoname).isEmpty());
        Assert.assertTrue(service.getMessages(sessionNoname).isEmpty());
    }

    @Test
    public void testSendMessage() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");

        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendMessage(sessionAdmin, "test", "Hello world!");
        Assert.assertTrue(service.getMessages(sessionAdmin).isEmpty());

        final Session sessionTest = service.signIn("test", "test");
        Assert.assertFalse(service.getMessages(sessionTest).isEmpty());
        Assert.assertTrue(service.getMessages(sessionTest).isEmpty());

    }
}