package com.laurascot.moviesAPI.repositorys;

import com.laurascot.moviesAPI.entitys.Movie;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>, MovieRepositoryJPA {
    @SuppressWarnings("null")
    List<Movie> findAll();
}
