/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author juang
 */
public abstract class AbstractClient {
    
    @Value("${pelisBaseUrl}")
    public String baseUrl;
    
    public final RestTemplate restTemplate;
    
    public AbstractClient(RestTemplate restTemplate){this.restTemplate = restTemplate;}
    
    public HttpHeaders buildAuthToken(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }
}
