/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tumatch.tumatch.model;

import java.util.List;

/**
 *
 * @author juang
 */
public class ResponseApi {
    
    private List<MovieApi> results;
    private Integer page;

    public ResponseApi(List<MovieApi> results, Integer page) {
        this.results = results;
        this.page = page;
    }

    public List<MovieApi> getResults() {
        return results;
    }

    public void setResults(List<MovieApi> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "RepuestaApi{" + "results=" + results + ", page=" + page + '}';
    }   
    
}
