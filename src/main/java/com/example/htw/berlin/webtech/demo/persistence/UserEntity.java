package com.example.htw.berlin.webtech.demo.persistence;
import javax.persistence.*;


@Entity(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private int id;

    @Column(name = "first_name" )
    private String firstname;

    @Column(name = "last_name" )
    private String lastname;

    @Column(name = "Email" )
    private String email;

    @Column(name = "password" )
    private String password;

    protected UserEntity() {

    }

    public UserEntity( String firstname, String lastname, String email, String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }
}
