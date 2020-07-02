package ru.software_test.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private  Integer id;

    @Column(name = "firstname")
    private  String firstname;

    @Column(name = "middlename")
    private  String middlename="";

    @Column(name = "lastname")
    private  String lastname;

    @Transient
    private  String company;


    //@Transient
    //private String group;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",joinColumns = @JoinColumn(name = "id")
            ,inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<>();

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone="";

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone="";

    @Transient
    private String allPhones;

    @Transient
    private String allEmails;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone="";

    @Type(type = "text")
    private String email="";

    @Type(type = "text")
    private String email2="";

    @Type(type = "text")
    private String email3="";

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getEmail() {
        return email;
    }



    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withFisrtname(String fisrtname) {
        this.firstname = fisrtname;
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

    //public ContactData withGroup(String group) {
    //    this.group = group;
    //    return this;

   // }
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

    public String getFirstname() {
        return firstname;
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

   // public  String getGroup() {
     //   return group;
   // }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, homePhone, mobilePhone, workPhone, email, email2, email3);
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                // ", group='" + group + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

}
