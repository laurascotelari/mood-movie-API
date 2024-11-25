package com.laurascot.moviesAPI.repositorys;

import org.springframework.stereotype.Repository;

import com.laurascot.moviesAPI.entitys.Movie;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface MovieRepositoryJPA{
    void deleteByName(String name);
    Movie findByName(String name);
    Movie findByReleaseYear(int releaseYear);
    /*private static final Logger log = LoggerFactory.getLogger(MovieRepositoryJPA.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Movie insertMovie(Movie newMovie){
        log.info(String.format("\n\n****************************** insertMovie - %s ", newMovie.getName()));
        em.persist(newMovie);
        return newMovie;
    }

    @Override
    public Movie findByName(String name){
        return em.find(Movie.class, name);
    }

    @Override
    public Movie findByReleaseYear(int releaseYear){
        return em.find(Movie.class, releaseYear);
    }

    @Override
    public List<Movie> findAll(){
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }*/
}
