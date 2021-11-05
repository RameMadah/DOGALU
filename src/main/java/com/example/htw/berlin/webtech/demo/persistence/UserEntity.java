package com.example.htw.berlin.webtech.demo.persistence;


import javax.persistence.*;


@Entity(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private int id;

    @Column(name = "first_name" ,nullable = false)
    private String firstname;

    @Column(name = "last_name" ,nullable = false)
    private String lastname;

    @Column(name = "Email" ,nullable = false)
    private String email;

    protected UserEntity() {

    }

    public int getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity(int id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;


    }
}
