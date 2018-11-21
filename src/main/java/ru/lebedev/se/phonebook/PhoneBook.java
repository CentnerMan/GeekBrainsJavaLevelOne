package ru.lebedev.se.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private final List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        final PhoneBook phoneBook = new PhoneBook();

        phoneBook.create("Василий", "22222");
        phoneBook.create("Сергей", "11111");
        phoneBook.create("Маша", "33333");

        final Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!"EXIT".equals(command.toUpperCase())) {
            command = scanner.nextLine();

            if ("CREATE".equals(command.toUpperCase())) phoneBook.create();
            if ("SHOW".equals(command.toUpperCase())) phoneBook.show();
            if ("NAME".equals(command.toUpperCase())) phoneBook.findByName();
            if ("PHONE".equals(command.toUpperCase())) phoneBook.findByPhone();
            if ("DELN".equals(command.toUpperCase())) phoneBook.removeByName();
            if ("DELP".equals(command.toUpperCase())) phoneBook.removeByPhone();
            if ("CLEAR".equals(command.toUpperCase())) phoneBook.clear();
        }
        System.out.println("До свидания!");
    }

    //----------------------------------------------------------------------------------------

    public void create() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NAME: ");
        final String name = scanner.nextLine();
        System.out.println("ENTER PHONE: ");
        final String phone = scanner.nextLine();
        create(name, phone);
    }

    //----------------------------------------------------------------------------------------

    public void create(Contact contact) {
        if (contact == null) return;
        contacts.add(contact);
    }

    //----------------------------------------------------------------------------------------

    public void create(String name, String phone) {
        Contact contact = new Contact(name, phone);
        contacts.add(contact);
    }

    //----------------------------------------------------------------------------------------

    public void show() {
        System.out.println(contacts);
    }

    //----------------------------------------------------------------------------------------

    public void clear() {
        contacts.clear();
    }

    //----------------------------------------------------------------------------------------

    public void findByName() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NAME: ");
        final String name = scanner.nextLine();
        findByName(name);
    }

    //----------------------------------------------------------------------------------------

    public void findByName(String name) {
        for (final Contact contact : contacts) {
            if (contact.name.contains(name)) {
                System.out.println(contact);
            }
        }
    }

    //----------------------------------------------------------------------------------------

    public void findByPhone() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER PHONE: ");
        final String phone = scanner.nextLine();
        findByPhone(phone);
    }

    //----------------------------------------------------------------------------------------

    public void findByPhone(String phone) {
        for (final Contact contact : contacts) {
            if (contact.phone.equals(phone)) {
                System.out.println(contact);
            }
        }
    }

    //----------------------------------------------------------------------------------------

    public Contact getByName(String name) {
        for (final Contact contact : contacts) {
            if (contact.name.equals(name)) return contact;
        }
        return null;
    }

    //----------------------------------------------------------------------------------------

    public Contact getByPhone(String phone) {
        for (final Contact contact : contacts) {
            if (contact.phone.equals(phone)) return contact;
        }
        return null;
    }

    //----------------------------------------------------------------------------------------

    public void remove(Contact contact) {
        if (contact == null) return;
        contacts.remove(contact);
    }

    //----------------------------------------------------------------------------------------

    public void removeByName() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NAME: ");
        final String name = scanner.nextLine();
        removeByName(name);
    }

    //----------------------------------------------------------------------------------------

    public void removeByName(String name) {
        remove(getByName(name));
    }

    //----------------------------------------------------------------------------------------

    public void removeByPhone() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER PHONE: ");
        final String phone = scanner.nextLine();
        removeByPhone(phone);
    }

    //----------------------------------------------------------------------------------------

    public void removeByPhone(String phone) {
        remove(getByPhone(phone));
    }

    //----------------------------------------------------------------------------------------

}
