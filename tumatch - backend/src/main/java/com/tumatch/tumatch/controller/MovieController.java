/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.controller;

import com.tumatch.tumatch.model.MovieData;
import com.tumatch.tumatch.model.MovieState;
import com.tumatch.tumatch.model.ResponseApi;
import com.tumatch.tumatch.model.StateMovie;
import com.tumatch.tumatch.model.StateUser;
import com.tumatch.tumatch.model.UserState;
import com.tumatch.tumatch.service.ApiService;
import com.tumatch.tumatch.service.MovieService;
import com.tumatch.tumatch.service.WebSocketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juang
 */
@RestController
@CrossOrigin("*")
public class MovieController {
    
    @Autowired
    private ApiService apiService;
    @Autowired
    private WebSocketService webSocketService;    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private MovieService movieService;
    @Value("${tokenApi}")
    private String tokenApi;
    
    
    @GetMapping("/conectar/{idPareja}")
    public int enviarPeliculas(@PathVariable String idPareja){
       webSocketService.agregarConexionTopico("/peliculas/"+idPareja);
       int numUsuarios = webSocketService.contarUsuraiosEnTopico("/peliculas/"+idPareja);
       if(numUsuarios == 2){
           ResponseApi respuesta = apiService.ObtenerPeliculas(tokenApi); 
           messagingTemplate.convertAndSend("/peliculas/"+idPareja,respuesta);      
       }
             
       return numUsuarios;
    }
    
    @PostMapping("/eleccion/{idPareja}")
    public void eleccionPeliculas(@PathVariable String idPareja, @RequestBody MovieState movie){
        webSocketService.addMovieStateInTopic("/eleccion/"+idPareja, movie);
        int numberMovieInTopic = webSocketService.countMovieStateInTopic("/eleccion/"+idPareja);
        
        if(numberMovieInTopic < 2){
            UserState user = new UserState(movie.getUser().getIdUser(), movie.getUser().getNameUser(), StateUser.STOP);
            messagingTemplate.convertAndSend("/peliculas/eleccion/"+idPareja, user); 
            return;
        }
        
        List<MovieState> listMovieState = webSocketService.getListMovieStateInTopic("/eleccion/"+idPareja);
        webSocketService.cleanListMovieStateInTopic("/eleccion/"+idPareja);
        UserState user = new UserState(movie.getUser().getIdUser(), movie.getUser().getNameUser(), StateUser.CONTINUE);
        
        for(MovieState movieState : listMovieState){
            if(movie.getStatePelicula() == StateMovie.REJECTED){
                messagingTemplate.convertAndSend("/peliculas/eleccion/"+idPareja,user); 
                return;
            }   
        }
                
        messagingTemplate.convertAndSend("/peliculas/eleccion/"+idPareja,user); 
    }   
    
    @GetMapping("/search/{movie}")
    public ResponseApi SearchMovie(@PathVariable String movie){
        ResponseApi respuesta = apiService.SearchMovie(tokenApi, movie); 
        return respuesta; 
    }
 
    @PostMapping("/save.movie")
    public MovieData SaveMovie(@RequestBody MovieData movie){
        System.out.println("Movie guardada: " + movie);
        return movieService.SaveMovie(movie);
    }
    
    @GetMapping("/find.movie.all")
    public List<MovieData> GetMovieAll(){
        return movieService.GetAllMovie();
    }
    
    @GetMapping("/prueba")
    public ResponseApi prueba(){
        ResponseApi respuesta = apiService.ObtenerPeliculas(tokenApi);
        return respuesta;
    }
}
    