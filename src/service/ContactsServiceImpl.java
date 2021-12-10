package service;

import model.Contacts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsServiceImpl implements IService<Contacts> {

    public String FILE_PATH = "C:\\Users\\Lovin\\IdeaProjects\\PhoneBook\\src\\file\\contacts.csv";
    List<Contacts> contactsList = new ArrayList<>();
    @Override
    public List<Contacts> findAll() {
        return contactsList;
    }

    @Override
    public void save(Contacts contacts) {
        contactsList.add(contacts);
    }

    @Override
    public void edit(int index,Contacts contacts) {
        contactsList.set(index,contacts);
    }

    @Override
    public void delete(int index) {
        contactsList.remove(index);
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String contactsLine[] = line.split(",");
                String phone = contactsLine[0];
                String group = contactsLine[1];
                String name = contactsLine[2];
                String gender = contactsLine[3];
                String address = contactsLine[4];
                Contacts contacts = new Contacts(phone,group,name,gender,address);
                save(contacts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for (Contacts contacts:contactsList) {
                fileWriter.write(contacts.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int findIndexByPhone(String phone){
        for (int i = 0; i < contactsList.size(); i++) {
            if(phone.equals(contactsList.get(i).getPhone())){
                return i;
            }
        }
        return -1;
    }
}
