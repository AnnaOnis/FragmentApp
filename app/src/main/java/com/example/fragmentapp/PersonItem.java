package com.example.fragmentapp;

public class PersonItem {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int imageResId;

    public PersonItem(String firstName, String lastName, String email, String phone, int imageResId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.imageResId = imageResId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getImageResId() {
        return imageResId;
    }
}
