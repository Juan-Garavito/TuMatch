/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.repository;

import com.tumatch.tumatch.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juang
 */
@Repository
public interface UserRepository extends JpaRepository<UserData, Integer>{
    
    @Query("select u from UserData u where u.mail = :mail and u.password = :password")
    UserData LoginUser(@Param("mail") String mail, @Param("password") String password);
}
