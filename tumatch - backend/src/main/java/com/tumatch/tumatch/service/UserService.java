/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.UserData;
import com.tumatch.tumatch.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juang
 */
@Service
@Transactional
public class UserService implements IUserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserData LoginUser(String mail, String password) {
        return userRepository.LoginUser(mail, password);
    }
    
}
