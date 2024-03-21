/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.repository;

import com.tumatch.tumatch.model.MovieState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juang
 */
@Repository 
public class WebSocketRepository {
    
    private static HashMap<String, Integer> conexiones = new HashMap<String, Integer>();
    private static HashMap<String, List<MovieState>> moviesState = new HashMap<String, List<MovieState>>(); 

    public WebSocketRepository() {
    }
    
    public  void agregarConexion(String topic){
        
        if (conexiones.containsKey(topic)) {
                int num = conexiones.get(topic);  
                conexiones.replace(topic, num + 1);
        }else{
            conexiones.put(topic, 1);
        }                         
        
    }
    
    public Integer ContarConexionTopic(String topic){
        Integer num = 0;
       
        if(conexiones.containsKey(topic)){
            num =  conexiones.get(topic);
        }        
        
        return num;
    }
    
    public void addMovieStateInTopic(String topic, MovieState movie){
        
        if(moviesState.containsKey(topic)){
            List<MovieState> moviesStateTopic = moviesState.get(topic);
            moviesStateTopic.add(movie);
            moviesState.replace(topic, moviesStateTopic);
        }else{
            List<MovieState> moviesStateTopic = new ArrayList<>();
            moviesStateTopic.add(movie);
            moviesState.put(topic, moviesStateTopic);
        }
    }
    
    public int countMovieStateInTopic(String topic){
        if(moviesState.containsKey(topic)){
            List<MovieState> moviesStateTopic = moviesState.get(topic);
            return moviesStateTopic.size();
        }
        
        return 0;                             
    }
    
    public  List<MovieState> getListMovieStateInTopic(String topic){
        return moviesState.get(topic);
    }
    
    public void cleanListMovieStateInTopic(String topic){
        moviesState.remove(topic);
    }
}
