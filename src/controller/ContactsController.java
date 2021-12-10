package controller;

import model.Contacts;
import service.ContactsServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContactsController {
    ContactsServiceImpl contactsService = new ContactsServiceImpl();
    public List<Contacts> showContactsList() {
        return contactsService.findAll();
    }
    public void saveContacts(Contacts contacts) {
        contactsService.save(contacts);
    }

    public void editContacts(int index,Contacts contacts) {
        contactsService.edit(index,contacts);
    }


    public void deleteContacts(int index) {
        contactsService.delete(index);
    }

    public void readFile() {
       contactsService.readFile();
    }

    public void writeToFile() {
        contactsService.writeToFile();
    }
    public int findIndexByPhone(String phone){
        return contactsService.findIndexByPhone(phone);
    }
}
