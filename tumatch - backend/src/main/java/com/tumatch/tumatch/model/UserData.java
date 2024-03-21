/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author juang
 */

@Entity
@Table(name = UserData.TABLE_NAME)
public class UserData {
    public static final String TABLE_NAME = "People";
    
    @Id
    @Column(name = "idpeople")
    private int idUser;
    @Column(name = "names")
    private String names;
    @Column(name = "surnames")
    private String surnames;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    

    public UserData() {
    }

    public UserData(int idUser, String names, String surnames, String mail, String password) {
        this.idUser = idUser;
        this.names = names;
        this.surnames = surnames;
        this.mail = mail;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserData{" + "idUser=" + idUser + ", names=" + names + ", surnames=" + surnames + ", mail=" + mail + ", password=" + password + '}';
    }

    
    
}
