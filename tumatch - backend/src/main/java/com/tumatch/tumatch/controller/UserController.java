/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.controller;

import com.tumatch.tumatch.model.LoginDTO;
import com.tumatch.tumatch.model.UserData;
import com.tumatch.tumatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juang
 */

@RestController
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login.user")
    UserData UserData(@RequestBody LoginDTO user){
        UserData userd  = userService.LoginUser(user.getMail(), user.getPassword());
        return userd;
    }
}
