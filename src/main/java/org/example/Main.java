package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

public class Main {
    public static void main(String[] args) {
        Grocery.startGrocery();

        MobilePhone phone = new MobilePhone("555-1234");
        Contact bob = Contact.createContact("Bob", "31415926");
        phone.addNewContact(bob);
        phone.printContacts();
    }
}
