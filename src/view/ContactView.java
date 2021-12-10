package view;

import Regex.Regex;
import controller.ContactsController;
import model.Contacts;

import java.util.Scanner;

public class ContactView {
    ContactsController contactsController = new ContactsController();
    public Contacts createContacts(){
    // this.phone = phone;
        //        this.group = group;
        //        this.name = name;
        //        this.gender = gender;
        //        this.address = address;
        String phone = Regex.validate("Enter Phone ", " Phone is number",Regex.PHONE);
        String group = Regex.validateNotNull("Enter Group Contacts ","Group Contacts is not null" );
        String name = Regex.validate("Enter Name ", " Name is character ",Regex.NAME);
        String gender = Regex.validate("Enter Gender ","Gender is not null" ,Regex.GENDER);;
        String address = Regex.validateNotNull("Enter Address ", " Address is is not null ");
        String dateOfBirth = Regex.validate("Enter Date Of Birth ", " Date Of Birth is day/month/year -xx/xx/xxxx ",Regex.DATE);
        String email = Regex.validate("Enter Email ", " Email is abc@abc.abc ",Regex.EMAIL);
        return new Contacts(phone,group,name,gender,address,dateOfBirth,email);
    }
    public void viewDeleteContact (){
        Scanner sc = new Scanner(System.in);
        while (true) {
            String phone = Regex.validate("Enter Phone ", " Phone is number", Regex.PHONE);
            int index = contactsController.findIndexByPhone(phone);
            if (index > -1) {
                System.out.println("Phone Valid, Please enter Y  to  delete contacts or enter any key to back menu");
                String option = sc.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    contactsController.deleteContacts(index);
                    String option2 = Regex.validateNotNull("Delete Success, Please enter any key to continue delete contacts or enter Q to back menu", "option is not null");
                    if (option2.equalsIgnoreCase("q")) {
                        return;
                    }
                }else {
                    return;
                }

            } else {
                String option = Regex.validateNotNull("Phone not found, Please enter any key to re-enter phone or enter Q to back menu","option is not null");
                if (option.equalsIgnoreCase("q")) {
                    return;
                }
            }
        }

    }

    public void viewEdditContact (){
        while (true) {
            String phone = Regex.validate("Enter Phone ", " Phone is number", Regex.PHONE);
            int index = contactsController.findIndexByPhone(phone);
            if (index > -1) {
                contactsController.editContacts(index, createContacts());
                String option = Regex.validateNotNull("Eddit Success, Please enter any key to continue Eddit contacts or enter Q to back menu", "option is not null");

                if (option.equalsIgnoreCase("q")) {
                    return;
                }
            } else {
                String option = Regex.validateNotNull("Phone not found, Please enter any key to re-enter phone or enter Q to back menu","option is not null");
                if (option.equalsIgnoreCase("q")) {
                    return;
                }
            }
        }

    }
    public void viewAddContact (){
        while (true){
            contactsController.saveContacts(createContacts());
            String option = Regex.validateNotNull("Create Contact Success, Please enter any key to continue Create Contact contacts or enter Q to back menu", "option is not null");
            if (option.equalsIgnoreCase("q")) {
                return;
            }
        }
    }
    public void  showListContact (){
        if(contactsController.showContactsList().isEmpty()){
            System.out.println("List Contact is Empty");
        }
        Scanner sc = new Scanner(System.in);
        System.out.format("%-10s %-30s %-30s %-10s %-60s","Phone","Group","Name","Gender","Address");
        for (int i = 0; i < contactsController.showContactsList().size(); i++) {
            String[] line = contactsController.showContactsList().get(i).toString().split(",");
            System.out.format("%-10s %-30s %-30s %-10s %-60s",line[0],line[1],line[2],line[3],line[4]);
            if ((i+1)%5==0){
                System.out.println("Enter any key to continue see list contact ");
                sc.nextLine();
            }
        }
    }
    public void searchListContact (){
        while (true){
            int count =0;
            String phoneAndName = Regex.validateNotNull("Enter Phone or Name ", " Not Null");
            System.out.format("%-10s %-30s %-30s %-10s %-60s","Phone","Group","Name","Gender","Address");
            for (Contacts contact:contactsController.showContactsList()) {
                if(contact.getPhone().contains(phoneAndName)||contact.getName().contains(phoneAndName)){
                    String[] line = contact.toString().split(",");
                    System.out.format("%-10s %-30s %-30s %-10s %-60s",line[0],line[1],line[2],line[3],line[4]);
                    count++;
                }
            }
            if(count==0){
                String option = Regex.validateNotNull("Phone not found, Please enter any key to re-enter phone or enter Q to back menu","option is not null");
                if (option.equalsIgnoreCase("q")) {
                    return;
                }
            }else {
                break;
            }
        }
    }
    public  void viewMenu(){
        while (true){
            System.out.println("Menu");
            System.out.println("1.Show list contact ");
            System.out.println("2.Create contact ");
            System.out.println("3.Update contact ");
            System.out.println("4.Delete contact ");
            System.out.println("5.Search contact ");
            System.out.println("6.Read file ");
            System.out.println("7.Write file ");
            System.out.println("8.Back ");
            int choice = Integer.parseInt(Regex.validate("Enter Choice ","Choice is a number ",Regex.NUMBER));
            switch (choice){
                case 1:showListContact();break;
                case 2:viewAddContact();break;
                case 3:viewEdditContact();break;
                case 4:viewDeleteContact();break;
                case 5:searchListContact();break;
                case 6:contactsController.readFile();break;
                case 7:contactsController.writeToFile();break;
                case 8:return;
            }

        }
    }
}
