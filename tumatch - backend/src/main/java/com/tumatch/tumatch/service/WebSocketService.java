/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieState;
import com.tumatch.tumatch.repository.WebSocketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juang
 */
@Service
public class WebSocketService implements IWebSocketService{
    
    @Autowired
    private WebSocketRepository webSocketRepositorio;
    
    public int contarUsuraiosEnTopico(String topic){
        return webSocketRepositorio.ContarConexionTopic(topic);
    }

    @Override
    public void agregarConexionTopico(String topic) {
        webSocketRepositorio.agregarConexion(topic);
    }

    @Override
    public void addMovieStateInTopic(String topic, MovieState movie) {
        webSocketRepositorio.addMovieStateInTopic(topic, movie);
    }

    @Override
    public int countMovieStateInTopic(String topic) {
       return webSocketRepositorio.countMovieStateInTopic(topic);
    }

    @Override
    public List<MovieState> getListMovieStateInTopic(String topic) {
        return webSocketRepositorio.getListMovieStateInTopic(topic);
    }

    @Override
    public void cleanListMovieStateInTopic(String topic) {
       webSocketRepositorio.cleanListMovieStateInTopic(topic);
    }
    
    
}
