package ru.software_test.addressbook.model;

public class ContactData {
    private final String fisrtname;
    private final String middlename;
    private final String lastname;
    private final String company;
    private String group;

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

    public String getCompany() {
        return company;
    }

    public  String getGroup() {
        return group;
    }
}
