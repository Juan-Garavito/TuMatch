/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

/**
 *
 * @author juang
 */
public class UserState {
    
    private int idUser;
    private String nameUser;
    StateUser userState;

    public UserState(int idUser, String nameUser, StateUser userState) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.userState = userState;
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

    public StateUser getUserState() {
        return userState;
    }

    public void setUserState(StateUser userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "UserState{" + "idUser=" + idUser + ", nameUser=" + nameUser + ", userState=" + userState + '}';
    }
    
    
}