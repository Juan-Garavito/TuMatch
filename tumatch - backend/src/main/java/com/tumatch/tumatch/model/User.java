/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

/**
 *
 * @author juang
 */
public class User {
    private int idUser;
    private String nameUser;
   

    public User(int idUser, String nameUser, UserState userState) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", nameUser=").append(nameUser);
        sb.append('}');
        return sb.toString();
    }


    
}
