/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
            

/**
 *
 * @author juang
 */
@Entity
@Table(name = CoupleData.TABLE_NAME)
public class CoupleData {
    public static final String TABLE_NAME = "Couple";
    
    @Id
    @Column(name = "idcouple")
    private Integer idCouple;
    @OneToOne
    @JoinColumn(name = "idpeopleone")
    private UserData idPeopleOne;
    @OneToOne
    @JoinColumn(name = "idpeopletwo")
    private UserData idPeopleTwo;
   

    public CoupleData() {
    }

    public CoupleData(Integer IdCouple, UserData IdPeopleOne, UserData IdPeopleTwo) {
        this.idCouple = IdCouple;
        this.idPeopleOne = IdPeopleOne;
        this.idPeopleTwo = IdPeopleTwo;
    }

    public Integer getIdCouple() {
        return idCouple;
    }

    public void setIdCouple(Integer IdCouple) {
        this.idCouple = IdCouple;
    }

    public UserData getIdPeopleOne() {
        return idPeopleOne;
    }

    public void setIdPeopleOne(UserData IdPeopleOne) {
        this.idPeopleOne = IdPeopleOne;
    }

    public UserData getIdPeopleTwo() {
        return idPeopleTwo;
    }

    public void setIdPeopleTwo(UserData IdPeopleTwo) {
        this.idPeopleTwo = IdPeopleTwo;
    }


    @Override
    public String toString() {
        return "CoupleData{" + "IdCouple=" + idCouple + ", IdPeopleOne=" + idPeopleOne + ", IdPeopleTwo=" + idPeopleTwo +  '}';
    }
    
    
}
