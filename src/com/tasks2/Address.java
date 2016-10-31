package com.tasks2;

import javax.swing.*;

public class Address {

    private String street;
    private String zip;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void askAll() {
        String street = JOptionPane.showInputDialog("Insert street: ");
        String zip = JOptionPane.showInputDialog("Insert ZIP code: ");
        String city = JOptionPane.showInputDialog("Insert city: ");
        this.setStreet(street);
        this.setZip(zip);
        this.setCity(city);
    }

    public void printAll() {
        System.out.print("Street: " + this.getStreet() + "\n");
        System.out.print("ZIP Code: " + this.getZip() + "\n");
        System.out.print("City: " + this.getCity() + "\n");
    }

    public static void main(String[] args) {

    }
}
