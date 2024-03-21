/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

/**
 *
 * @author juang
 */


public class MovieApi {
    
    private Integer idMovie;
    private String backdrop_path;
    private String title;
    private String overview;
    private String release_date;

    public MovieApi(Integer id, String backdrop_path, String title, String overview, String release_date) {
        this.idMovie = id;
        this.backdrop_path = backdrop_path;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
    }
    

    public Integer getId() {
        return idMovie;
    }

    public void setId(Integer id) {
        this.idMovie = id;
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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "MovieApi{" + "id=" + idMovie + ", backdrop_path=" + backdrop_path + ", title=" + title + ", overview=" + overview + ", release_date=" + release_date + '}';
    }

}
