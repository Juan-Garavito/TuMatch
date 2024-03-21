/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieApi;
import com.tumatch.tumatch.model.ResponseApi;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IApiService {
    
    ResponseApi ObtenerPeliculas(String token);
    ResponseApi SearchMovie(String token, String movie);
}
