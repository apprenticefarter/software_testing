package ru.software_test.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String fisrtname;
    private final String middlename;
    private final String lastname;
    private final String company;
    private String group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(fisrtname, that.fisrtname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fisrtname, lastname);
    }

    public ContactData(String fisrtname, String middlename, String lastname, String company, String group) {
        this.fisrtname = fisrtname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.group = group;
    }

    public String getFisrtname() {
        return fisrtname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fisrtname='" + fisrtname + '\'' +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public  String getGroup() {
        return group;
    }
}
