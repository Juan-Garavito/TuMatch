/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieApi;
import com.tumatch.tumatch.model.ResponseApi;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author juang
 */
@Service
public class ApiService extends AbstractClient implements IApiService{

    public ApiService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public ResponseApi ObtenerPeliculas(String token) {
        String uri = this.baseUrl + "/discover/movie?include_adult=false&include_video=false&language=es&page=1&sort_by=popularity.desc";
        HttpEntity<Void> headers = new HttpEntity<>(this.buildAuthToken(token));
        ResponseEntity<ResponseApi> response = restTemplate.exchange(uri, 
                HttpMethod.GET, 
                headers, 
                ResponseApi.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    @Override
    public ResponseApi SearchMovie(String token, String movie) {
        String uri = this.baseUrl + "/search/movie?query="+movie+"&language=es";
        HttpEntity<Void> headers = new HttpEntity<>(this.buildAuthToken(token));
        ResponseEntity<ResponseApi> response = restTemplate.exchange(uri, 
                HttpMethod.GET, 
                headers, 
                ResponseApi.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
    
    
}
