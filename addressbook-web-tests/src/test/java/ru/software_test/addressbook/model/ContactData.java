package ru.software_test.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private  Integer id;
    private  String fisrtname;
    private  String middlename;
    private  String lastname;
    private  String company;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String allPhones;
    private String allEmails;
    private String workPhone;
    private String email;
    private String email2;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    private File photo;

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    private String email3;





    public ContactData withFisrtname(String fisrtname) {
        this.fisrtname = fisrtname;
        return this;
    }
    public ContactData withallPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public ContactData withId(Integer id) {
        this.id = id;
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;

    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;

    }
    public ContactData withHomePhone(String home) {
        this.homePhone = home;
        return this;

    }
    public ContactData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;

    }
    public ContactData withWorkPhone(String work) {
        this.workPhone = work;
        return this;

    }
    public ContactData withallEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;

    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;

    }
    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;

    }
    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;

    }
    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }
    public Integer getId() {
        return id;
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
                "id=" + id +
                ", fisrtname='" + fisrtname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fisrtname, that.fisrtname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fisrtname, lastname);
    }

    public String getCompany() {
        return company;
    }

    public  String getGroup() {
        return group;
    }
}
