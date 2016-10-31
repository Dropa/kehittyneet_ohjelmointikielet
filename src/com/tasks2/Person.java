package com.tasks2;

import javax.swing.*;

public class Person {

    private String firstName;
    private String lastName;
    private String ssn;
    private String phone;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void askAll() {
        String firstName = JOptionPane.showInputDialog("Insert first name: ");
        String lastName = JOptionPane.showInputDialog("Insert last name: ");
        String ssn = JOptionPane.showInputDialog("Insert social security number: ");
        String phone = JOptionPane.showInputDialog("Insert phone: ");
        Address address = new Address();
        address.askAll();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSsn(ssn);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public void printAll() {
        System.out.print("First name: " + this.getFirstName() + "\n");
        System.out.print("Last name: " + this.getLastName() + "\n");
        System.out.print("SSN: " + this.getSsn() + "\n");
        System.out.print("Phone: " + this.getPhone() + "\n");
        this.address.printAll();
        System.out.print("\n");
    }

    public Person() {
        this.address = new Address();
    }


    public static void main(String[] args) {
        Person[] persons = new Person[20];
        for (int i = 0; i < persons.length; i++) {
            Person newPerson = new Person();
            newPerson.askAll();
            persons[i] = newPerson;
            int option = JOptionPane.showConfirmDialog(null, "Add another?", "Add another?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                break;
            }
        }
        for (Person person : persons) {
            person.printAll();
        }
    }
}
