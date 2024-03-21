    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

/**
 *
 * @author juang
 */
public class MovieState {
    
    MovieApi pelicula;
    User user;
    StateMovie statePelicula;

    public MovieState(MovieApi pelicula, User user, StateMovie statePelicula) {
        this.pelicula = pelicula;
        this.user = user;
        this.statePelicula = statePelicula;
    }

    public MovieApi getPelicula() {
        return pelicula;
    }

    public void setPelicula(MovieApi pelicula) {
        this.pelicula = pelicula;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StateMovie getStatePelicula() {
        return statePelicula;
    }

    public void setStatePelicula(StateMovie statePelicula) {
        this.statePelicula = statePelicula;
    }

    @Override
    public String toString() {
        return "MovieState{" + "pelicula=" + pelicula + ", user=" + user + ", statePelicula=" + statePelicula + '}';
    }

   
    
    
    
}
