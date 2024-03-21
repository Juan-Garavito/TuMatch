/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.service;

import com.tumatch.tumatch.model.MovieData;
import com.tumatch.tumatch.repository.MovieRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juang
 */
@Service
@Transactional
public class MovieService implements IMovieService{
    
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieData SaveMovie(MovieData movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public List<MovieData> GetAllMovie() {
        return movieRepository.findAll();
    }
    
}
