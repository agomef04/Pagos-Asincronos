package com.WebSocket.model.documentElastic;



import com.WebSocket.model.User;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;


@Document(indexName = "new_user")
public class UserElastic{

    private int id;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    private Date date;

    public UserElastic() {

    }

    public UserElastic(int idUser, String email, String password, String name, String phoneNumber) {
        this.id = idUser;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = new Date();
    }

    public UserElastic(String email, String password, String name, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = new Date();
    }

    public UserElastic(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int idUser) {
        this.id = idUser;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

