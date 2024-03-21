        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author juang
 */

@Entity 
@Table(name = MovieData.TABLE_NAME)
public class MovieData {
    public static final String TABLE_NAME = "Movie";
    
    @Id
    @Column(name = "idmovie")
    private Integer idMovie;
    @Column(name = "cover")
    private String backdrop_path;
    @Column(name = "title")
    private String title;
    @Column(name = "overview")
    private String overview;
    @Column(name = "date")
    private LocalDate release_date;
    @Column(name = "watched") 
    private boolean watched;
    @Column(name = "idcouple")
    private Integer idCouple;
    

    public MovieData() {
    }

    public MovieData(Integer idMovie, String backdrop_path, String title, String overview, LocalDate release_date, boolean watched, Integer idCouple) {
        this.idMovie = idMovie;
        this.backdrop_path = backdrop_path;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.watched = watched;
        this.idCouple = idCouple;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public Integer getIdCouple() {
        return idCouple;
    }

    public void setIdCouple(Integer idCouple) {
        this.idCouple = idCouple;
    }

    @Override
    public String toString() {
        return "MovieData{" + "idMovie=" + idMovie + ", backdrop_path=" + backdrop_path + ", title=" + title + ", overview=" + overview + ", release_date=" + release_date + ", watched=" + watched + ", idCouple=" + idCouple + '}';
    }  
   
}
