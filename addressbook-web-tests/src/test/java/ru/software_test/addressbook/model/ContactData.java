package ru.software_test.addressbook.model;

import java.util.Objects;

public class ContactData {
    private  String fisrtname;
    private  String middlename;
    private  String lastname;
    private  String company;
    private String group;

    public ContactData withFisrtname(String fisrtname) {
        this.fisrtname = fisrtname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;

    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;

    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;

    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;

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
