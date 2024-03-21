/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieData;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IMovieService {
    MovieData SaveMovie(MovieData movie);
    List<MovieData> GetAllMovie();
}
