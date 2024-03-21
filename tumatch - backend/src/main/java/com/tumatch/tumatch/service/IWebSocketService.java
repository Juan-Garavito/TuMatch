/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieState;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IWebSocketService {
    int contarUsuraiosEnTopico(String topic);
    
    void agregarConexionTopico(String topic);
    
    void addMovieStateInTopic(String topic, MovieState movie);
    
    int countMovieStateInTopic(String topic);
    
    List<MovieState> getListMovieStateInTopic(String topic);
    
    void cleanListMovieStateInTopic(String topic);
}
