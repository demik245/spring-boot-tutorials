package com.demik.springboot.thymeleafdemo.model;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLanguage;

    public Student() {

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteCountry) {
        this.favouriteLanguage = favouriteCountry;
    }

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

}
